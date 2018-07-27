package house_sale.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import house_sale.model.House_Order_state;
import house_sale.model.House_sale;
import house_sale.model.PageCheck_order;
import house_sale.model.Request_order;
import house_sale.model.User;
import house_sale.model.User_time;
@Repository
public class Request_orderRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public PageCheck_order query_request_order(int curPage, int pageSize){
		PageCheck_order pageCheck_order = new PageCheck_order();
		Connection connection=null;
		 Statement pstmt=null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 List<User_time> list = new ArrayList<>();
		 int totalCount = 0, totalPage = 0;
		 try {
		 connection = dataSource.getConnection();
		 if(connection!=null) {
		 String sql = "select count(*) from request_order where request_state = 0 ";	
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			if (totalCount % pageSize == 0)
				totalPage = totalCount / pageSize;
			else
				totalPage = totalCount / pageSize + 1;
		 
		 
		String sql1 = "select User.*,request_order.time,request_ID from User,request_order "
				+ "where User.user_ID=request_order.user_ID and request_order.request_state = 0 "
				+ "order by request_ID desc limit "+ ((curPage - 1) * pageSize) + ", " + ( pageSize);;
		
			  
			
			    pstmt = connection.createStatement();
			    rs = pstmt.executeQuery(sql1);
			  while(rs.next()) {
				 User_time user_time = new User_time();
				 user_time.setRequest_ID(rs.getInt("request_ID"));
				 user_time.setUser_name(rs.getString("user_name"));
				 user_time.setUser_sex(rs.getString("user_sex"));
				 user_time.setUser_real_name(rs.getString("user_real_name"));
				 user_time.setUser_IDnumber(rs.getLong("user_IDnumber"));
				 user_time.setUser_age(rs.getInt("user_age"));	
				 user_time.setUser_phone(rs.getLong("user_phone"));
				 user_time.setUser_balance(rs.getLong("user_balance"));
				 user_time.setUser_state(rs.getInt("user_state"));
				 user_time.setTime(time(rs.getTimestamp("time")));
				 list.add(user_time);
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
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 pageCheck_order.setCurPage(curPage);
		 pageCheck_order.setList(list);
		 pageCheck_order.setPageSize(pageSize);
		 pageCheck_order.setTotalCount(totalCount);
		 pageCheck_order.setTotalPage(totalPage);
		return  pageCheck_order;
	
	}

    public void edit_order_state(int order_id) {
    	System.out.println("dao_order_id"+order_id);
    	Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "update request_order set request_state=? where request_ID=?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, 1);
			    pstmt.setInt(2, order_id);
			    rs = pstmt.executeUpdate();
			    if(rs<=0) {
			    	System.out.println("更新失败!");
			    }else
			    	System.out.println("更新成功!");
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
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		
	}
    
   public void edit_order_error(int order_id) {
	   System.out.println("dao_order_id"+order_id);
   	Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "update request_order set request_state=? where request_ID=?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, 2);
			    pstmt.setInt(2, order_id);
			    rs = pstmt.executeUpdate();
			    if(rs<=0) {
			    	System.out.println("更新失败!");
			    }else
			    	System.out.println("更新成功!");
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
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} 

	

	public boolean insert_request_order(int house_id, int user_id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "insert into request_order(house_ID,user_ID,time)values(?,?,?)";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, house_id);
			    pstmt.setInt(2, user_id);
			    pstmt.setTimestamp(3,time());
			    rs = pstmt.executeUpdate();
			    if(rs<=0) {
			    	System.out.println("失败!");
			    	return false;
			    }else
			    	System.out.println("成功!");
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

	
	
	public Timestamp time()
	{
		Timestamp t1=null ;
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time=format.format(date);
	try {  
	    Date date1 = format.parse(time);  
	    System.out.println(date1);  
	     t1 = new Timestamp(date.getTime());   
	} catch (Exception e) {  
	    e.printStackTrace();  
	}  
	
	return t1;
	}
	private Date time(Date currentTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		Date date = formatter.parse(dateString);
		return date;
	}

	public boolean edit_request_order_state_dao(int house_id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "update House_sall set house_state = ? where house_ID = ?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, 1);
			    pstmt.setInt(2, house_id);
			    rs = pstmt.executeUpdate();
			    if(rs<=0) {
			    	System.out.println("失败!");
			    	return false;
			    }else
			    	System.out.println("成功!");
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

	public List<House_Order_state> user_query_request_order(int u_id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 List<House_Order_state> list = new ArrayList<>();
		String sql = "select House_sall.*,request_order.request_state,request_order.request_ID "
				+ "from House_sall,request_order where House_sall.house_ID"
				+ "=request_order.house_ID and request_order.user_ID=?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1,u_id);
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				 House_Order_state user_time = new House_Order_state();
				 user_time.setRequest_ID(rs.getInt("request_ID"));
				 user_time.setHouse_build_year(rs.getDate("house_build_year"));
				 user_time.setHouse_floor_num(rs.getInt("house_floor_num"));
				 user_time.setHouse_ID(rs.getInt("house_ID"));
				 user_time.setHouse_owner(rs.getString("house_owner"));
				 user_time.setHouse_place(rs.getString("house_place"));
				 user_time.setHouse_price(rs.getLong("house_price"));
				 user_time.setHouse_size(rs.getInt("house_size"));
				 user_time.setHouse_standard(rs.getString("house_standard"));
				 user_time.setHouse_type(rs.getString("house_type"));
				 user_time.setRequest_state(rs.getInt("request_state"));
				 list.add(user_time);
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
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  list;
	}

	public boolean edit_request_order_state_finish(int id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 int rs;
		String sql = "update request_order set request_state = ? where request_ID = ?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, 3);
			    pstmt.setInt(2, id);
			    rs = pstmt.executeUpdate();
			    if(rs<=0) {
			    	System.out.println("失败!");
			    	return false;
			    }else
			    	System.out.println("成功!");
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

	public List<House_Order_state> quer_finished_order(int id) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs;
		 List<House_Order_state> list = new ArrayList<>();
		String sql = "select House_sall.*,request_order.time,request_state from House_sall,request_order where "
				+ "House_sall.house_ID=request_order.house_ID and request_order.user_ID = ? "
				+ "and request_order.request_state = ?";				
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, id);
			    pstmt.setInt(2,3);
			    rs = pstmt.executeQuery();
			    if(rs.next()) {
			    	House_Order_state house_Order_state = new House_Order_state();
			    	house_Order_state.setRequest_state(rs.getInt("request_state"));
			    	house_Order_state.setHouse_build_year(rs.getDate("house_build_year"));
			    	house_Order_state.setHouse_floor_num(rs.getInt("house_floor_num"));
			    	house_Order_state.setHouse_owner(rs.getString("house_owner"));
			    	house_Order_state.setHouse_place(rs.getString("house_place"));
			    	house_Order_state.setHouse_price(rs.getLong("house_price"));
			    	house_Order_state.setHouse_size(rs.getInt("house_size"));
			    	house_Order_state.setHouse_standard(rs.getString("house_standard"));
			    	house_Order_state.setHouse_state(rs.getInt("house_state"));
			    	house_Order_state.setHouse_type(rs.getString("house_type"));
			    	house_Order_state.setHouse_build_year(rs.getDate("house_build_year"));
			    	house_Order_state.setOrder_time(rs.getTimestamp("time"));
			    	System.out.println("state"+house_Order_state.getRequest_state());
			    	list.add(house_Order_state);
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
					e.printStackTrace();
				}
			}
			try {
				connection.close();
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
