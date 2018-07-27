package house_sale.service;
/*作者：张彬
 * 作用：接口的实现
 */
import java.util.List;

import house_sale.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import house_sale.model.Admin;
import house_sale.model.AdminPassword;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.repository.AdminRepository;
import house_sale.repository.StaffRepository;
import house_sale.repository.UserRepository;

import javax.annotation.Resource;

@Service("adminDaoInterface")
public class AdminDaoImpl implements AdminDaoInterface {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminReposity;
	@Autowired
	StaffRepository staffRepository;
	@Resource
	AdminDao adminDao;
	@Override
	public AdminPassword judge_name_passowrd(String Uname) {
		System.out.println("Uname"+Uname);
		return adminDao.get_admin_ByName(Uname);
	}
	@Override
	public List<User> query_user_dao(String string) {
		return userRepository.query_users();
	}

	@Override
	public boolean ban_user_dao(String str) {
		// TODO Auto-generated method stub
		return userRepository.ban_users(str);
	}

	@Override
	public boolean delete_user(String id) {
		// TODO Auto-generated method stub
		return userRepository.del_users_dao(id);
	}

	@Override
	public List<Staff> query_staff_dao() {
 
		return staffRepository.query_staff();
	}

	@Override
	public boolean ban_staff_dao(String str) {
		// TODO Auto-generated method stub
		return  staffRepository.ban_staff(str);
	}

	@Override
	public boolean delete_staff(String str) {
		// TODO Auto-generated method stub
		return staffRepository.delete_staff(str);
	}

	

	@Override
	public List<User> query_user_dao() {
		
		return userRepository.query_check_user();
	}

	@Override
	public boolean check_pass_service(int user_id) {
		
		return userRepository.check_pass_dao(user_id);
	}

	@Override
	public boolean check_unpass_service(int user_id) {
		// TODO Auto-generated method stub
		return userRepository.check_unpass_dao(user_id);
	}
	@Override
	public List<Admin> query_admin(int id){
		return staffRepository.query_admin(id);
	}
	@Override
	public boolean admin_info_edit(String admin_name, int admin_age, String admin_sex, String password,int admin_id) {
		return staffRepository.edit_admin(admin_name,admin_age,admin_sex,password,admin_id);
	}
    @Override
    public List<User> query_concret_user(String name){
    	return userRepository.query_concret_user(name);
    }
    public List<Staff> query_concret_staff(String name){
    	return staffRepository.query_concret_staff(name);
    }
}
