package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public String login(String glname, String password, HttpSession session,String code){
        Admin login = adminService.login(glname, password);
        String code1 = (String)session.getAttribute("validationCode");
        if(code.equals(code1)){
        if(login!=null){
            session.setAttribute("login",login);
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/Admin/login.jsp";
        }}else {
            return "redirect:/Admin/login.jsp";
        }
    }
    @RequestMapping("exit")
    public String exitlogin(HttpSession session){
        session.removeAttribute("login");
        return "Admin/login";
    }

    @ResponseBody
    @RequestMapping("update")
    public Map<String,Object> update(Admin admin){
        HashMap<String, Object> result = new HashMap<>();
        try {
            adminService.update(admin);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }

}
