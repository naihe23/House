package house_sale.repository;

import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.util.NameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {

	@Autowired
	DataSource dataSource;
	public long get_balance_by_id(int user_id) {
		  System.out.println("dao_user_id:"+user_id);
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs;
		 long balance=0;
		String sql = "select * from User where user_ID = ?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, user_id);
			    rs = pstmt.executeQuery();
			    if(rs.next()) {
			    balance = rs.getLong("user_balance");
			    }
			    System.out.println("dao_balance:"+balance);
			}else {
				System.out.println("���ݿ�����ʧ��!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return balance;
	}
	public boolean update_balance_dao(long balance,int user_id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "update User set user_balance= ? where user_ID= ?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setLong(1, balance);
			    pstmt.setInt(2, user_id);
			    rs = pstmt.executeUpdate();
			   if(rs<0) {
				   return false;
			   }else
				   return true;
			}else {
				System.out.println("���ݿ�����ʧ��!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 
		return false;
	}

	/*
	 * ��ѯ������δ��˵��û�
	 */
	public List<User> query_check_user() {
		List<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from User where user_state = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 0);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setUser_ID(rs.getInt("user_ID"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_age(rs.getInt("user_age"));
					user.setUser_real_name(rs.getString("user_real_name"));
					user.setUser_phone(rs.getLong("user_phone"));
					user.setUser_IDnumber(rs.getLong("user_IDnumber"));
					user.setUser_sex(rs.getString("user_sex"));
					list.add(user);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean check_pass_dao(int user_id) {
		PreparedStatement pstmt = null;
		int rs;
		String sql="update User set user_state= ? where user_ID= ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, user_id);
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
	public boolean check_unpass_dao(int user_id) {
		PreparedStatement pstm = null;
		int rs;
		String sql ="update User set user_state= ? where user_ID= ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstm=connection.prepareStatement(sql);
				pstm.setInt(1, 2);
				pstm.setInt(2, user_id);
				rs = pstm.executeUpdate();
				if(rs<0) {
					return false;
				}else
					return true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * ��ѯ��������ע��ɹ����û�
	 */
	public List<User> query_users() {
		List<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from User where user_state = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 1);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setUser_ID(rs.getInt("user_ID"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_state(rs.getInt("user_state"));
					
					
					list.add(user);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

}
	public boolean del_users_dao(String user_name) {
		
		PreparedStatement pstm = null;
		int rs;
		String sql ="delete from User where user_name = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstm=connection.prepareStatement(sql);
				pstm.setString(1, user_name);
				
				rs = pstm.executeUpdate();
				if(rs<0) {
					return false;
				}else
					return true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;	
	
}
	public boolean ban_users(String user_name) {
		PreparedStatement pstmt = null;
		int rs;
		String sql="update User set user_state= ? where user_name= ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 3);
				pstmt.setString(2, user_name);
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
	/*
	 * ��ѯ������ְԱ
	 */
	public List<Staff> query_staff() {
		List<Staff> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from Staff where staff_state = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, 0);
				rs = pstmt.executeQuery();
				while(rs.next()) {
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
	/*
	 * ��ѯ��ָ���û�
	 */
	public List<User> query_concret_user(String name) {
		List<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from User where user_name = ?";
		try {
			Connection connection = dataSource.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setUser_ID(rs.getInt("user_ID"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_age(rs.getInt("user_age"));
					user.setUser_real_name(rs.getString("user_real_name"));
					user.setUser_phone(rs.getLong("user_phone"));
					user.setUser_IDnumber(rs.getLong("user_IDnumber"));
					user.setUser_state(rs.getInt("user_state"));
					user.setUser_sex(rs.getString("user_sex"));
					list.add(user);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public User get_user_ByName(String Uname) {
		System.out.println(" !!!!");
		Connection connection=null;
		PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 User user = new User();
		 String name = NameUtil.toCN(Uname);
		 System.out.println("�û���:"+name);
		 String sql = "select user_ID,user_name,user_password,user_state from User where user_name = ?";
			//System.out.println(sql);
		 try {
			  connection = dataSource.getConnection();
			  if(connection!=null){
			  pstmt = connection.prepareStatement(sql);
			  pstmt.setString(1, name);
	        	rs = pstmt.executeQuery();
	        	if (rs.next()) {
	        		user.setUser_ID(rs.getInt("user_ID"));
	        		user.setUser_name(rs.getString("user_name"));
	        		user.setUser_state(rs.getInt("user_state"));
	        		user.setUser_password(rs.getString("user_password"));
              }
	        	System.out.println("ID"+user.getUser_ID()+"password"+user.getUser_password());
			  }else {
					System.out.println("���ݿ�����ʧ��!");
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
		return user;
	}
	public boolean register_user_db(User user){
		Connection connection=null;
		PreparedStatement pstmt = null;
		 String sql = "insert into User(user_ID,user_name,user_password,user_sex,user_real_name," +
				 "user_age,user_balance,user_state,user_phone,user_IDnumber) values(?,?,?,?,?,?,?,?,?,?)";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			 pstmt = connection.prepareStatement(sql);
			 
			 pstmt.setLong(1, user.getUser_ID());
			 pstmt.setString(2, NameUtil.toCN(user.getUser_name()));
			 pstmt.setString(3, user.getUser_password());
			 pstmt.setString(4, NameUtil.toCN(user.getUser_sex()));
			 pstmt.setString(5, NameUtil.toCN(user.getUser_real_name()));
			 pstmt.setInt(6, user.getUser_age());
			 pstmt.setLong(7, user.getUser_balance());
			 pstmt.setInt(8, user.getUser_state());
			 pstmt.setLong(9, user.getUser_phone());
			 pstmt.setLong(10, user.getUser_IDnumber());
			 
		int rs = pstmt.executeUpdate();
		if(rs<0) {
			return false;
		}else
			return true;
		}else {
			System.out.println("���ݿ�����ʧ��!");
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
    public User get_user_information_ById(int user_id){
    	
    	
    	Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
    	User user = new User();
    	String sql = "select * from User where user_ID = ?";
    	try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, user_id);
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				  
				  user.setUser_name(rs.getString("user_name"));
				  user.setUser_password(rs.getString("user_password"));
				  user.setUser_sex(rs.getString("user_sex"));
				  user.setUser_real_name(rs.getString("user_real_name"));
				  user.setUser_age(rs.getInt("user_age"));
				  user.setUser_balance(rs.getLong("user_balance"));
				  user.setUser_state(rs.getInt("user_state"));
				  user.setUser_phone(rs.getLong("user_phone"));
				  user.setUser_IDnumber(rs.getLong("user_IDnumber"));
				  
			  }
			}else {
				System.out.println("���ݿ�����ʧ��!");
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
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	
    	return user;
    }
    
    public int save_edit_user_dao(User user) {
		Connection connection=null;
		PreparedStatement pstmt = null;
			String sql = "update User set user_name=?,user_password=?,user_sex=?,user_real_name=?," +
					"user_age=?,user_balance=?,user_phone=?,user_IDnumber=? where user_ID=?";
			 try {
				  connection = dataSource.getConnection();
				if(connection!=null) {
				    pstmt = connection.prepareStatement(sql);
				  pstmt.setString(1, NameUtil.toCN(user.getUser_name()));
				  pstmt.setString(2, user.getUser_password());
				  pstmt.setString(3, NameUtil.toCN(user.getUser_sex()));
				  pstmt.setString(4, NameUtil.toCN(user.getUser_real_name()));
				  pstmt.setInt(5, user.getUser_age());
				  pstmt.setLong(6,user.getUser_balance());
				  pstmt.setLong(7, user.getUser_phone());
				  pstmt.setLong(8, user.getUser_IDnumber());
				  pstmt.setInt(9,user.getUser_ID());
				  int rs=pstmt.executeUpdate();
				  System.out.println(rs);
				  if(rs>0) {				 
					  return 1;
				  }else {
					  return 2;
				  }
				}else {
					System.out.println("���ݿ�����ʧ��!");
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
			return 0;
	}
}
