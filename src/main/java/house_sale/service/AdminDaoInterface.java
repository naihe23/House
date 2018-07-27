package house_sale.service;
/*���ߣ��ű�
 * ���ã�����Ľӿ�
 */
import java.util.List;

import house_sale.model.Admin;
import house_sale.model.AdminPassword;
import house_sale.model.Staff;
import house_sale.model.User;
import javafx.util.converter.ShortStringConverter;

public interface AdminDaoInterface {
	/*
	 * ��ѯ�û�������һ��list��
	 */
	public abstract List<User> query_user_dao();
	
	public abstract List<User> query_user_dao(String string);
	/*
	 * ����û����ɹ�����true
	 */
	public abstract boolean ban_user_dao(String string);
	/*
	 * ɾ���û�
	 */
	public abstract boolean delete_user(String id);
	/*
	 * ��ѯְԱ������һ��list��
	 */
	public abstract List<Staff> query_staff_dao();
	/*
	 * ���ְԱ���ɹ�����true
	 */
	public abstract boolean ban_staff_dao(String string);
	/*
	 * ɾ��ְԱ
	 */
	public abstract boolean delete_staff(String string);
	
	public abstract boolean check_pass_service(int user_id);
	public abstract boolean check_unpass_service(int user_id);
	public abstract List<Admin> query_admin(int id);
	public abstract boolean admin_info_edit(String admin_name, int admin_age, String admin_sex, String password, int admin_id);
	public abstract List<User> query_concret_user(String user_name);
	public abstract List<Staff> query_concret_staff(String staff_name);
	AdminPassword judge_name_passowrd(String Uname);
}
