package first_project1111;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Page_2_1_PwdChange extends JFrame {
	
	JLabel jlb_oldPwd;
	JTextField jtf_oldPwd;
	JPasswordField jpf_oldPwd;
	
	JLabel jlb_newPwd;
	JPasswordField jpf_newPwd;
	
	JLabel jlb_checkNewPwd;
	JPasswordField jpf_checkNewPwd;	//텍스트필드 입력시 특정문구로 표시하게함
	
	int originPwd;
	int oldPwd;
	int newPwd;
	int checkNewPwd;
	
	public int changePwd() {
		CompanyDAO dao = new CompanyDAO();
		
		return dao.ChangePwd(Page_1_LogIn.login_eno, newPwd);
		
	}
	
	public int selectPwd() {
		CompanyDAO dao = new CompanyDAO();
		
		return dao.selectPwd(Page_1_LogIn.login_eno);
	}
	
	public Page_2_1_PwdChange() {
		setLayout(new GridLayout(4,1));
		
		jlb_oldPwd = new JLabel("  기존 암호  ");
		jpf_oldPwd = new JPasswordField(20);
		jpf_oldPwd.setEchoChar('*');	//텍스트필드 입력되는 것들 *로 표시
		
		JPanel p1 = new JPanel();
		p1.add(jlb_oldPwd);
		p1.add(jpf_oldPwd);
		add(p1);
		
		jlb_newPwd = new JLabel("새로운 암호");
		jpf_newPwd = new JPasswordField(20);
		jpf_newPwd.setEchoChar('*');
		
		JPanel p2 = new JPanel();
		p2.add(jlb_newPwd);
		p2.add(jpf_newPwd);
		add(p2);
		
		jlb_checkNewPwd = new JLabel("  암호 확인  ");
		jpf_checkNewPwd = new JPasswordField(20);
		jpf_checkNewPwd.setEchoChar('*');
		
		JPanel p3 = new JPanel();
		p3.add(jlb_checkNewPwd);
		p3.add(jpf_checkNewPwd);
		add(p3);
		
		JButton jbt_change = new JButton("변경");
		add(jbt_change);
		
		System.out.println(selectPwd());
		
		
		setTitle("암호변경");
		setSize(300,200);
		setLocation(1000, 400);	//실행시 나타날 위치
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbt_change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				originPwd = selectPwd();
				oldPwd = Integer.parseInt(String.valueOf(jpf_oldPwd.getPassword()));
				newPwd = Integer.parseInt(String.valueOf(jpf_newPwd.getPassword()));
				checkNewPwd = Integer.parseInt(String.valueOf(jpf_checkNewPwd.getPassword()));
				
				int result = JOptionPane.showConfirmDialog(null, "암호를 변경하시겠습니까?", "암호변경", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					jpf_checkNewPwd.setText("");
					jpf_newPwd.setText("");
					jpf_oldPwd.setText("");
				}
				else if(result == JOptionPane.YES_OPTION) {
				if(originPwd == oldPwd) {
					if (newPwd == checkNewPwd) {
						if(changePwd() == 0) {
							System.out.println("암호변경 완료");
							JOptionPane.showMessageDialog(null, "암호변경 완료");
						}else if(changePwd() == 1){
							System.out.println("암호변경 실패");
						}else
							System.out.println("DB 오류");
					}else if(newPwd != checkNewPwd) {
						JOptionPane.showMessageDialog(null, "암화확인 불일치");
					}
				}else {
					JOptionPane.showMessageDialog(null, "기존 암호 불일치");
				}
				jpf_checkNewPwd.setText("");
				jpf_newPwd.setText("");
				jpf_oldPwd.setText("");
				}
				else {
					jpf_checkNewPwd.setText("");
					jpf_newPwd.setText("");
					jpf_oldPwd.setText("");
				}
			}
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Page_2_1_PwdChange();
	}

}