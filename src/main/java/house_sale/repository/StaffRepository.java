package house_sale.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import house_sale.model.Admin;
import house_sale.model.House_sale;
import house_sale.model.Staff;

@Repository
public class StaffRepository {

	@Autowired
	DataSource dataSource;
	public Staff find_personal_information(int staff_id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		 Staff  staff = null;
		 ResultSet rs=null;
		String sql = "select * from staff where staff_ID = ?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			  pstmt.setInt(1, staff_id);
			    rs = pstmt.executeQuery();
			  if(rs.next()) {
				   staff = new Staff();
				  staff.setStaff_name(rs.getString("staff_name"));
				  staff.setStaff_password(rs.getString("staff_password")); 
				  staff.setStaff_sex(rs.getString("staff_sex"));
				  staff.setStaff_age(rs.getInt("staff_age"));
				 
				  	
			  }
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
			try {
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
		return staff;
	}
	public boolean save_staff_infor(String name, int age, String sex, String password, int staff_id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		 Staff  staff = null;
		 int rs;
		String sql = "update staff set staff_name = ?,staff_age=?,staff_sex=?,staff_password = ? where "
				+ "staff_ID = ?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			  pstmt.setString(1, name);
			  pstmt.setInt(2, age);
			  pstmt.setString(3, sex);
			  pstmt.setString(4, password);
			  pstmt.setInt(5, staff_id);
			    rs = pstmt.executeUpdate();
			  if(rs<=0) {
				  return false;  	
			  }else
				  return true;
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
			try {
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/*
	 * 查询出所有职员
	 */
	public List<Staff> query_staff() {
		List<Staff> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Staff ";
		try {
			Connection connection = dataSource.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Staff staff = new Staff();
					staff.setStaff_ID(rs.getInt("staff_ID"));
					staff.setStaff_name(rs.getString("staff_name"));
					staff.setStaff_state(rs.getInt("staff_state"));
					list.add(staff);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean ban_staff(String str) {
		PreparedStatement pstmt = null;
		int rs;
		String sql = "update Staff set staff_state= ? where staff_name= ?";
		try {
			Connection connection = dataSource.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 3);
				pstmt.setString(2, str);
				
				rs = pstmt.executeUpdate();
				System.out.println("员工名:" + str);
				if (rs <= 0) {
					return false;
				} else
					System.out.println("rs现在是:"+rs);
					return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete_staff(String str) {
		PreparedStatement pstm = null;
		int rs;
		String sql = "delete from Staff where staff_name = ?";
		try {
			Connection connection = dataSource.getConnection();
			if (connection != null) {
				pstm = connection.prepareStatement(sql);
				pstm.setString(1, str);

				rs = pstm.executeUpdate();
				if (rs < 0) {
					return false;
				} else
					return true;

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}
	/*
	 * 查询管理员信息
	 */
	public List<Admin> query_admin(int id) {
		List<Admin> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select admin_ID,staff_name,staff_sex,staff_age,staff_password from Staff,Admin  where Staff.staff_ID = Admin.staff_ID and  admin_ID = ? ";
		try {
			Connection connection = dataSource.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Admin admin = new Admin();
					admin.setAdmin_ID(rs.getInt(1));
					admin.setStaff_name(rs.getString(2));
					admin.setStaff_sex(rs.getString(3));
					admin.setStaff_age(rs.getInt(4));
					admin.setStaff_password(rs.getString(5));
					list.add(admin);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean edit_admin(String admin_name, int admin_age, String admin_sex, String password,int admin_id) {
		PreparedStatement pstmt = null;
		int rs;
		String sql="update Staff set staff_name= ?,staff_age=?,staff_sex=?,staff_password=? where staff_ID "
				+ "in (select staff_ID from Admin where admin_ID = ?)";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, admin_name);
				pstmt.setInt(2, admin_age);
				pstmt.setString(3, admin_sex);
				pstmt.setString(4,password);
				pstmt.setInt(5, admin_id);			
				rs = pstmt.executeUpdate();
				 
				if(rs<0) {
					return false;
				}else
					return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Staff> query_concret_staff(String name) {
		List<Staff> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from Staff where staff_name = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Staff staff = new Staff();
					staff.setStaff_ID(rs.getInt("staff_ID"));
					staff.setStaff_name(rs.getString("staff_name"));
					staff.setStaff_age(rs.getInt("staff_age"));
					staff.setStaff_state(rs.getInt("staff_state"));
					staff.setStaff_real_name(rs.getString("staff_real_name"));
					staff.setStaff_sex(rs.getString("staff_sex"));
					list.add(staff);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Staff get_user_ByName(String Uname) {
		System.out.println(" !!!!");
		Connection connection=null;
		PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 Staff staff = new Staff();
		 String sql = "select staff_ID,staff_password,staff_state from staff where staff_name = ?";
			//System.out.println(sql);
		 try {
			  connection = dataSource.getConnection();
			  if(connection!=null){
			  pstmt = connection.prepareStatement(sql);
			  pstmt.setString(1, Uname);
	        	rs = pstmt.executeQuery();
	        	if (rs.next()) {
	        		staff.setStaff_ID(rs.getInt("staff_ID"));
	        		staff.setStaff_state(rs.getInt("staff_state"));
	        		staff.setStaff_password(rs.getString("staff_password"));
              }
	        	System.out.println("ID"+staff.getStaff_ID()+"password"+staff.getStaff_password());
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
		return staff;
	}
}
