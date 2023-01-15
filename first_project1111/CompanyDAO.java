package first_project1111;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class CompanyDAO {
	
	public int printDno(String dname){		//로그인시 패스워드 불러오기
		int dno = 0;
		String sql = "select dno from dept where dname = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE" , "c##projectm" , "1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dno = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return dno;
		
	}
	
	public ArrayList<CompanyVO> loginEmp(int eno){		//로그인시 패스워드 불러오기
		String sql = "select pwd from emp where eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE" , "c##projectm" , "1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pwd = rs.getInt(1);
				
				CompanyVO vo = new CompanyVO();
				vo.setPwd(pwd);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	public int ChangePwd(int eno, int cpwd){		//비밀번호 변경
		String sql = "update emp set pwd = ? where eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cpwd);
			pstmt.setInt(2, eno);
			
			int re = pstmt.executeUpdate();
			
			if(re == 1) {
				return 0; //암호 변경 성공
			}
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return 1; //암호 변경 실패	
	}
	
	public int selectPwd(int eno){		//로그인시 패스워드 불러오기(암호변경시 확인용)
		int pwd = 0;
		String sql = "select pwd from emp where eno = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE" , "c##projectm" , "1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pwd = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return pwd;
	}
	
	public int deleteEmp(int eno){		//사원삭제
		String sql1 = "delete from career where eno = ?";
		String sql2 = "delete from certi where eno = ?";
		String sql3 = "delete from eva where eno = ?";
		String sql4 = "delete from emp where eno = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, eno);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, eno);
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, eno);
			PreparedStatement pstmt4 = conn.prepareStatement(sql4);
			pstmt4.setInt(1, eno);
			
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			int re = pstmt4.executeUpdate();
			
			if(re == 1) {
				return 0; //삭제 성공
			}
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return 1; //삭제 실패
	
		
	}
	
	public int AddEmp(int eno, int dno, int pwd, String name, String job, String exnum, String email, String cname, String photopath,
			String addr, String birth, int salary, String edu, int dayoff, String hiredate, String resigndate, String ssc){		//사원 추가
		
		String sql = "insert into emp values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			File file = new File(photopath);
			FileInputStream fis = new FileInputStream(file);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			pstmt.setInt(2, eno);
			pstmt.setInt(3, pwd);
			pstmt.setString(4, name);
			pstmt.setString(5, job);
			pstmt.setString(6, exnum);
			pstmt.setString(7, email);
			pstmt.setString(8, "sayout");
			pstmt.setString(9, addr);
			pstmt.setString(10, birth);
			pstmt.setInt(11, salary);
			pstmt.setString(12, edu);
			pstmt.setInt(13, dayoff);
			pstmt.setString(14, hiredate);
			pstmt.setString(15, resigndate);
			pstmt.setString(16, ssc);
			pstmt.setBinaryStream(17, fis, (int)file.length()); 
				
			
			int re = pstmt.executeUpdate();
			
			if(re == 1) {
				return 0; //사원등록 성공
			}
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		return 1; //사원등록 실패
	}
	
	//커리어 업데이트
		public int updateCareer(int eno, ArrayList<CompanyVO> list) {
			String sql1 = "delete from career where eno = ?";
			String sql2 = "insert into career values(?, ?, ?, ?, ?, ?)";
			int re = 0;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
				
				PreparedStatement pstmt01 = conn.prepareStatement(sql1);
				pstmt01.setInt(1, eno);
				pstmt01.executeUpdate();
				
				for(CompanyVO test : list) {
					PreparedStatement pstmt02 = conn.prepareStatement(sql2);
					pstmt02.setInt(1, eno);
					pstmt02.setString(2, test.getExcname());
					pstmt02.setString(3, test.getExhiredate());
					pstmt02.setString(4, test.getExresigndate());
					pstmt02.setString(5, test.getExdept());
					pstmt02.setString(6, test.getExjob());
					
					pstmt02.executeUpdate();
					re++;
				}
			}catch(Exception e) {
				System.out.println("예외:"+e.getMessage());
			}

			return re;
		}
		
		//자격증 업데이트
			public int updateCerti(int eno, ArrayList<CompanyVO> list) {
				String sql1 = "delete from certi where eno = ?";
				String sql2 = "insert into certi values(?, ?, ?, ?, ?, ?)";
				int re = 0;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
					
					PreparedStatement pstmt01 = conn.prepareStatement(sql1);
					pstmt01.setInt(1, eno);
					pstmt01.executeUpdate();
					
					for(CompanyVO test : list) {
					PreparedStatement pstmt02 = conn.prepareStatement(sql2);
					pstmt02.setInt(1, eno);
					pstmt02.setString(2,test.getCertiname());
					pstmt02.setString(3,test.getCertidate());
					pstmt02.setString(4,test.getCertiscore());
					pstmt02.setString(5,test.getCertisdate());
					pstmt02.setString(6,test.getCertiedate());
					
					
					pstmt02.executeUpdate();
					re++;
					}
				}catch(Exception e) {
					System.out.println("123예외:"+e.getMessage());
				}

				return re;
			}
			//인사평가 업데이트
			public int updateEva(int eno, ArrayList<CompanyVO> list) {
				String sql1 = "delete from eva where eno = ?";
				String sql2 = "insert into eva values(?, ?, ?, ?, ?, ?, ?)";
				int re = 0;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
					
					PreparedStatement pstmt01 = conn.prepareStatement(sql1);
					pstmt01.setInt(1, eno);
					pstmt01.executeUpdate();
					
					for(CompanyVO test : list) {
						PreparedStatement pstmt02 = conn.prepareStatement(sql2);
						pstmt02.setInt(1, eno);
						pstmt02.setInt(2,test.getRespons());
						pstmt02.setInt(3,test.getBusiperfo());
						pstmt02.setInt(4,test.getCooper());
						pstmt02.setInt(5,test.getAttitude());
						pstmt02.setInt(6,test.getExtrapoint());
						pstmt02.setString(7,test.getEvaDate());
						
						
						pstmt02.executeUpdate();
						re++;
					}
				}catch(Exception e) {
					System.out.println("예외:"+e.getMessage());
				}
				
				return re;
			}
			
			public void updateJob(int eno,String job) { // 직책 수정
				
				String sqlJob = "update emp set job = ? where eno = ?";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@" + Page_1_LogIn.ip + ":1521:XE",
							"c##projectm", "1234");
					PreparedStatement pstmt = conn.prepareStatement(sqlJob);
					System.out.println(job);
					System.out.println(eno);
					pstmt.setString(1,job);
					pstmt.setInt(2, eno);
					int rs = pstmt.executeUpdate();
				} catch (Exception e) {
					System.out.println("예외:" + e.getMessage());
				}
			}
	
	public ArrayList<CompanyVO> tableInfo(){	//테이블 첫화면 불러오기
		String sql = "select eno, name, dname,job,to_char(birth,'yy/mm/dd'),exnumb,email from emp e, dept d where e.dno = d.dno order by eno";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int eno = rs.getInt(1);
				String name = rs.getString(2);
				String dname = rs.getString(3);
				String job = rs.getString(4);
				String birth = rs.getString(5);
				String exnum = rs.getString(6);
				String email = rs.getString(7);
				
				CompanyVO vo = new CompanyVO();
				vo.setEno(eno);
				vo.setName(name);
				vo.setDname(dname);
				vo.setJob(job);
				vo.setBirth(birth);
				vo.setExnum(exnum);
				vo.setEmail(email);
				
				list.add(vo);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<CompanyVO> searchAsEno(int eno){		//사원번호로 검색
		String sql = "select eno, name, dname,job,to_char(birth,'yy/mm/dd'),exnumb,email from emp e, dept d where e.dno = d.dno and eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int eno1 = rs.getInt(1);
				String name = rs.getString(2);
				String dname = rs.getString(3);
				String job = rs.getString(4);
				String birth = rs.getString(5);
				String exnum = rs.getString(6);
				String email = rs.getString(7);
				
				CompanyVO vo = new CompanyVO();
				vo.setEno(eno1);
				vo.setName(name);
				vo.setDname(dname);
				vo.setJob(job);
				vo.setBirth(birth);
				vo.setExnum(exnum);
				vo.setEmail(email);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	
	
	public ArrayList<CompanyVO> searchAsDname(String dname){		//부서명으로 검색
		String sql = "select eno, name, dname,job,to_char(birth,'yy/mm/dd'),exnumb,email from emp e, dept d where e.dno = d.dno and dname = ? order by eno";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int eno = rs.getInt(1);
				String name = rs.getString(2);
				String dname2 = rs.getString(3);
				String job = rs.getString(4);
				String birth = rs.getString(5);
				String exnum = rs.getString(6);
				String email = rs.getString(7);
				
				CompanyVO vo = new CompanyVO();
				vo.setEno(eno);
				vo.setName(name);
				vo.setDname(dname2);
				vo.setJob(job);
				vo.setBirth(birth);
				vo.setExnum(exnum);
				vo.setEmail(email);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	
	public ArrayList<CompanyVO> searchAsEname(String ename){		//사원명으로 검색
		String sql = "select eno, name, dname,job,to_char(birth,'yy/mm/dd'),exnumb,email from emp e, dept d where e.dno = d.dno and name = ? order by eno";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int eno = rs.getInt(1);
				String name = rs.getString(2);
				String dname = rs.getString(3);
				String job = rs.getString(4);
				String birth = rs.getString(5);
				String exnum = rs.getString(6);
				String email = rs.getString(7);
				
				CompanyVO vo = new CompanyVO();
				vo.setEno(eno);
				vo.setName(name);
				vo.setDname(dname);
				vo.setJob(job);
				vo.setBirth(birth);
				vo.setExnum(exnum);
				vo.setEmail(email);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	
	public ArrayList<CompanyVO> detailPage(int eno){		//상세페이지이동
		String sql = "select cname, eno, name, dname,job,to_char(birth,'yy/mm/dd'),email, addr, photo from emp e, dept d where e.dno = d.dno and eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cname = rs.getString(1);
				int eno1 = rs.getInt(2);
				String name = rs.getString(3);
				String dname = rs.getString(4);
				String job = rs.getString(5);
				String birth = rs.getString(6);
				String email = rs.getString(7);
				String addr = rs.getString(8);
				byte[]imagedata = rs.getBytes(9);
	            Image photo = Toolkit.getDefaultToolkit().createImage(imagedata);
				
				CompanyVO vo = new CompanyVO();
				vo.setCname(cname);
				vo.setEno(eno1);
				vo.setName(name);
				vo.setDname(dname);
				vo.setJob(job);
				vo.setBirth(birth);
				vo.setEmail(email);
				vo.setAddr(addr);
				vo.setPhoto(photo);
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	
	public ArrayList<CompanyVO> MoreDetailPage(int eno){		//최종상세페이지이동
		String sql = "select salary, edu, ssc, to_char(hiredate,'yy/mm/dd'), dayoff,to_char(resigndate,'yy/mm/dd') from emp where eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int salary = rs.getInt(1);
				String edu = rs.getString(2);
				String ssc = rs.getString(3);
				String hiredate = rs.getString(4);
				int dayoff = rs.getInt(5);
				String resigndate = rs.getString(6);
				
				
			
				
				CompanyVO vo = new CompanyVO();
				vo.setSalary(salary);
				vo.setEdu(edu);
				vo.setSsc(ssc);
				vo.setHiredate(hiredate);
				vo.setDayoff(dayoff);
				vo.setResigndate(resigndate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	public ArrayList<CompanyVO> CareerDetailPage(int eno){		//최종상세페이지이동(경력)
		String sql = "select excname, to_char(exhiredate,'yy/mm/dd'), to_char(exresigndate,'yy/mm/dd'), exdept, exjob from career where eno = ? ";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String excname = rs.getString(1);
				String exhiredate = rs.getString(2);
				String exresigndate = rs.getString(3);
				String exdept = rs.getString(4);
				String exjob = rs.getString(5);
				
				
				CompanyVO vo = new CompanyVO();
				vo.setExcname(excname);
				vo.setExhiredate(exhiredate);
				vo.setExresigndate(exresigndate);
				vo.setExdept(exdept);
				vo.setExjob(exjob);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	public ArrayList<CompanyVO> CertiDetailPage(int eno){		//최종상세페이지이동(자격증)
		String sql = "select certiname, to_char(certidate,'yy/mm/dd'), nvl(certiscore,'합격'), nvl(to_char(certisdate,'yy/mm/dd'),'유효기간 없음'), nvl(to_char(certiedate,'yy/mm/dd'),'유효기간 없음') from certi where eno = ?";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String certiname = rs.getString(1);
				String certidate = rs.getString(2);
				String certiscore = rs.getString(3);
				String certisdate = rs.getString(4);
				String certiedate = rs.getString(5);	
				
				CompanyVO vo = new CompanyVO();
				vo.setCertiname(certiname);
				vo.setCertidate(certidate);
				vo.setCertiscore(certiscore);
				vo.setCertisdate(certisdate);				
				vo.setCertiedate(certiedate);				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	
	public ArrayList<CompanyVO> EvaDetailPage(int eno){		//최종상세페이지이동(평가)
		String sql = "select repons, busiperfo, cooper, attitude, extrapoint, to_char(evadate,'yy/mm/dd') from eva where eno = ? order by evadate";
		ArrayList<CompanyVO> list = new ArrayList<CompanyVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm","1234");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int respons = rs.getInt(1);
				int busiperfo = rs.getInt(2);
				int cooper = rs.getInt(3);
				int attitude = rs.getInt(4);
				int extrapoint = rs.getInt(5);
				String evaDate = rs.getString(6);
				
				CompanyVO vo = new CompanyVO();
				vo.setRespons(respons);
				vo.setBusiperfo(busiperfo);
				vo.setCooper(cooper);
				vo.setAttitude(attitude);
				vo.setExtrapoint(extrapoint);
				vo.setEvaDate(evaDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
		}
		
		return list;
		
	}
	

}
