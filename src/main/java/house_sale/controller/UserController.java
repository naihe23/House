package house_sale.controller;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import house_sale.service.UserDaoInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import house_sale.util.NameUtil;
import house_sale.model.AdminPassword;
import house_sale.model.House_Order_state;
import house_sale.model.House_sale;
import house_sale.model.Staff;
import house_sale.model.User;
import house_sale.service.AdminDaoInterface;
import house_sale.service.StaffDaoInterface;

@Controller
public class UserController {
	@Autowired
	UserDaoInterface userDaoInterface;
	@Autowired
	StaffDaoInterface staffDaoInterface;
	@Autowired
	AdminDaoInterface adminDaoInterface;

	 @RequestMapping("query_house")//查询可预订的房屋
	 public String  query_house1(Model model){
		 List<House_sale> list =null;
		list= userDaoInterface.query_house_dao();
		model.addAttribute("house_list", list);
		return "users_book";
	 }
	 
	 @RequestMapping(value="query_house_byName",method=RequestMethod.GET)//查询可预订的房屋
     @ResponseBody
	 public List<House_sale>  query_house_byName(String house_owner_name,Model model){
		 PrintWriter out = null ;
		 System.out.println("byname:"+house_owner_name);
		 List<House_sale> list =null;
		list= userDaoInterface.query_houseByName_dao(house_owner_name);
	//	model.addAttribute("house_list", list);
		System.out.println("list_size:"+list.size());
       //  JSONArray.fromObject(list);
		  return list;

		//return "users_book";
	 }
	 
	 /*
	  * 根据传过来的id预订对应房屋通过返回的boolean值在界面上弹出预订成功还是失败
	  */
	 @RequestMapping("book_house")
	 public void book_house(int house_id,Model model,HttpSession session,HttpServletResponse response)throws Exception{
		 System.out.println("con_house_id:"+house_id);
		 int user_id = Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
		 
		 boolean request_order=userDaoInterface.book_house_dao(house_id,user_id);
		 PrintWriter out = response.getWriter();
		 if(request_order == true) {
			    out.println("<script type='text/javascript'>");
				out.println("window.alert('BOOK SUCCESSFUL');");
				out.println("window.location.href='query_house'");
				out.println("</script>");
		 }else {
			 out.println("<script type='text/javascript'>");
				out.println("window.alert('BOOK UNSUCCESSFUL');");
				out.println("window.location.href='query_house'");
				out.println("</script>");
		 }
	 }

	 /*
	  * 查询客户已提交的房屋预订请求订单
	  */
	 @RequestMapping("user_query_request_order")
	 public String query_request_order(Model model,HttpSession session){
		 int user_id = Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
		 List<House_Order_state> list = userDaoInterface.query_request_order_dao(user_id);
		 int size = list.size();
		 System.out.println("size:"+size);
		 System.out.println("state2:"+list.get(0).getRequest_state()+" "+list.get(1).getRequest_state());
		 model.addAttribute("list_size", size);
		 model.addAttribute("user_request_order_state", list);
		return "users_booked_order";
		 
	 }
	 /*
	  * 客户对已通过的请求订单进行付款操作,通过返回的boolean值在界面上弹出付款成功还是失败
	  */
	 @RequestMapping("pay_order")
	 public void  pay_order(int request_id,Long  price ,HttpSession session,Model model,HttpServletResponse response)throws Exception{
		 int user_id = Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
		 PrintWriter out = response.getWriter();
		 long balance = userDaoInterface.query_user_service(user_id).getUser_balance();
		 if(balance>=price) {
			 System.out.println("Request_id:"+request_id);
			 balance = balance - price;
			 boolean  isBook  = userDaoInterface.pay_for_order(balance,user_id,request_id);
			 if(isBook==true) {
				    out.println("<script type='text/javascript'>");
					out.println("window.alert('PAY SUCCESSFUL');");
					out.println("window.location.href='user_query_request_order'");
					out.println("</script>");
			 }else {
				 out.println("<script type='text/javascript'>");
					out.println("window.alert('PAY UNSUCCESSFUL');");
					out.println("window.location.href='user_query_request_order'");
					out.println("</script>");
			 }
		 }else {
			 out.println("<script type='text/javascript'>");
				out.println("window.alert('The balance is not enough!');");
				out.println("window.location.href='user_query_request_order';");
				out.println("</script>");
		 }
		 
		 
	 }
	 /*
	  * 查询已完成的订单
	  */
	 @RequestMapping("query_finished_order")
	 public String query_finished_order(Model model,HttpSession session){
		 int user_id = Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
		 List<House_Order_state> list = userDaoInterface.query_finished_order_dao(user_id);
		 
		 model.addAttribute("finish_list", list);
		return "users_finished_order";
	 }
	
