package house_sale.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import house_sale.model.House_sale;
import house_sale.model.PageCheck_order;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.model.User_time;

public interface StaffDaoInterface {

	/*
	 * 判断用户名密码是否正确若正确则返回"success"，跳转到相应首页，若不正确，则返回"failed"，
	 * 登录页面提示"用户名或密码错误"
	 */
	public abstract Staff judge_name_passowrd(String name);
	/*
	 * 参数查询出房屋信息
	 */
	
	public House_sale query_edit_houseById(int house_id);
	
	public abstract List<House_sale> query_house_sale_dao(String string);
	
	public abstract int save_edit_house(House_sale house_sale);
	/*
	 * 发布房屋销售信息
	 */
	public abstract boolean announce_house_dao(House_sale house_sale);
	/*
	 * 查询出状态为0(待审核)的请求订单,返回一个list用户信息组
	 */
	public abstract PageCheck_order query_all_request_order(int curPage, int pageSize);

	public void edit_request_order(int order_id);

	public abstract void edit_request_order_error(int order_id);

	public abstract Staff query_personal_information(int staff_id);

	public abstract boolean save_staff_information(String name, int age, String sex, String password, int staff_id);

}
