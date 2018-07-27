package house_sale.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import house_sale.model.House_sale;
import house_sale.model.PageCheck_order;
import house_sale.model.Request_order;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.model.User_time;
import house_sale.service.StaffDaoInterface;

@Controller
public class StaffController {
	
	@Autowired
	StaffDaoInterface staffDaoInterface;
	
	/*
	 * 返回主界面
	 */
	@RequestMapping("staff_index")
	public String staff_index() {
		return "staff_index";
	}
	/*
	 * 发布房屋销售信息
	 */
	@RequestMapping("announce_house")
	public String announce_house(){
		return "staffs_announce_house";
	}
	
	@RequestMapping("save_house")
	public String save_house(@Validated House_sale house_sale,BindingResult bindingResult,Model model) {
		if(!bindingResult.hasErrors()) {
		int insert = 0;	 
		boolean insertIsTrue;
		insertIsTrue = staffDaoInterface.announce_house_dao(house_sale);
		if(insertIsTrue==true)
			insert=1;
		else
			insert=2;
		model.addAttribute("insert", insert);
		return "staff_index";
		}else {
			model.addAttribute("insert", 3);
			return "staffs_announce_house";
		}
	}
	/*
	 * 根据户主姓名查询出房屋信息
	 */
	@RequestMapping("query_house_sale")
	public String query_house_sale(){
		
		return "staffs_choose_edit_house";
	}
	
	@RequestMapping("query_edit_house")
	public String query_house(@RequestParam("house_owner_name") String house_owner_name,Model model) {
		List<House_sale> list = null;
		list = staffDaoInterface.query_house_sale_dao(house_owner_name);
		System.out.println("list size："+list.size());
		model.addAttribute("edit_house_list",list);
		return "staffs_choose_edit_house";
	}
	/*
	 * 修改未被预订的房屋
	 */
	@RequestMapping("edit_house_message")
	public String edit_house_message(int house_id,Model model){
		House_sale house_sale =  staffDaoInterface.query_edit_houseById(house_id);
		 model.addAttribute("edit_house_sale",house_sale);
		return "staffs_edit_house";
	}
	
	@RequestMapping("save_edit_house")
	public String save_edit_house(@Validated House_sale house_sale,BindingResult bindingResult,Model model) {
		int is_save=0;
		if(!bindingResult.hasErrors()) {
			is_save=staffDaoInterface.save_edit_house(house_sale);
		}
		System.out.println("is_save:"+is_save);
		model.addAttribute("is_save", is_save);
		return "staffs_choose_edit_house";
	}
	/*
	 * 查询出所有的还未审核的请求订单
	 */
	@RequestMapping("query_all_request_order")
	public String query_all_request_order(String curPage,String pageSize,Model model){
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		 
		if (pageSize == null || "".equals(pageSize)) 
			pageSize = "3";
		 PageCheck_order page = new PageCheck_order();
		 page = staffDaoInterface.query_all_request_order(Integer.parseInt(curPage),Integer.parseInt(pageSize));
		 model.addAttribute("check_order_list",page);
		 model.addAttribute("re_order_list",page.getList());
		return "staffs_check_order";
		
	}
	/*
	 * 审核客户提交的请求订单，用户信息审核无误后通过
	 */
	@RequestMapping("check_user_order")
	public void check_user(int order_id,Model model,HttpServletResponse response){
		System.out.println("controller_order_ID:"+order_id);
		staffDaoInterface.edit_request_order(order_id);
		 try {
			response.sendRedirect("query_all_request_order");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("check_order_error")
	public void check_order_error(int order_id,Model model,HttpServletResponse response) {
		staffDaoInterface.edit_request_order_error(order_id);
		 try {
			response.sendRedirect("query_all_request_order");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	@RequestMapping("query_staff_information")
	public String query_staff_information(Model model,HttpSession session) {
		 int staff_id = Integer.parseInt(String.valueOf(session.getAttribute("staff_ID")));
		Staff staff = staffDaoInterface.query_personal_information(staff_id);
		model.addAttribute("staff_information", staff);
		return "staffs_edit_staff";
	}
	@RequestMapping("save_staff_information")
	public void save_staff_information(String name,int age,String password,String sex,HttpServletResponse response,HttpSession session)throws Exception {
		 int staff_id = Integer.parseInt(String.valueOf(session.getAttribute("staff_ID")));
		boolean t = staffDaoInterface.save_staff_information(name,age,sex,password,staff_id);
		PrintWriter out = response.getWriter();
		if(t==true) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert('EDIT SUCCESSFUL');");
			out.println("window.location.href='staff_index'");
			out.println("</script>");
	 }else {
		 out.println("<script type='text/javascript'>");
			out.println("window.alert('EDIT UNSUCCESSFUL');");
			out.println("window.location.href='query_staff_information'");
			out.println("</script>");
	 }
	}
}
