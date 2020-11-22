package cn.cy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/index")
    public ModelAndView toMain(String msg,Integer time){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("msg",msg);
        view.addObject("time",time);
        return view;
    }



}
