package com.example.demo.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Test.Cat;
import com.example.demo.Test.AnimalDAO;
import java.util.ArrayList;

@Controller
public class GreetingController {



    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        Cat cat = new Cat();
        model.addAttribute("name",cat.tiengkeu());

        AnimalDAO dao = new AnimalDAO();
        ArrayList<Cat> listCat = dao.getAll();
        model.addAttribute("listCat",listCat);
        return "greeting/index";
    }

}