	 @RequestMapping("logins")//判断登录类型，根据登陆类型判断用户名密码是否正确，核对无误后跳转到相应界面
	 public String login(String Uname,String Upassword,String login_inputType_select,HttpSession session,Model model,HttpServletResponse response)throws Exception{
		 PrintWriter out = response.getWriter();
		 if(Integer.parseInt(login_inputType_select) == 0) {
			 //String name = NameUtil.toCN(Uname);
			 
				System.out.println("用户");
				
				System.out.println("密码:"+Upassword);

				User user = userDaoInterface.judge_name_passowrd(Uname);
				System.out.println("类型:"+user.getUser_state());

				if(user.getUser_state() == 1){
					System.out.println("类型为:"+user.getUser_state());
				if(user.getUser_password().equals(Upassword)){
					System.out.println("密码正确");
					model.addAttribute("insert", 1);
				    session.setAttribute("user_ID", user.getUser_ID());
				    session.setAttribute("user_name", user.getUser_name());
				    out.println("<script type='text/javascript'>");
					//out.println("window.alert('username or password error!');");
					out.println("window.location.href='user'");
					out.println("</script>");
				}
				else{
					out.println("<script type='text/javascript'>");
					out.println("window.alert('username or password error!');");
					out.println("window.location.href='logon'");
					out.println("</script>");
				}
				}
				else{
					System.out.println("");
				    out.println("<script type='text/javascript'>");
					out.println("window.alert('You have been baned');");
					out.println("window.location.href='logon'");
					out.println("</script>");
				}
				
		 
		 }else if(Integer.parseInt(login_inputType_select) == 1){
			   String name = NameUtil.toCN(Uname);
			 
				System.out.println("staff:"+Uname);
				System.out.println("员工姓名:"+name);
				System.out.println("密码:"+Upassword);

				Staff staff = staffDaoInterface.judge_name_passowrd(name);
				if(staff.getStaff_state()==1){
				if(staff.getStaff_password().equals(Upassword)){
					
					model.addAttribute("insert", 1);
				    session.setAttribute("staff_ID", staff.getStaff_ID());
				    session.setAttribute("staff_name", name);
				    out.println("<script type='text/javascript'>");
					//out.println("window.alert('username or password error!');");
					out.println("window.location.href='staff'");
					out.println("</script>");
				}
				else{
					out.println("<script type='text/javascript'>");
					out.println("window.alert('username or password error!');");
					out.println("window.location.href='logon'");
					out.println("</script>");
				}
				}
				else{
					System.out.println("");
				    out.println("<script type='text/javascript'>");
					out.println("window.alert('You have been baned');");
					out.println("window.location.href='logon'");
					out.println("</script>");
				}
		 }else if(Integer.parseInt(login_inputType_select) == 2){
			   String name = NameUtil.toCN(Uname);
				 
				System.out.println("管理员");
				System.out.println("管理员姓名:"+name);
				System.out.println("密码:"+Upassword);

				AdminPassword admin = adminDaoInterface.judge_name_passowrd(name);
				
				if(admin.getStaff_password().equals(Upassword)){
					
					model.addAttribute("insert", 1);
				    session.setAttribute("admin_ID", admin.getAdmin_ID());
				    session.setAttribute("admin_name", name);
				    out.println("<script type='text/javascript'>");
					//out.println("window.alert('username or password error!');");
					out.println("window.location.href='admin'");
					out.println("</script>");
				}
				else{
					out.println("<script type='text/javascript'>");
					out.println("window.alert('username or password error!');");
					out.println("window.location.href='logon'");
					out.println("</script>");
				}
				}
				
		 
		return null;
	 }
	 
	 @RequestMapping("register_user")//客户注册
	 public String register_user(Model model){
		 
		 return "user_register";
	 }
	 
	 @RequestMapping("register")//客户注册
	 public void register_user(@Validated User user,BindingResult bindingResult,Model model,HttpServletResponse response)throws Exception{
		 PrintWriter out = response.getWriter();
		 if(!bindingResult.hasErrors()) {
				System.out.println("进入表单校验");
				boolean insertIsTrue;			
				insertIsTrue = userDaoInterface.register_user_dao(user);				
				 if( insertIsTrue == true) {
					 System.out.println("注册成功");
					    out.println("<script type='text/javascript'>");
						out.println("window.alert(' SUCCESSFUL');");
						out.println("window.location.href='logon'");
						out.println("</script>");
						
				 }else {
					 System.out.println("注册失败");
					    out.println("<script type='text/javascript'>");
						out.println("window.alert(' UNSUCCESSFUL');");
						out.println("window.location.href='register_user'");
						out.println("</script>");
						
						
				 }
				 
				}else {
					System.out.println("不能为空");
					 out.println("<script type='text/javascript'>");
						out.println("window.alert('error!');");
					    out.println("window.location.href='register_user'");
						out.println("</script>");
					
				}
		
	 }
	 /*
	  * 查询客户个人信息
	  */
	 @RequestMapping("edit_user_message")
	 public String edit_user_message(int edit,Model model,HttpSession session){
		 int user_id=Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
		 System.out.println("user_ID"+user_id);
		 User list =null;
			list= userDaoInterface.query_user_service(user_id);
			model.addAttribute("list", list);
		 if(edit==1) {
			 return "user_edit_personal_information";
		 }else{
			 return "user_edit_message";
		 }
		 
	 }
	 @RequestMapping("save_edit_user")
	 public String save_edit_user(@Validated User user,BindingResult bindingResult,Model model,HttpSession session) {
			int is_save=0;
			 int user_id=Integer.parseInt(String.valueOf(session.getAttribute("user_ID")));
			if(!bindingResult.hasErrors()) {
				user.setUser_ID(user_id);
				is_save=userDaoInterface.save_edit_user(user);
			
			}
			System.out.println("is_save:"+is_save);
			model.addAttribute("is_save", is_save);
		return "users_index";
		 
	 }
}
