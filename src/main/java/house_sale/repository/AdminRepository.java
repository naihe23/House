package house_sale.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import house_sale.model.Admin;
import house_sale.model.AdminPassword;
import house_sale.model.Staff;

@Repository
public class AdminRepository {

	@Autowired
	private DataSource dataSource;
	
	public AdminPassword get_user_ByName(String Uname) {
		System.out.println(" !!!!");
		Connection connection=null;
		PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 AdminPassword admin = new AdminPassword();
		 String sql = "select staff.staff_password,Admin.admin_ID from Admin,staff "
		 		+ "where Admin.staff_ID=staff.staff_ID and staff.staff_name = ?";
			//System.out.println(sql);
		 try {
			  connection = dataSource.getConnection();
			  if(connection!=null){
			  pstmt = connection.prepareStatement(sql);
			  pstmt.setString(1, Uname);
	        	rs = pstmt.executeQuery();
	        	if (rs.next()) {
	        		admin.setAdmin_ID(rs.getInt("admin_ID"));
	        		admin.setStaff_password(rs.getString("staff_password"));
              }
	        	System.out.println("ID"+admin.getAdmin_ID()+"password"+admin.getStaff_password());
			  }else {
					System.out.println("数据库连接失败!");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return admin;
	}
}
