package house_sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/logon")
	public String login() {
		return "login_user";
	}

	@RequestMapping("/staff")
	public String login1() {
		return "staff_index";
	}
	@RequestMapping("/user")
	public String user_index() {
		return "users_index";
	}
	
	@RequestMapping("admin")
	public String admin_index() {
		return "admin_index";
	}
	
	@RequestMapping(value="house_position",method=RequestMethod.GET)
	public String house_position(String house_pos,Model model) {
		model.addAttribute("house_pos",house_pos);
		return "users_position";
	}
}
