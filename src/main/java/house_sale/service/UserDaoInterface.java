package house_sale.service;

import java.util.List;

import house_sale.model.House_Order_state;
import house_sale.model.House_sale;
import house_sale.model.Order_recode;
import house_sale.model.Request_order;
import house_sale.model.User;

public interface UserDaoInterface {
	/*
	 * �ж��û��������Ƿ���ȷ����ȷ�򷵻�"success"����ת����Ӧ��ҳ��������ȷ���򷵻�"failed"��
	 * ��¼ҳ����ʾ"�û������������"
	 */
	public abstract User judge_name_passowrd(String name);
	/*
	 * ע��ͻ�
	 */
	public abstract boolean register_user_dao(User user);
	/*
	 * ���ݿͻ���ѯ������ѯ������Ҫ��ķ���
	 */
	public abstract List<House_sale> query_house_dao();
	/*
	 * �ͻ�����idԤ������,����һ��booleanֵ
	 */
	public abstract boolean book_house_dao(int house_id, int user_id);
	/*
	 * ����id��ѯ���ͻ����ύ�����󶩵������������
	 */
	public abstract List<House_Order_state> query_request_order_dao(int u_id);
	/*
	 * ���Ѿ�ͨ�������󶩵��������ɹ�����true��ʧ�ܷ���false��ͬʱ�ı���Ӧ��״̬
	 */
	public abstract boolean pay_order_dao(int id);
	/*
	 * ��ѯ������ɵĶ�����������
	 */
	public abstract List<House_Order_state> query_finished_order_dao(int id);
 
	/*
	 * ��ѯ�ͻ�������Ϣ
	 */
	public abstract User query_personal_message_dao(int id);
	
	public abstract List<House_sale> query_houseByName_dao(String owner_name);
	
	public abstract User query_user_service(int user_id);
	
	int save_edit_user(User user);

	boolean pay_for_order(long balance, int user_id, int request_id);
}
