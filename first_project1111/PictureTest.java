package first_project1111;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PictureTest {

	public static void main(String[] args) {
		try {
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@"+Page_1_LogIn.ip+":1521:XE","c##projectm", "1234");
			con.setAutoCommit(false);

			for(int i = 101; i<=503; i++) {
				int temp = i;
				String imgName = temp+".png";
				File file = new File(imgName);
				if(file.exists()) {  
					FileInputStream fis = new FileInputStream(file);  
		
					PreparedStatement ps = con.prepareStatement("update emp set photo = ? where eno = ?");
					ps.setBinaryStream(1, fis, (int)file.length());  
					ps.setInt(2, temp);
					ps.executeUpdate();
					System.out.println(i+"사원 사진파일 업로드");
					ps.close();  
					fis.close();  
					
				}
			}
			con.close();
			System.out.println("끝");

			} catch(Exception e) {
			System.out.println(e.toString());
			}


	}

}
