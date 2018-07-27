package house_sale.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import house_sale.dao.UserDao;
import house_sale.util.NameUtil;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import house_sale.model.House_Order_state;
import house_sale.model.House_sale;
import house_sale.model.Order_recode;
import house_sale.model.Request_order;
import house_sale.model.User;
import house_sale.repository.HouseRepository;
import house_sale.repository.Request_orderRepository;
import house_sale.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserDaoImpl implements UserDaoInterface {

    @Autowired
    HouseRepository houseReposity;
    @Autowired
    Request_orderRepository request_orderRepository;
    @Autowired
    UserRepository userRepository;
    @Resource
    UserDao userDao;

    @Override
    public User judge_name_passowrd(String Uname) {
        return userDao.get_user_ByName(NameUtil.toCN(Uname));
    }

    @Override
    public boolean register_user_dao(User user) {
        int i = -1;
         i  = userDao.register_user_db(user);
        if(i>0){
            return true;
        }
        return false;

    }

    @Override
    public List<House_sale> query_house_dao() {
        return userDao.query_all_house();
    }

    @Override
    public boolean book_house_dao(int house_id, int user_id) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("house_id",house_id);
        map.put("user_id",user_id);
        int i = userDao.insert_request_order(map,time());
        int n = userDao.edit_request_order_state_dao(house_id);
        System.out.println("book_i_n："+i+" "+n);
        if(i>0&&n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<House_Order_state> query_request_order_dao(int u_id) {
        return userDao.user_query_request_order(u_id);
    }

    @Override
    public boolean pay_order_dao(int id) {
        return false;
    }

    @Override
    public List<House_Order_state> query_finished_order_dao(int id) {
        return userDao.query_finished_order(id);
    }

    @Override
    public User query_personal_message_dao(int user_id) {
        return userRepository.get_user_information_ById(user_id);
    }

    @Override
    public int save_edit_user(User user) {
        return userDao.save_edit_user_dao(user);
    }

    @Override
    public boolean pay_for_order(long balance, int user_id, int request_id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("balance",balance);
        map.put("user_id",user_id);
        int ba = userDao.update_balance_dao(map);
        int re = userDao.edit_request_order_state_finish(request_id);
        if(ba>0&&re>0){
            return true;
        }
        return false;
    }

    @Override
    public List<House_sale> query_houseByName_dao(String owner_name) {

        return userDao.query_all_house(owner_name);
    }

    @Override
    public User query_user_service(int user_id) {
        return userDao.query_user(user_id);
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

}
