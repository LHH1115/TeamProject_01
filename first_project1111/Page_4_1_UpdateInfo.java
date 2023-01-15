package first_project1111;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.crypto.Data;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclEntry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Page_4_1_UpdateInfo extends JFrame {

	private JPanel jp_GUI5;
	Vector<Vector<String>> rowData_career;
	Vector<Vector<String>> rowData_certi;
	Vector<Vector<String>> rowData_eva;
	JTable table_career;
	JTable table_certi;
	JTable table_eva;
	JTextField jtf_picture;
	JTextField jtf_cname;
	JTextField jtf_eno;
	JTextField jtf_ename;
	JTextField jtf_dname;
	JTextField jtf_job;
	JTextField jtf_email;
	JTextField jtf_birth;
	JTextField jtf_addr;
	Image pic;

	JTextField jtf_ssc;
	JTextField jtf_dayoff;
	JTextField jtf_salary;
	JTextField jtf_edu;
	JTextField jtf_hiredate;
	JTextField jtf_resigndate;
	
	Vector<String> vnullCerti;
	Vector<String> vnullEva;
	Vector<String> vnullCareer;
	
	JComboBox<String> jcb_job;
	
	//int clicked_eno = 101;
	String title;

	public void Title() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.detailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.detailPage(clicked_eno);

		for (CompanyVO test : list) {
					
		}
	}
	
	public void InfoEmp() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.detailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.detailPage(clicked_eno);

		for (CompanyVO test : list) {
			jtf_cname.setText(test.getCname());
			jtf_eno.setText(test.getEno() + "");
			jtf_ename.setText(test.getName());
			jtf_dname.setText(test.getDname());
			jtf_job.setText(test.getJob());
			jtf_email.setText(test.getEmail());
			jtf_birth.setText(test.getBirth() + "");
			jtf_addr.setText(test.getAddr() + "");
			pic = test.getPhoto();
		}

	}

	public void MoreInfoEmp() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.MoreDetailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.MoreDetailPage(clicked_eno);

		for (CompanyVO test : list) {
			jtf_ssc.setText(test.getSsc());
			jtf_dayoff.setText(test.getDayoff() + "");
			jtf_salary.setText(test.getSalary() + "");
			jtf_edu.setText(test.getEdu());
			jtf_hiredate.setText(test.getHiredate() + "");
			if(test.getResigndate() == null)
				jtf_resigndate.setText("  -");
			else
				jtf_resigndate.setText(test.getResigndate() + "");
		}

	}

	public void listCareer() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.CareerDetailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.CareerDetailPage(clicked_eno);
				
		for (CompanyVO test : list) {
			Vector<String> v = new Vector<String>();
			v.add(test.getExcname());
			v.add(test.getExdept());
			v.add(test.getExjob());
			v.add(test.getExhiredate() + "");
			v.add(test.getExresigndate() + "");
			rowData_career.add(v);
		}		
	}

	public void listCerti() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.CertiDetailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.CertiDetailPage(clicked_eno);

		for (CompanyVO test : list) {
			Vector<String> v = new Vector<String>();
			v.add(test.getCertiname());
			v.add(test.getCertidate() + "");
			v.add(test.getCertiscore() + "");
			v.add(test.getCertisdate() + "");
			v.add(test.getCertiedate() + "");
			rowData_certi.add(v);
		}
	}

	public void listEva() {
		CompanyDAO dao = new CompanyDAO();

		ArrayList<CompanyVO> list = dao.EvaDetailPage(Page_3_Information.clicked_eno);
		//ArrayList<CompanyVO> list = dao.EvaDetailPage(clicked_eno);
		
		for (CompanyVO test : list) {
			Vector<String> v = new Vector<String>();
			v.add(test.getEvaDate());
			v.add(test.getRespons() + "");
			v.add(test.getBusiperfo() + "");
			v.add(test.getCooper() + "");
			v.add(test.getAttitude() + "");
			v.add(test.getExtrapoint() + "");
			rowData_eva.add(v);
		}
	}

	public Page_4_1_UpdateInfo() {

		setTitle("관리자 수정페이지");
		
		// JPanel 설정
		jp_GUI5 = new JPanel();
		jp_GUI5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp_GUI5);
		jp_GUI5.setLayout(null);

		// JTextField 설정

		JTextField jtf_Tcname = new JTextField(" 회사");
		jtf_Tcname.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tcname.setBorder(new LineBorder(Color.black));
		jtf_Tcname.setBounds(230, 10, 90, 27);
		jtf_Tcname.setEditable(false);

		jtf_cname = new JTextField("");
		jtf_cname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_cname.setBorder(new LineBorder(Color.black));
		jtf_cname.setBounds(319, 10, 223, 27);
		jtf_cname.setEditable(false);

		JTextField jtf_Teno = new JTextField(" 사원번호");
		jtf_Teno.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Teno.setBorder(new LineBorder(Color.black));
		jtf_Teno.setBounds(230, 36, 90, 27);
		jtf_Teno.setEditable(false);

		jtf_eno = new JTextField("");
		jtf_eno.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_eno.setBorder(new LineBorder(Color.black));
		jtf_eno.setBounds(319, 36, 223, 27);
		jtf_eno.setEditable(false);

		JTextField jtf_Tename = new JTextField(" 사원명");
		jtf_Tename.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tename.setBorder(new LineBorder(Color.black));
		jtf_Tename.setBounds(230, 62, 90, 27);
		jtf_Tename.setEditable(false);

		jtf_ename = new JTextField("");
		jtf_ename.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_ename.setBorder(new LineBorder(Color.black));
		jtf_ename.setBounds(319, 62, 223, 27);
		jtf_ename.setEditable(false);

		JTextField jtf_Tdname = new JTextField(" 부서");
		jtf_Tdname.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tdname.setBorder(new LineBorder(Color.black));
		jtf_Tdname.setBounds(230, 88, 90, 27);
		jtf_Tdname.setEditable(false);

		jtf_dname = new JTextField("");
		jtf_dname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_dname.setBorder(new LineBorder(Color.black));
		jtf_dname.setBounds(319, 88, 223, 27);
		jtf_dname.setEditable(false);

		JTextField jtf_Tjob = new JTextField(" 직책");
		jtf_Tjob.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tjob.setBorder(new LineBorder(Color.black));
		jtf_Tjob.setBounds(230, 114, 90, 27);
		jtf_Tjob.setEditable(false);
		
		String data_job[] = { "팀장", "대리", "사원" };
		jcb_job = new JComboBox<String>(data_job);
		jcb_job.setBounds(319, 114, 223, 27);
		jcb_job.setVisible(false);
		jcb_job.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jcb_job.setBorder(new LineBorder(Color.black));
		
		jtf_job = new JTextField("");
		jtf_job.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_job.setBorder(new LineBorder(Color.black));
		jtf_job.setBounds(319, 114, 223, 27);
		jtf_job.setEditable(false);

		JTextField jtf_Temail = new JTextField(" 이메일");
		jtf_Temail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Temail.setBorder(new LineBorder(Color.black));
		jtf_Temail.setBounds(230, 140, 90, 27);
		jtf_Temail.setEditable(false);

		jtf_email = new JTextField("");
		jtf_email.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_email.setBorder(new LineBorder(Color.black));
		jtf_email.setBounds(319, 140, 223, 27);
		jtf_email.setEditable(false);

		JTextField jtf_Tbirth = new JTextField(" 생년월일");
		jtf_Tbirth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tbirth.setBorder(new LineBorder(Color.black));
		jtf_Tbirth.setBounds(230, 166, 90, 27);
		jtf_Tbirth.setEditable(false);

		jtf_birth = new JTextField("");
		jtf_birth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_birth.setBorder(new LineBorder(Color.black));
		jtf_birth.setBounds(319, 166, 223, 27);
		jtf_birth.setEditable(false);

		JTextField jtf_Taddr = new JTextField(" 주소");
		jtf_Taddr.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Taddr.setBorder(new LineBorder(Color.black));
		jtf_Taddr.setBounds(230, 192, 90, 27);
		jtf_Taddr.setEditable(false);

		jtf_addr = new JTextField("");
		jtf_addr.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_addr.setBorder(new LineBorder(Color.black));
		jtf_addr.setBounds(319, 192, 223, 27);
		jtf_addr.setEditable(false);

		InfoEmp();
		
		ImageIcon icon_picture = new ImageIcon(pic);
		Image img = icon_picture.getImage();
		Image changeImg = img.getScaledInstance(190, 209, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel jtf_picture = new JLabel(changeIcon);
		jtf_picture.setBounds(30, 10, 190, 209);
		jp_GUI5.add(jtf_picture);

		JTextField jtf_Tssc = new JTextField(" 주민번호");
		jtf_Tssc.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tssc.setBorder(new LineBorder(Color.black));
		jtf_Tssc.setBounds(30, 224, 90, 27);
		jtf_Tssc.setEditable(false);
		
		jtf_ssc = new JTextField("");
		jtf_ssc.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_ssc.setBorder(new LineBorder(Color.black));
		jtf_ssc.setBounds(119, 224, 166, 27);
		jtf_ssc.setEditable(false);

		JTextField jtf_Tdayoff = new JTextField(" 연가");
		jtf_Tdayoff.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tdayoff.setBorder(new LineBorder(Color.black));
		jtf_Tdayoff.setBounds(30, 250, 90, 27);
		jtf_Tdayoff.setEditable(false);

		jtf_dayoff = new JTextField("");
		jtf_dayoff.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_dayoff.setBorder(new LineBorder(Color.black));
		jtf_dayoff.setBounds(119, 250, 166, 27);
		jtf_dayoff.setEditable(false);

		// 관리자 권한
		JTextField jtf_Tsalary = new JTextField(" 연봉");
		jtf_Tsalary.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tsalary.setBorder(new LineBorder(Color.black));
		jtf_Tsalary.setBounds(30, 276, 90, 27);
		jtf_Tsalary.setEditable(false);

		jtf_salary = new JTextField("");
		jtf_salary.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_salary.setBorder(new LineBorder(Color.black));
		jtf_salary.setBounds(119, 276, 166, 27);
		jtf_salary.setEditable(false);

		JTextField jtf_Tedu = new JTextField(" 학력");
		jtf_Tedu.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tedu.setBorder(new LineBorder(Color.black));
		jtf_Tedu.setBounds(284, 224, 90, 27);
		jtf_Tedu.setEditable(false);

		jtf_edu = new JTextField("");
		jtf_edu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_edu.setBorder(new LineBorder(Color.black));
		jtf_edu.setBounds(373, 224, 169, 27);
		jtf_edu.setEditable(false);

		JTextField jtf_Thiredate = new JTextField(" 입사일자");
		jtf_Thiredate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Thiredate.setBorder(new LineBorder(Color.black));
		jtf_Thiredate.setBounds(284, 250, 90, 27);
		jtf_Thiredate.setEditable(false);

		jtf_hiredate = new JTextField("");
		jtf_hiredate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_hiredate.setBorder(new LineBorder(Color.black));
		jtf_hiredate.setBounds(373, 250, 169, 27);
		jtf_hiredate.setEditable(false);

		JTextField jtf_Tresigndate = new JTextField(" 퇴사일자");
		jtf_Tresigndate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_Tresigndate.setBorder(new LineBorder(Color.black));
		jtf_Tresigndate.setBounds(284, 276, 90, 27);
		jtf_Tresigndate.setEditable(false);

		jtf_resigndate = new JTextField("");
		jtf_resigndate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_resigndate.setBorder(new LineBorder(Color.black));
		jtf_resigndate.setBounds(373, 276, 169, 27);
		jtf_resigndate.setEditable(false);

		JTextField jtf_career = new JTextField("경력사항");
		jtf_career.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_career.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_career.setBorder(new LineBorder(Color.black));
		jtf_career.setBounds(30, 313, 512, 27);
		jtf_career.setEditable(false);

		JButton btn_addCareer = new JButton("+");
		JButton btn_deleteCareer = new JButton("-");
		btn_addCareer.setBounds(400, 316, 55, 21);
		btn_addCareer.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_addCareer.setBackground(Color.ORANGE);
		btn_addCareer.setForeground(Color.BLACK);
		jp_GUI5.add(btn_addCareer);		
		btn_deleteCareer.setBounds(470, 316, 55, 21);
		btn_deleteCareer.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_deleteCareer.setBackground(Color.ORANGE);
		btn_deleteCareer.setForeground(Color.BLACK);
		jp_GUI5.add(btn_deleteCareer);
		
		btn_addCareer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vnullCareer = new Vector<String>();
				vnullCareer.add(null);
				vnullCareer.add(null);
				vnullCareer.add(null);
				vnullCareer.add(null);
				vnullCareer.add(null);
				
				rowData_career.add(vnullCareer);
				table_career.updateUI();
			}
		});
		
		btn_deleteCareer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try{
					((DefaultTableModel)table_career.getModel()).removeRow(table_career.getSelectedRow());
					if(table_career.getRowCount() == 0) {
						vnullCareer = new Vector<String>();
						vnullCareer.add(null);
						vnullCareer.add(null);
						vnullCareer.add(null);
						vnullCareer.add(null);
						vnullCareer.add(null);
						rowData_career.add(vnullCareer);
					}
					
					table_career.updateUI();
				}catch (Exception e2) {
					// TODO: handle exception
				}		
			}
		});

		Vector<String> colNames_career = new Vector<String>();
		colNames_career.add("회사");
		colNames_career.add("부서");
		colNames_career.add("직책");
		colNames_career.add("입사일");
		colNames_career.add("퇴사일");

		rowData_career = new Vector<Vector<String>>();
		table_career = new JTable(rowData_career, colNames_career);
		JScrollPane jsp_career = new JScrollPane(table_career);
		jsp_career.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jsp_career.setBounds(30, 343, 512, 100);

		JTextField jtf_certi = new JTextField("자격증");
		jtf_certi.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_certi.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_certi.setBorder(new LineBorder(Color.black));
		jtf_certi.setBounds(30, 453, 512, 27);
		jtf_certi.setEditable(false);
		
		JButton btn_addCerti = new JButton("+");
		JButton btn_deleteCerti = new JButton("-");
		btn_addCerti.setBounds(400, 456, 55, 21);
		btn_addCerti.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_addCerti.setBackground(Color.ORANGE);
		btn_addCerti.setForeground(Color.BLACK);
		jp_GUI5.add(btn_addCerti);		
		btn_deleteCerti.setBounds(470, 456, 55, 21);
		btn_deleteCerti.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_deleteCerti.setBackground(Color.ORANGE);
		btn_deleteCerti.setForeground(Color.BLACK);
		jp_GUI5.add(btn_deleteCerti);
		
		btn_addCerti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vnullCerti = new Vector<String>();
				vnullCerti.add(null);
				vnullCerti.add(null);
				vnullCerti.add(null);
				vnullCerti.add(null);
				vnullCerti.add(null);
				rowData_certi.add(vnullCerti);
				table_certi.updateUI();
			}
		});
		
		btn_deleteCerti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					((DefaultTableModel)table_certi.getModel()).removeRow(table_certi.getSelectedRow());
					if(table_certi.getRowCount() == 0) {
						vnullCerti = new Vector<String>();
						vnullCerti.add(null);
						vnullCerti.add(null);
						vnullCerti.add(null);
						vnullCerti.add(null);
						vnullCerti.add(null);
						rowData_certi.add(vnullCerti);
					}
					
					table_certi.updateUI();
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		Vector<String> colNames_certi = new Vector<String>();
		colNames_certi.add("자격증이름");
		colNames_certi.add("취득일");
		colNames_certi.add("점수");
		colNames_certi.add("유효기간~");
		colNames_certi.add("~유효기간");

		rowData_certi = new Vector<Vector<String>>();
		table_certi = new JTable(rowData_certi, colNames_certi);
		JScrollPane jsp_certi = new JScrollPane(table_certi);
		jsp_certi.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		jsp_certi.setBounds(30, 483, 512, 100);

		JTextField jtf_eva = new JTextField("인사평가");
		jtf_eva.setHorizontalAlignment(SwingConstants.CENTER);
		jtf_eva.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jtf_eva.setBorder(new LineBorder(Color.black));
		jtf_eva.setBounds(30, 593, 512, 27);
		jtf_eva.setEditable(false);
		
		JButton btn_addEva = new JButton("+");
		JButton btn_deleteEva = new JButton("-");
		btn_addEva.setBounds(400, 596, 55, 21);
		btn_addEva.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_addEva.setBackground(Color.ORANGE);
		btn_addEva.setForeground(Color.BLACK);
		jp_GUI5.add(btn_addEva);		
		btn_deleteEva.setBounds(470, 596, 55, 21);
		btn_deleteEva.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_deleteEva.setBackground(Color.ORANGE);
		btn_deleteEva.setForeground(Color.BLACK);
		jp_GUI5.add(btn_deleteEva);	
		
		btn_addEva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vnullEva = new Vector<String>();
				vnullEva.add(null);
				vnullEva.add(null);
				vnullEva.add(null);
				vnullEva.add(null);
				vnullEva.add(null);
				vnullEva.add(null);
				rowData_eva.add(vnullEva);
				table_eva.updateUI();
			}
		});
		
		btn_deleteEva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					((DefaultTableModel)table_eva.getModel()).removeRow(table_eva.getSelectedRow());
					if(table_eva.getRowCount() == 0) {
						vnullEva = new Vector<String>();
						vnullEva.add(null);
						vnullEva.add(null);
						vnullEva.add(null);
						vnullEva.add(null);
						vnullEva.add(null);
						vnullEva.add(null);
						rowData_eva.add(vnullEva);
				}
				
				table_eva.updateUI();
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		Vector<String> colNames_eva = new Vector<String>();
		colNames_eva.add("평가일");
		colNames_eva.add("책임감");
		colNames_eva.add("업무수행능력");
		colNames_eva.add("협동성");
		colNames_eva.add("근무태도");
		colNames_eva.add("가산점");

		rowData_eva = new Vector<Vector<String>>();
		table_eva = new JTable(rowData_eva, colNames_eva);
		JScrollPane jsp_eva = new JScrollPane(table_eva);
		jsp_eva.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		jsp_eva.setBounds(30, 623, 512, 76);

		JButton btn_mgr = new JButton("수정");
		btn_mgr.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_mgr.setBackground(Color.WHITE);
		btn_mgr.setForeground(Color.RED);
		btn_mgr.setBounds(330, 715, 102, 27);
		
		JButton btn_confirm = new JButton("수정확인");
		btn_confirm.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_confirm.setBackground(Color.WHITE);
		btn_confirm.setForeground(Color.RED);
		btn_confirm.setBounds(440, 715, 102, 27);
		
		btn_addCareer.setVisible(false);
		btn_deleteCareer.setVisible(false);
		btn_addCerti.setVisible(false);
		btn_deleteCerti.setVisible(false);
		btn_addEva.setVisible(false);
		btn_deleteEva.setVisible(false);
		
		if ((Page_1_LogIn.login_eno == Page_3_Information.clicked_eno) || Page_1_LogIn.login_eno < 200) {
			MoreInfoEmp();
			listCareer();
			listCerti();
			listEva();
		}

		btn_mgr.addActionListener(new ActionListener() {	//수정 가능한 텍스트필드로 변경
			public void actionPerformed(ActionEvent e) {
				//jtf_email.setEditable(true);
				//jtf_job.setEditable(true);
				JOptionPane.showMessageDialog(null, "***수정확인 누르기 전 Enter(엔터) 눌러주세요!!***");
				jcb_job.setEditable(false);
				jcb_job.setVisible(true);
				jtf_job.setVisible(false);
				btn_addCareer.setVisible(true);
				btn_deleteCareer.setVisible(true);
				btn_addCerti.setVisible(true);
				btn_deleteCerti.setVisible(true);
				btn_addEva.setVisible(true);
				btn_deleteEva.setVisible(true);
				
				
				
			}
		});
		
		btn_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CompanyDAO dao = new CompanyDAO();				
				
				int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "수정", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					btn_addCareer.setVisible(false);
					btn_deleteCareer.setVisible(false);
					btn_addCerti.setVisible(false);
					btn_deleteCerti.setVisible(false);
					btn_addEva.setVisible(false);
					btn_deleteEva.setVisible(false);
					jcb_job.setEditable(true);
					jcb_job.setVisible(false);
					jtf_job.setVisible(true);
					
				}else if(result == JOptionPane.YES_OPTION) {
				ArrayList<CompanyVO> listCareer = new ArrayList<>();
				Vector<CompanyVO> vCareer = new Vector<>();
				for(Vector<String> tempCareer : rowData_career) {
					CompanyVO voCareer = new CompanyVO();
					voCareer.setExcname(tempCareer.get(0));
					voCareer.setExdept(tempCareer.get(1));
					voCareer.setExjob(tempCareer.get(2));
					voCareer.setExhiredate(tempCareer.get(3));
					voCareer.setExresigndate(tempCareer.get(4));
					
					vCareer.add(voCareer);
				}
				listCareer.addAll(vCareer);
				dao.updateCareer(Page_3_Information.clicked_eno, listCareer);
				//dao.updateCareer(clicked_eno, listCareer);
				System.out.println("경력사항 수정 완료");
				
				ArrayList<CompanyVO> listCerti = new ArrayList<>();
				Vector<CompanyVO> vCerti = new Vector<>();
				for(Vector<String> tempCerti : rowData_certi) {
					CompanyVO voCerti = new CompanyVO();
					voCerti.setCertiname(tempCerti.get(0));
					voCerti.setCertidate(tempCerti.get(1));
					voCerti.setCertiscore(tempCerti.get(2));
					voCerti.setCertisdate(tempCerti.get(3));
					voCerti.setCertiedate(tempCerti.get(4));	
					
					vCerti.add(voCerti);
				}
				listCerti.addAll(vCerti);
				dao.updateCerti(Page_3_Information.clicked_eno, listCerti);
				//dao.updateCerti(clicked_eno, listCerti);
				System.out.println("자격증 수정 완료");
				
				ArrayList<CompanyVO> listEva = new ArrayList<>();
				Vector<CompanyVO> vEva = new Vector<>();
				for(Vector<String> tempEva : rowData_eva) {
					CompanyVO voEva = new CompanyVO();
					voEva.setEvaDate(tempEva.get(0));
					voEva.setRespons(Integer.parseInt(tempEva.get(1)));
					voEva.setBusiperfo(Integer.parseInt(tempEva.get(2)));
					voEva.setCooper(Integer.parseInt(tempEva.get(3)));
					voEva.setAttitude(Integer.parseInt(tempEva.get(4)));
					voEva.setExtrapoint(Integer.parseInt(tempEva.get(5)));
					
					vEva.add(voEva);
				}
				listEva.addAll(vEva);
				dao.updateEva(Page_3_Information.clicked_eno, listEva);
				//dao.updateEva(clicked_eno, listEva);
				System.out.println("인사평가 수정 완료");
				
				dao.updateJob(Page_3_Information.clicked_eno, jcb_job.getSelectedItem()+"");
				System.out.println("직책 수정 완료");
				
				InfoEmp();
				Page_3_Information.upDate3();
				
				
				
				btn_addCareer.setVisible(false);
				btn_deleteCareer.setVisible(false);
				btn_addCerti.setVisible(false);
				btn_deleteCerti.setVisible(false);
				btn_addEva.setVisible(false);
				btn_deleteEva.setVisible(false);
				jcb_job.setEditable(true);
				jcb_job.setVisible(false);
				jtf_job.setVisible(true);
				
				}else {
	
					btn_addCareer.setVisible(false);
					btn_deleteCareer.setVisible(false);
					btn_addCerti.setVisible(false);
					btn_deleteCerti.setVisible(false);
					btn_addEva.setVisible(false);
					btn_deleteEva.setVisible(false);
					jcb_job.setEditable(true);
					jcb_job.setVisible(false);
					jtf_job.setVisible(true);
				}
					
			}
		});

		// JPanel에 +
		jp_GUI5.add(jtf_Tcname);
		jp_GUI5.add(jtf_cname);
		jp_GUI5.add(jtf_Teno);
		jp_GUI5.add(jtf_eno);
		jp_GUI5.add(jtf_Tename);
		jp_GUI5.add(jtf_ename);
		jp_GUI5.add(jtf_Tdname);
		jp_GUI5.add(jtf_dname);
		jp_GUI5.add(jtf_Tjob);
		jp_GUI5.add(jtf_job);
		jp_GUI5.add(jcb_job);
		jp_GUI5.add(jtf_Temail);
		jp_GUI5.add(jtf_email);
		jp_GUI5.add(jtf_Tbirth);
		jp_GUI5.add(jtf_birth);
		jp_GUI5.add(jtf_Taddr);
		jp_GUI5.add(jtf_addr);
		jp_GUI5.add(jtf_Tssc);
		jp_GUI5.add(jtf_ssc);
		jp_GUI5.add(jtf_Tdayoff);
		jp_GUI5.add(jtf_dayoff);
		jp_GUI5.add(jtf_Tsalary);
		jp_GUI5.add(jtf_salary);
		jp_GUI5.add(jtf_Tedu);
		jp_GUI5.add(jtf_edu);
		jp_GUI5.add(jtf_Thiredate);
		jp_GUI5.add(jtf_hiredate);
		jp_GUI5.add(jtf_Tresigndate);
		jp_GUI5.add(jtf_resigndate);
		jp_GUI5.add(jtf_career);
		jp_GUI5.add(jtf_certi);
		jp_GUI5.add(jtf_eva);
		jp_GUI5.add(jsp_career);
		jp_GUI5.add(jsp_certi);
		jp_GUI5.add(jsp_eva);
		jp_GUI5.add(btn_mgr);
		jp_GUI5.add(btn_confirm);

		setBounds(100, 100, 600, 800);
		setLocation(600, 10); // 실행시 나타날 위치
		setVisible(true);
		setResizable(false);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_4_1_UpdateInfo frame = new Page_4_1_UpdateInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
