package house_sale.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.ListSelectionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.javafx.sg.prism.NGShape.Mode;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.org.apache.xpath.internal.operations.Mod;

import house_sale.model.Admin;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.service.AdminDaoInterface;
/*���ߣ��ű�
 * ���ã����ڹ���Ա����Ŀ�����
 */
@Controller
public class AdminController {
	
      @Resource
      AdminDaoInterface adminDaoInterface;
      /*
       * ����û���ѯ
       */
      @RequestMapping("admin_check_users")
      public String query_users(Model model) {
    	  List<User> list= null;
    	   list = adminDaoInterface.query_user_dao();
    	  model.addAttribute("check_user_list",list);//�����Լ���
    	  return  "admin_check_user";
      }
	/*
	 * ��ѯ�û���Ϣ
	 */
	@RequestMapping("query_user")
	public String query_user(String string,Model model){
		List<User> list = null;
		list = adminDaoInterface.query_user_dao(string);
		model.addAttribute("user_list",list);
		return "admin_user";
		
	}
	/*
	 * ���ͨ��
	 */
	@RequestMapping("check_pass")
	public String check_pass(int user_id,Model model,HttpServletResponse response) {
		boolean pass_true=adminDaoInterface.check_pass_service(user_id);
		
		try {
			PrintWriter out = response.getWriter();
			if (pass_true == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='admin_check_users'");
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	/*
	 * ��˲�ͨ��
	 */
	@RequestMapping("check_unpass")
	public String check_unpass(int user_id,Model model,HttpServletResponse response) {
     boolean unpass_true=adminDaoInterface.check_unpass_service(user_id);
		
		try {
			PrintWriter out = response.getWriter();
			if (unpass_true == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='admin_check_users'");
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * ����û�
	 */
	@RequestMapping("ban_user")
	public void ban_user(String user_name,Model model,HttpServletResponse response){
        boolean is_ban=adminDaoInterface.ban_user_dao(user_name);
		
		try {
			PrintWriter out = response.getWriter();
			if (is_ban == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='query_user'");//��Ӧ����ӳ��
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * ɾ���û�
	 */
	@RequestMapping("delete_user")
	public void delete_user(String user_name,Model model,HttpServletResponse response){
           boolean is_delete=adminDaoInterface.delete_user(user_name);
		
		try {
			PrintWriter out = response.getWriter();
			if (is_delete == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='query_user'");//��Ӧ����ӳ��
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * ��ѯָ���û�
	 */
	@RequestMapping("query_concret_user")
	public String query_concret_user(String user_name,Model model) {
		List<User> list = null;
		list = adminDaoInterface.query_concret_user(user_name);
		model.addAttribute("user_list",list);
		return "admin_user";
	}
	
	/* 
	 * ��ѯְԱ��Ϣ
	 */
	@RequestMapping("query_staff")
	public String query_staff(Model model){
		
		List<Staff> list = new ArrayList<>();
		
		list = adminDaoInterface.query_staff_dao();
		
		model.addAttribute("staff_list",list);
		return "admin_staff";
	}
	/*
	 * ��ѯָ��ְԱ
	 */
	@RequestMapping("query_concret_staff")
	public String query_concret_staff(String staff_name,Model model) {
		List<Staff> list = null;
		list = adminDaoInterface.query_concret_staff(staff_name);
		model.addAttribute("staff_list",list);
		return "admin_staff";
	}
	/*
	 * ���ְԱ
	 */
	@RequestMapping("ban_staff")
	public void ban_staff(String staff_name,Model model,HttpServletResponse response){
      boolean is_ban=adminDaoInterface.ban_staff_dao(staff_name);
		
		try {
			PrintWriter out = response.getWriter();
			if (is_ban == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='query_staff'");//��Ӧ����ӳ��
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * ɾ��ְԱ
	 */
	@RequestMapping("delete_staff")
	public void delete_staff(String staff_name,Model model,HttpServletResponse response){
          boolean is_delete=adminDaoInterface.delete_staff(staff_name);
		
		try {
			PrintWriter out = response.getWriter();
			if (is_delete == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='query_staff'");//��Ӧ����ӳ��
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * ��ʾ����Ա������Ϣ
	 */
	@RequestMapping("admin_info")
		public String query_admin( Model model,HttpSession session){
		    int admin_id = Integer.parseInt(String.valueOf(session.getAttribute("admin_ID")));
			List<Admin> list = new ArrayList<>();
			
			list = adminDaoInterface.query_admin(admin_id);
			
			model.addAttribute("admin_list",list);
			return "admin_infomation";
		
		
	}
	/*
	 * �޸Ĺ���Ա������Ϣ
	 */
	@RequestMapping("edit_admin")
	public void edit_admin(String admin_name,int admin_age,String admin_sex,String password,Model model,HttpServletResponse response,HttpSession session) {
    
		System.out.println("admin_name��"+admin_name);
		System.out.println("admin_age��"+admin_age);
		System.out.println("admin_sex��"+admin_sex);
		System.out.println("password��"+password);
		int admin_id = Integer.parseInt(String.valueOf(session.getAttribute("admin_ID")));
		boolean edit=adminDaoInterface.admin_info_edit(admin_name,admin_age,admin_sex,password,admin_id);
		
		try {
			PrintWriter out = response.getWriter();
			if (edit == true) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert('SUCCESSFUL');");
				out.println("window.location.href='admin'");
				out.println("</script>");
			} else
				out.println("<script type='text/javascript'>");
			    out.println("window.alert('UNSUCCESSFUL');");
			    out.println("window.location.href='admin_infomation'");
			    out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
	}
	
	
}
