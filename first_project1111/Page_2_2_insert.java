package first_project1111;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Page_2_2_insert extends JFrame {

	private JPanel jp_GUI4;
	Vector<Vector<String>> rowData_career;
	Vector<Vector<String>> rowData_certi;
	Vector<Vector<String>> rowData_eva;
	JTable table_career;
	JTable table_certi;
	JTable table_eva;
	JLabel jl_picture;
	JTextField jtf_exnumb;
	JTextField jtf_eno;
	JTextField jtf_ename;
	JTextField jtf_dname;
	JTextField jtf_job;
	JTextField jtf_email;
	JTextField jtf_birth;
	JTextField jtf_addr;

	JTextField jtf_ssc;
	JTextField jtf_dayoff;
	JTextField jtf_salary;
	JTextField jtf_edu;
	JTextField jtf_hiredate;
	JTextField jtf_resigndate;
	private JTextField jtf_exCname;
	private JTextField jtf_exDept;
	private JTextField jtf_exJob;
	private JTextField jtf_exHiredate;
	private JTextField jtf_exResigndate;
	private JTextField jtf_certisDate;
	private JTextField jtf_CertiName;
	private JTextField jtf_CertiScore;
	private JTextField jtf_CertieDate;
	private JTextField jtf_certiDate;
	private JTextField jtf_EvaRespons;
	private JTextField jtf_EvaBusiperfo;
	private JTextField jtf_EvaCooper;
	private JTextField jtf_EvaAttitude;
	private JTextField jtf_EvaExtrapoint;

	JButton addPic_btn;
	static JFrame frame;
	static FileDialog fd;
	String imageFilePath;
	FileInputStream fis;
	
	public Page_2_2_insert() {

		setTitle("사원 추가");

		// JPanel 설정
		jp_GUI4 = new JPanel();
		jp_GUI4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp_GUI4);
		jp_GUI4.setLayout(null);
				
		// JLabel 설정
		addPic_btn = new JButton("사진추가");
		addPic_btn.setBounds(30, 10, 190, 209);
		jp_GUI4.add(addPic_btn);
		
		addPic_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fd = new FileDialog(frame, "파일 열기",0);
				fd.setDirectory("C:");
				fd.setVisible(true);
				 
				imageFilePath = fd.getDirectory()+fd.getFile();
				
				try {
					fis = new FileInputStream(imageFilePath);
					byte[]imagedata = Files.readAllBytes(new File(imageFilePath).toPath());
					Image pic = Toolkit.getDefaultToolkit().createImage(imagedata);
					ImageIcon icon_picture = new ImageIcon(pic);
					Image img = icon_picture.getImage();
					Image changeImg = img.getScaledInstance(190, 209, Image.SCALE_SMOOTH);
					ImageIcon changeIcon = new ImageIcon(changeImg);
					addPic_btn.setVisible(false);
					JLabel jl_picture = new JLabel(changeIcon);
					jl_picture.setBounds(30, 10, 190, 209);
					jp_GUI4.add(jl_picture);
				}catch(Exception ex){
					System.out.println("오류 "+ex.getMessage());
				}
			}
		});

		JLabel jl_Tcname = new JLabel(" 내선번호");
		jl_Tcname.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tcname.setBorder(new LineBorder(Color.black));
		jl_Tcname.setBounds(230, 192, 90, 27);

		jtf_exnumb = new JTextField();
		jtf_exnumb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_exnumb.setBorder(new LineBorder(Color.black));
		jtf_exnumb.setBounds(319, 192, 223, 27);

		JLabel jl_Teno = new JLabel(" 사원번호");
		jl_Teno.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Teno.setBorder(new LineBorder(Color.black));
		jl_Teno.setBounds(230, 10, 90, 27);

		jtf_eno = new JTextField();
		jtf_eno.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_eno.setBorder(new LineBorder(Color.black));
		jtf_eno.setBounds(319, 10, 223, 27);

		JLabel jl_Tename = new JLabel(" 사원명");
		jl_Tename.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tename.setBorder(new LineBorder(Color.black));
		jl_Tename.setBounds(230, 36, 90, 27);

		jtf_ename = new JTextField();
		jtf_ename.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_ename.setBorder(new LineBorder(Color.black));
		jtf_ename.setBounds(319, 36, 223, 27);

		JLabel jl_Tdname = new JLabel(" 부서");
		jl_Tdname.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tdname.setBorder(new LineBorder(Color.black));
		jl_Tdname.setBounds(230, 62, 90, 27);

		jtf_dname = new JTextField();
		jtf_dname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_dname.setBorder(new LineBorder(Color.black));
		jtf_dname.setBounds(319, 62, 223, 27);

		JLabel jl_Tjob = new JLabel(" 직책");
		jl_Tjob.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tjob.setBorder(new LineBorder(Color.black));
		jl_Tjob.setBounds(230, 88, 90, 27);

		jtf_job = new JTextField();
		jtf_job.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_job.setBorder(new LineBorder(Color.black));
		jtf_job.setBounds(319, 88, 223, 27);

		JLabel jl_Temail = new JLabel(" 이메일");
		jl_Temail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Temail.setBorder(new LineBorder(Color.black));
		jl_Temail.setBounds(230, 114, 90, 27);

		jtf_email = new JTextField();
		jtf_email.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_email.setBorder(new LineBorder(Color.black));
		jtf_email.setBounds(319, 114, 223, 27);

		JLabel jl_Tbirth = new JLabel(" 생년월일");
		jl_Tbirth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tbirth.setBorder(new LineBorder(Color.black));
		jl_Tbirth.setBounds(230, 140, 90, 27);

		jtf_birth = new JTextField();
		jtf_birth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_birth.setBorder(new LineBorder(Color.black));
		jtf_birth.setBounds(319, 140, 223, 27);

		JLabel jl_Taddr = new JLabel(" 주소");
		jl_Taddr.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Taddr.setBorder(new LineBorder(Color.black));
		jl_Taddr.setBounds(230, 166, 90, 27);

		jtf_addr = new JTextField();
		jtf_addr.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_addr.setBorder(new LineBorder(Color.black));
		jtf_addr.setBounds(319, 166, 223, 27);

		// 관리자 권한
		JLabel jl_Tssc = new JLabel(" 주민번호");
		jl_Tssc.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tssc.setBorder(new LineBorder(Color.black));
		jl_Tssc.setBounds(30, 224, 90, 27);

		jtf_ssc = new JTextField();
		jtf_ssc.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_ssc.setBorder(new LineBorder(Color.black));
		jtf_ssc.setBounds(119, 224, 166, 27);

		JLabel jl_Tdayoff = new JLabel(" 연가");
		jl_Tdayoff.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tdayoff.setBorder(new LineBorder(Color.black));
		jl_Tdayoff.setBounds(30, 250, 90, 27);

		jtf_dayoff = new JTextField();
		jtf_dayoff.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_dayoff.setBorder(new LineBorder(Color.black));
		jtf_dayoff.setBounds(119, 250, 166, 27);

		JLabel jl_Tsalary = new JLabel(" 연봉");
		jl_Tsalary.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tsalary.setBorder(new LineBorder(Color.black));
		jl_Tsalary.setBounds(30, 276, 90, 27);

		jtf_salary = new JTextField();
		jtf_salary.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_salary.setBorder(new LineBorder(Color.black));
		jtf_salary.setBounds(119, 276, 166, 27);

		JLabel jl_Tedu = new JLabel(" 학력");
		jl_Tedu.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tedu.setBorder(new LineBorder(Color.black));
		jl_Tedu.setBounds(284, 224, 90, 27);

		jtf_edu = new JTextField();
		jtf_edu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_edu.setBorder(new LineBorder(Color.black));
		jtf_edu.setBounds(373, 224, 169, 27);

		JLabel jl_Thiredate = new JLabel(" 입사일자");
		jl_Thiredate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Thiredate.setBorder(new LineBorder(Color.black));
		jl_Thiredate.setBounds(284, 250, 90, 27);

		jtf_hiredate = new JTextField();
		jtf_hiredate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_hiredate.setBorder(new LineBorder(Color.black));
		jtf_hiredate.setBounds(373, 250, 169, 27);

		JLabel jl_Tresigndate = new JLabel(" 퇴사일자");
		jl_Tresigndate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_Tresigndate.setBorder(new LineBorder(Color.black));
		jl_Tresigndate.setBounds(284, 276, 90, 27);

		jtf_resigndate = new JTextField();
		jtf_resigndate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		jtf_resigndate.setBorder(new LineBorder(Color.black));
		jtf_resigndate.setBounds(373, 276, 169, 27);
		
		//버튼
		JButton btn_insert = new JButton("등록");
		btn_insert.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_insert.setBackground(Color.ORANGE);
		btn_insert.setForeground(Color.BLACK);
		btn_insert.setBounds(240, 310, 102, 27);

		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyDAO dao = new CompanyDAO();
				int eno = Integer.parseInt(jtf_eno.getText());
				String dname = jtf_dname.getText(); 
				int dno = dao.printDno(dname);
				String name = jtf_ename.getText();
				String job = jtf_job.getText();
				String exnum = jtf_exnumb.getText();
				String addr = jtf_addr.getText();
				String email = jtf_email.getText();
				String birth = jtf_birth.getText();
				String hiredate = jtf_hiredate.getText();
				String resigndate = jtf_resigndate.getText();	
				String ssc = jtf_ssc.getText();
				String edu = jtf_edu.getText();
				int salary = Integer.parseInt(jtf_salary.getText());
				int dayoff = Integer.parseInt(jtf_dayoff.getText());
				dao.AddEmp(eno, dno, 1234, name,job, exnum, email, "sayout", imageFilePath,
						addr, birth, salary, edu,  dayoff, hiredate, resigndate, ssc);
				System.out.println("사원 등록 완료");
				JOptionPane.showMessageDialog(null, name+"사원이 등록 되었습니다.");
				
				Page_3_Information.clicked_eno = eno;
				new Page_4_1_UpdateInfo();
				setVisible(false);
			}
		});

		// JPanel에 추가
		jp_GUI4.add(jl_Tcname);
		jp_GUI4.add(jtf_exnumb);
		jp_GUI4.add(jl_Teno);
		jp_GUI4.add(jtf_eno);
		jp_GUI4.add(jl_Tename);
		jp_GUI4.add(jtf_ename);
		jp_GUI4.add(jl_Tdname);
		jp_GUI4.add(jtf_dname);
		jp_GUI4.add(jl_Tjob);
		jp_GUI4.add(jtf_job);
		jp_GUI4.add(jl_Temail);
		jp_GUI4.add(jtf_email);
		jp_GUI4.add(jl_Tbirth);
		jp_GUI4.add(jtf_birth);
		jp_GUI4.add(jl_Taddr);
		jp_GUI4.add(jtf_addr);
		jp_GUI4.add(jl_Tssc);
		jp_GUI4.add(jtf_ssc);
		jp_GUI4.add(jl_Tdayoff);
		jp_GUI4.add(jtf_dayoff);
		jp_GUI4.add(jl_Tsalary);
		jp_GUI4.add(jtf_salary);
		jp_GUI4.add(jl_Tedu);
		jp_GUI4.add(jtf_edu);
		jp_GUI4.add(jl_Thiredate);
		jp_GUI4.add(jtf_hiredate);
		jp_GUI4.add(jl_Tresigndate);
		jp_GUI4.add(jtf_resigndate);
		
		//버튼
		jp_GUI4.add(btn_insert);
		
		setBounds(100, 100, 600, 390);
		setResizable(false);
		setLocation(600, 200); // 실행시 나타날 위치
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page_2_2_insert frame = new Page_2_2_insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
