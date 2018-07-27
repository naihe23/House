package house_sale.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import house_sale.util.NameUtil;
import house_sale.model.House_sale;
import house_sale.model.User;

@Repository
public class HouseRepository {

	@Autowired
	private DataSource dataSource;
	public boolean save_house_db(House_sale house_sale) {
		Connection connection=null;
		PreparedStatement pstmt = null;
		 String sql = "insert into House_sall(house_type,house_floor_num,house_place,house_build_year,house_standard,house_price,house_size,house_owner) values(?,?,?,?,?,?,?,?)";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			 pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, NameUtil.toCN(house_sale.getHouse_type()));
			pstmt.setInt(2, house_sale.getHouse_floor_num());
			pstmt.setString(3, NameUtil.toCN(house_sale.getHouse_place()));
			pstmt.setDate(4, house_sale.getHouse_build_year());
			pstmt.setString(5, NameUtil.toCN(house_sale.getHouse_standard()));
			pstmt.setLong(6, house_sale.getHouse_price());
			pstmt.setInt(7, house_sale.getHouse_size());
			pstmt.setString(8, NameUtil.toCN(house_sale.getHouse_owner()));
			int rs = pstmt.executeUpdate();
			if(rs<0) {
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
	
	
	public List<House_sale> get_edit_house(String house_owner_name) {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		List<House_sale> list = new ArrayList<>();
		String sql = "select * from House_sall where house_owner = ?";
		System.out.println("house_owner_name:"+house_owner_name);
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			  pstmt.setString(1, house_owner_name);
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				  House_sale house_sale = new House_sale();
				  house_sale.setHouse_ID(rs.getInt("house_ID"));
				  house_sale.setHouse_build_year(rs.getDate("house_build_year"));
				  house_sale.setHouse_floor_num(rs.getInt("house_floor_num"));
				  house_sale.setHouse_owner(rs.getString("house_owner"));
				  house_sale.setHouse_place(rs.getString("house_place"));
				  house_sale.setHouse_price(rs.getLong("house_price"));
				  house_sale.setHouse_size(rs.getInt("house_size"));
				  house_sale.setHouse_standard(rs.getString("house_standard"));
				  house_sale.setHouse_state(rs.getInt("house_state"));
				  house_sale.setHouse_type(rs.getString("house_type"));
				  list.add(house_sale);
				  System.out.println("true");
			  }
			  System.out.println("dao_list_size:"+list.size());
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
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public House_sale get_edit_houseById(int house_id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		 House_sale house_sale = null;
		 ResultSet rs=null;
		String sql = "select * from House_sall where house_ID = ?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			  pstmt.setInt(1, house_id);
			    rs = pstmt.executeQuery();
			  if(rs.next()) {
				   house_sale = new House_sale();
				  house_sale.setHouse_ID(rs.getInt("house_ID"));
				  house_sale.setHouse_build_year(rs.getDate("house_build_year"));
				  house_sale.setHouse_floor_num(rs.getInt("house_floor_num"));
				  house_sale.setHouse_owner(rs.getString("house_owner"));
				  house_sale.setHouse_place(rs.getString("house_place"));
				  house_sale.setHouse_price(rs.getLong("house_price"));
				  house_sale.setHouse_size(rs.getInt("house_size"));
				  house_sale.setHouse_standard(rs.getString("house_standard"));
				  house_sale.setHouse_state(rs.getInt("house_state"));
				  house_sale.setHouse_type(rs.getString("house_type"));				
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
		return house_sale;
	}
	
	
	
	public int save_edit_house_dao(House_sale house_sale) {
		Connection connection=null;
		PreparedStatement pstmt = null;
			String sql = "update House_sall set house_size=?,house_type=?,house_floor_num=?,house_place=?,house_build_year=?,house_standard=?,house_price=?,house_owner=? where house_ID=?";
			 try {
				  connection = dataSource.getConnection();
				if(connection!=null) {
				    pstmt = connection.prepareStatement(sql);
				  pstmt.setInt(1,house_sale.getHouse_size());
				  pstmt.setString(2, NameUtil.toCN(house_sale.getHouse_type()));
				  pstmt.setInt(3, house_sale.getHouse_floor_num());
				  pstmt.setString(4, NameUtil.toCN(house_sale.getHouse_place()));
				  pstmt.setDate(5, house_sale.getHouse_build_year());
				  pstmt.setString(6,NameUtil.toCN(house_sale.getHouse_standard()));
				  pstmt.setLong(7, house_sale.getHouse_price());
				  pstmt.setString(8, NameUtil.toCN(house_sale.getHouse_owner()));
				  pstmt.setInt(9, house_sale.getHouse_ID());
				  int rs=pstmt.executeUpdate();
				  System.out.println(rs);
				  if(rs>0) {				 
					  return 1;
				  }else {
					  return 2;
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
			return 0;
	}
	
	
	
	public List<House_sale> query_all_house() {
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		List<House_sale> list = new ArrayList<>();
		String sql = "select * from House_sall where house_state = ?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setInt(1, 0);
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				  House_sale house_sale = new House_sale();
				  house_sale.setHouse_ID(rs.getInt("house_ID"));
				  house_sale.setHouse_build_year(rs.getDate("house_build_year"));
				  house_sale.setHouse_floor_num(rs.getInt("house_floor_num"));
				  house_sale.setHouse_owner(rs.getString("house_owner"));
				  house_sale.setHouse_place(rs.getString("house_place"));
				  house_sale.setHouse_price(rs.getLong("house_price"));
				  house_sale.setHouse_size(rs.getInt("house_size"));
				  house_sale.setHouse_standard(rs.getString("house_standard"));
				  house_sale.setHouse_state(rs.getInt("house_state"));
				  house_sale.setHouse_type(rs.getString("house_type"));
				  list.add(house_sale);
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
		return list;
	}
	
	
	public List<House_sale> find_house_by_name(String owner_name) {
		System.out.println("dao_name:"+owner_name);
		Connection connection=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		List<House_sale> list = new ArrayList<>();
		String sql = "select * from House_sall where house_owner like ?";
		 try {
			  connection = dataSource.getConnection();
			if(connection!=null) {
			    pstmt = connection.prepareStatement(sql);
			    pstmt.setString(1, "%"+owner_name+"%");
			    rs = pstmt.executeQuery();
			  while(rs.next()) {
				  House_sale house_sale = new House_sale();
				  house_sale.setHouse_ID(rs.getInt("house_ID"));
				  house_sale.setHouse_build_year(rs.getDate("house_build_year"));
				  house_sale.setHouse_floor_num(rs.getInt("house_floor_num"));
				  house_sale.setHouse_owner(rs.getString("house_owner"));
				  house_sale.setHouse_place(rs.getString("house_place"));
				  house_sale.setHouse_price(rs.getLong("house_price"));
				  house_sale.setHouse_size(rs.getInt("house_size"));
				  house_sale.setHouse_standard(rs.getString("house_standard"));
				  house_sale.setHouse_state(rs.getInt("house_state"));
				  house_sale.setHouse_type(rs.getString("house_type"));
				  list.add(house_sale);
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
		return list;
	}
	
 

}
