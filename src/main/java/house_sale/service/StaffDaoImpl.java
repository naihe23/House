package house_sale.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import house_sale.dao.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import house_sale.model.House_sale;
import house_sale.model.PageCheck_order;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.model.User_time;
import house_sale.repository.HouseRepository;
import house_sale.repository.Request_orderRepository;
import house_sale.repository.StaffRepository;

import javax.annotation.Resource;

@Service
public class StaffDaoImpl implements StaffDaoInterface {

	@Autowired
	HouseRepository houseReposity;
	@Autowired
	Request_orderRepository request_orderRepository;
	@Autowired
	StaffRepository staffRepository;
	@Resource
	StaffDao staffDao;
	@Override
	public Staff judge_name_passowrd(String Uname) {
		System.out.println("Uname"+Uname);
		return staffDao.get_staff_ByName(Uname);
	}

	@Override
	public List<House_sale> query_house_sale_dao(String house_owner_name) {
		return houseReposity.get_edit_house(house_owner_name);
	}

	@Override
	public boolean announce_house_dao(House_sale house_sale) {
		
		return houseReposity.save_house_db(house_sale);
	}

	@Override
	public PageCheck_order query_all_request_order(int curPage, int pageSize) {
		return request_orderRepository.query_request_order( curPage,  pageSize);
	}

	@Override
	public House_sale query_edit_houseById(int house_id) {
		return houseReposity.get_edit_houseById(house_id);
	}

	@Override
	public int save_edit_house(House_sale house_sale) {
		return houseReposity.save_edit_house_dao(house_sale);
	}

	@Override
	public void edit_request_order(int order_id) {
		request_orderRepository.edit_order_state(order_id);
	}

	@Override
	public void edit_request_order_error(int order_id) {
		 request_orderRepository.edit_order_error(order_id);
	}

	@Override
	public Staff query_personal_information(int staff_id) {
		// TODO Auto-generated method stub
		return staffRepository.find_personal_information(staff_id);
	}

	@Override
	public boolean save_staff_information(String name, int age, String sex, String password, int staff_id) {
		// TODO Auto-generated method stub
		return staffRepository.save_staff_infor(name,age,sex,password,staff_id);
	}

}
