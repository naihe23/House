package house_sale.dao;

import house_sale.model.House_sale;
import house_sale.model.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import house_sale.model.House_Order_state;

public interface UserDao{
     List<House_sale> query_all_house();
     List<House_sale> query_all_house(String house_owner);
     int insert_request_order(@Param("map") HashMap<String,Integer> map,@Param("time") Timestamp time);
     int edit_request_order_state_dao(int house_id);
     List<House_Order_state> user_query_request_order(int u_id);
     User query_user(int u_id);
     int update_balance_dao(HashMap<String,Object> map);
     int edit_request_order_state_finish(int id);
     List<House_Order_state> query_finished_order(int id);
     User get_user_ByName(String Uname);
     int register_user_db(User user);
     int save_edit_user_dao(User user);
}
