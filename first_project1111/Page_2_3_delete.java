package first_project1111;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class Page_2_3_delete extends JFrame {

	private JPanel jp_deleteGUI;
	JTextField jtf_Eno;
	JPasswordField jpf_M_Pwd;

	
	public int LogIn() {	//로그인 결과 정보 숫자로 반환하는 메소드
		
		String jtf_id_in = jtf_Eno.getText();
		
		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<CompanyVO> list = dao.loginEmp(Integer.parseInt(jtf_id_in));
		
		if (list.size() == 0) {
			System.out.println("등록되지 않은 사원");
			return 2;
		}
		
		return 1;
	}
	
	public Page_2_3_delete() {

		setTitle("사원 삭제");
		jp_deleteGUI = new JPanel();
		jp_deleteGUI.setLayout(null);
		jp_deleteGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp_deleteGUI);

		JLabel jl_Eno = new JLabel(" 사원번호");
		jl_Eno.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Eno.setBounds(12, 33, 80, 25);

		jtf_Eno = new JTextField();
		jtf_Eno.setBounds(90, 37, 160, 21);
		jtf_Eno.setColumns(10);

		JLabel jl_Ename = new JLabel(" 관리자 암호");
		jl_Ename.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Ename.setBounds(12, 70, 80, 25);

		jpf_M_Pwd = new JPasswordField();
		jpf_M_Pwd.setColumns(10);
		jpf_M_Pwd.setBounds(90, 74, 160, 21);

		JButton btn_delete = new JButton("삭제");
		btn_delete.setForeground(Color.BLACK);
		btn_delete.setBackground(Color.ORANGE);
		btn_delete.setBounds(168, 115, 75, 21);

		jp_deleteGUI.add(jl_Eno);
		jp_deleteGUI.add(jtf_Eno);
		jp_deleteGUI.add(jl_Ename);
		jp_deleteGUI.add(jpf_M_Pwd);
		jp_deleteGUI.add(btn_delete);

		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				CompanyDAO dao = new CompanyDAO();
				int mPwd = Integer.parseInt(String.valueOf(jpf_M_Pwd.getPassword()));
				
				if(LogIn() == 1) {
					if(dao.selectPwd(Page_1_LogIn.login_eno) == mPwd) {				
						dao.deleteEmp(Integer.parseInt(jtf_Eno.getText()));
						JOptionPane.showMessageDialog(null, "사원이 삭제되었습니다.");
						jtf_Eno.setText("");
						jpf_M_Pwd.setText("");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "관리자 암호 불일치");
						jtf_Eno.setText("");
						jpf_M_Pwd.setText("");
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "등록되지 않은 사원입니다.");
					jtf_Eno.setText("");
					jpf_M_Pwd.setText("");
				}
			}
		});

		setBounds(100, 100, 280, 200);
		setLocation(600, 200); // 실행시 나타날 위치
		setVisible(true);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_2_3_delete frame = new Page_2_3_delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
