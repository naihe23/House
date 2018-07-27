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
	 * �ж��û��������Ƿ���ȷ����ȷ�򷵻�"success"����ת����Ӧ��ҳ��������ȷ���򷵻�"failed"��
	 * ��¼ҳ����ʾ"�û������������"
	 */
	public abstract Staff judge_name_passowrd(String name);
	/*
	 * ������ѯ��������Ϣ
	 */
	
	public House_sale query_edit_houseById(int house_id);
	
	public abstract List<House_sale> query_house_sale_dao(String string);
	
	public abstract int save_edit_house(House_sale house_sale);
	/*
	 * ��������������Ϣ
	 */
	public abstract boolean announce_house_dao(House_sale house_sale);
	/*
	 * ��ѯ��״̬Ϊ0(�����)�����󶩵�,����һ��list�û���Ϣ��
	 */
	public abstract PageCheck_order query_all_request_order(int curPage, int pageSize);

	public void edit_request_order(int order_id);

	public abstract void edit_request_order_error(int order_id);

	public abstract Staff query_personal_information(int staff_id);

	public abstract boolean save_staff_information(String name, int age, String sex, String password, int staff_id);

}
