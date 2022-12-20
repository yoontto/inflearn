package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
