package Datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

		ArrayList<DTO> list;

//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost/daearcdo";
//		String userid = "daearcdo";
//		String passwd = "skdltn123";
		//String tablechang = "engmemo";
		
		//????????????(????????? MYSQL)
//		String driver = "com.mysql.jdbc.Driver";
//		String userid = "daearcdo";
//		String passwd = "skdltn";
//		String url = "jdbc:mysql://localhost:3306/test";
//		String tablechang = "test2";
		
		//CAFE24 DB二쇱??
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://183.111.141.100/daearcdo";
		String userid = "daearcdo";
		String passwd = "skdltn123";
//		String tablechang = "engmemo";
		
		

		public DAO() {

			try {
				list = new ArrayList<DTO>();
				Class.forName(driver);


			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}
		}

		public ArrayList<DTO> select() {

			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				con = DriverManager.getConnection(url, userid, passwd);

				// 4. sql ??��?��?��??��?��?��?��占??????�ル∥��?域뱀��?��?熬���?��
				String query = "SELECT * FROM devices ORDER BY num ";

				stmt = con.prepareStatement(query);

				// 6. sql ??��?��?��??��?��?��?��占??????�ル∥��???��?��?��??��?��?��???��?��?��??��?��?��
				rs = stmt.executeQuery();


				while (rs.next()) {

					int num = rs.getInt("num");
					String device = rs.getString("device");
					String model = rs.getString("model");
					
					list.add(new DTO(num, device,model));


				}
				
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
			} // end try~catch

			finally {

				try {

					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();

				} catch (SQLException se) {
					se.printStackTrace();
				}

			}
			return list;
		}// end select()
		

		public void insert(int num, String device, String model) {
			Connection con = null;
			PreparedStatement stmt = null;
			
			
			try {

				con = DriverManager.getConnection(url, userid, passwd);

				String insert = "INSERT INTO devices (num,device,model) values (?,?,?)";
				
				stmt = con.prepareStatement(insert);

				stmt.setInt(1, num);
				stmt.setString(2, device);
				stmt.setString(3, model);
				

				int n = stmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} // end try~catch

			finally {

				try {
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();

				} catch (SQLException se) {
					se.printStackTrace();
				}

			}
			
		}// end insert()
		


		public void delete(String device) {

			DTO dto = new DTO();

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String sql = "DELETE FROM devices WHERE device=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, device);
				int n = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace();
				}

			}

		}// end delete
		
		
		
		
		
	}


