package uz.pdp.onlineshop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloServlet{

    @GetMapping
    public String getIndex(){

        return "redirect:/products";
    }

}