package first_project1111;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class Page_2_Menu extends JFrame {

	private JPanel jp_GUI2;

	public Page_2_Menu() {
		
		setTitle("메뉴");
		jp_GUI2 = new JPanel();
		jp_GUI2.setLayout(null);
		jp_GUI2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp_GUI2);
		
		
		JLabel jl_cname = new JLabel("sayout 인사관리");
		jl_cname.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		jl_cname.setBounds(50, 10, 300, 39);
		

		JButton btn_pwdChange = new JButton("비밀번호 변경");
		btn_pwdChange.setForeground(Color.BLACK);
		btn_pwdChange.setBackground(Color.ORANGE);
		btn_pwdChange.setBounds(28, 80, 137, 56);
	
		JButton btn_select = new JButton("사원조회");
		btn_select.setBackground(Color.ORANGE);
		btn_select.setBounds(196, 80, 137, 56);
		
		JButton btn_insert = new JButton("사원 등록");
		btn_insert.setForeground(Color.BLACK);
		btn_insert.setBackground(Color.ORANGE);
		btn_insert.setBounds(28, 179, 137, 56);
		
		JButton btn_delete = new JButton("사원 삭제");
		btn_delete.setForeground(Color.BLACK);
		btn_delete.setBackground(Color.ORANGE);
		btn_delete.setBounds(196, 179, 137, 56);
		
		jp_GUI2.add(jl_cname);
		jp_GUI2.add(btn_select);
		jp_GUI2.add(btn_pwdChange);
		jp_GUI2.add(btn_insert);
		jp_GUI2.add(btn_delete);
		
		
		
		btn_pwdChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page_2_1_PwdChange();
			}
		});
		
		btn_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page_3_Information();
			}
		});
		
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Page_1_LogIn.login_eno+"").charAt(0) == '1')
					new Page_2_2_insert();
				else
					JOptionPane.showMessageDialog(null, "사원 등록이 불가능한 계정입니다.");
				
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Page_1_LogIn.login_eno+"").charAt(0) == '1')
					new Page_2_3_delete();
				else
					JOptionPane.showMessageDialog(null, "사원 삭제 불가능한 계정입니다.");
				
			}
		});
		
		setBounds(100, 100, 375, 320);
		setLocation(600, 200);	//실행시 나타날 위치
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_2_Menu frame = new Page_2_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
