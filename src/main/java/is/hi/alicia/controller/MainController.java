package is.hi.alicia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;


@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("/login")
	public String getRoot(ModelMap model) {
		System.out.println("in /login handler");
		model.addAttribute("name","steina");
		return "index";
	}
}
