package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
// handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }


    // handles requests at /hello/goodbye
//    @GetMapping("goodbye")
//
//    public String goodbye(){
//        return "Goodbye, Spring";
//    }

    // handles requests of form /hello?name=
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam (@RequestParam String name, Model model){
        String greeting = "Hello, " + name +"!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // handles request of form /hello/LaunchCode
    @GetMapping("hello/{name}")

    public String helloWithPathPram (@PathVariable String name, Model model) {
        String greeting = "Hello, " + name +"!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
     return "form";
    }


    @GetMapping("hello-names")
   public String hellonames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Londa");
        names.add("Neno");
        names.add("Best Baby");
        model.addAttribute("names", names);

        return "hello-list";
   }


}
