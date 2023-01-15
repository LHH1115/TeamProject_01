package first_project1111;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Page_3_Information extends JFrame {

	JComboBox<String> jcb_search;
	Vector<String> data_search;
	static Vector<Vector<String>> rowData;
	static JTable table;
	JTextField jtf_empnum;
	JTextField jtf_empname;
	JTextField jtf_empdept;
	JTextField jtf_empjob;
	JTextField jtf_empphone;
	JTextField jtf_empemail;
	Vector<String> vector;
	static int clicked_eno;
	
	public static void upDate3() {
		rowData.clear();
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list1 = dao.tableInfo();

		for (CompanyVO test : list1) {
			Vector<String> v1 = new Vector<String>();
			v1.add(test.getEno() + "");
			v1.add(test.getName());
			v1.add(test.getDname());
			v1.add(test.getJob());
			v1.add(test.getBirth() + "");
			v1.add(test.getExnum());
			v1.add(test.getEmail());
			rowData.add(v1);
		}
		table.updateUI();
	}
	
	public void listInfo() // 클릭 없이 정보 불러올 메소드(조회 버튼에 추가 가능)
	{

		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list2 = dao.tableInfo();

		for (CompanyVO test : list2) {
			Vector<String> v2 = new Vector<String>();
			v2.add(test.getEno() + "");
			v2.add(test.getName());
			v2.add(test.getDname());
			v2.add(test.getJob());
			v2.add(test.getBirth() + "");
			v2.add(test.getExnum());
			v2.add(test.getEmail());
			rowData.add(v2);
		}
	}

	public Page_3_Information() {

		setLayout(new BorderLayout());
		String data_search[] = { "전체","사원명", "부서", "사원번호" };
		JPanel p_search = new JPanel();

		jcb_search = new JComboBox<String>(data_search);
		p_search.setLayout(new BorderLayout());
		p_search.add(jcb_search, BorderLayout.WEST);
		JTextField jtf_search = new JTextField(20);
		p_search.add(jtf_search, BorderLayout.CENTER);
		JButton btn_search = new JButton("조회");
		p_search.add(btn_search, BorderLayout.EAST);

		add(p_search, BorderLayout.NORTH);

		Vector<String> colNames = new Vector<String>();
		colNames.add("사원번호");
		colNames.add("사원명");
		colNames.add("부서");
		colNames.add("직책");
		colNames.add("생년월일");
		colNames.add("내선번호");
		colNames.add("이메일");

		rowData = new Vector<Vector<String>>();
		listInfo();
		table = new JTable(rowData, colNames);
		JScrollPane jsp_information = new JScrollPane(table);
		add(jsp_information, BorderLayout.CENTER);

		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String combo = jcb_search.getSelectedItem().toString();
				CompanyDAO dao = new CompanyDAO();
				rowData.clear();
				
				try {
					switch (combo) {
					case "사원명":

						ArrayList<CompanyVO> list3 = dao.searchAsEname(jtf_search.getText());

						for (CompanyVO test : list3) {
							Vector<String> v = new Vector<String>();
							v.add(test.getEno() + "");
							v.add(test.getName());
							v.add(test.getDname());
							v.add(test.getJob());
							v.add(test.getBirth() + "");
							v.add(test.getExnum());
							v.add(test.getEmail());
							rowData.add(v);
						}
						table.updateUI();
						jtf_search.setText(null);
						break;
					case "부서":

						ArrayList<CompanyVO> list4 = dao.searchAsDname(jtf_search.getText());

						for (CompanyVO test : list4) {
							Vector<String> v = new Vector<String>();
							v.add(test.getEno() + "");
							v.add(test.getName());
							v.add(test.getDname());
							v.add(test.getJob());
							v.add(test.getBirth() + "");
							v.add(test.getExnum());
							v.add(test.getEmail());
							rowData.add(v);
						}
						table.updateUI();
						jtf_search.setText(null);
						break;
					case "사원번호":
						ArrayList<CompanyVO> list5 = dao.searchAsEno(Integer.parseInt(jtf_search.getText()));

						for (CompanyVO test : list5) {
							Vector<String> v = new Vector<String>();
							v.add(test.getEno() + "");
							v.add(test.getName());
							v.add(test.getDname());
							v.add(test.getJob());
							v.add(test.getBirth() + "");
							v.add(test.getExnum());
							v.add(test.getEmail());
							rowData.add(v);
						}

						table.updateUI();

						jtf_search.setText(null);
						break;
						
					case "전체":
						listInfo();
						table.updateUI();
						jtf_search.setText(null);
						break;
					}
				} catch (Exception e2) {

				}
			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				clicked_eno = Integer.valueOf((String) (table.getModel().getValueAt(row, 0)));
				System.out.println("조회한 사원 번호: "+clicked_eno);

				if((Page_1_LogIn.login_eno+"").charAt(0) == '1')
					if(Page_1_LogIn.login_eno == clicked_eno) {
						new Page_4_DetailInfo();
					}else
					new Page_4_1_UpdateInfo();
				else
					new Page_4_DetailInfo();
			}
		});
		table.updateUI();
		setTitle("인사정보");
		setLocation(250, 200); // 실행시 나타날 위치
		setSize(1200, 326);
		setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Page_3_Information();
	}

}
