package is.hi.alicia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;


@Controller
public class MainController {

	@RequestMapping("/")
	public String getRoot(ModelMap model) {
		return "index";
	}
}
