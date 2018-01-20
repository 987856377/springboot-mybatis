package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daier on 2018/1/18.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("addUser")
    public String addUser(HttpServletRequest request,Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        userService.addUser(user);
        model.addAttribute("list",userService.getAllUser());
        return "result";
    }

    @RequestMapping("updateUser")
    public String updateUser(@RequestParam("id") int id,Model model){
        User user = new User();
        user.setId(id);
        user.setPassword("3412341234");
        userService.updateUser(user);
        model.addAttribute("list",userService.getAllUser());
        return "result";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id, Model model){
        userService.deleteUserById(id);
        model.addAttribute("list",userService.getAllUser());
        return "result";
    }

    @RequestMapping("userInfo")
    public String getUserInfo(@RequestParam("id") int id,Model model){
        model.addAttribute("list",userService.getUserById(id));
        return "userInfo";
    }

    @RequestMapping("getAllUser")
    public String getAllUser(Model model){
        model.addAttribute("list",userService.getAllUser());
        return "result";
    }

    @RequestMapping("userList")
    public String getUserList(@RequestParam(value="pageNum",defaultValue = "1") int pageNum,Model model){
        PageHelper.startPage(pageNum,2);

        List<User> list = userService.getAllUser();
        PageBean<User> pageBean = new PageBean<User>(list);

        model.addAttribute("page",pageBean);
        return "userList";
    }

}
