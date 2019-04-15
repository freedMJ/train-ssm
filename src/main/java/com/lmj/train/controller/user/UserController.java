package com.lmj.train.controller.user;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.lmj.train.model.User;
import com.lmj.train.service.IRouteService;
import com.lmj.train.service.IUserService;
import com.lmj.train.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    /**
     *
     * 用户控制器
     * **/
    @Autowired
    private IUserService userService;
    @Autowired
    private IRouteService routeService;
    //用户登录
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public Map<String,String> login(HttpServletRequest request, @RequestBody User user){
        User relUser = userService.loginUser(user);
        String msg=null;
        if(relUser!=null){
            msg="ok";
            HttpSession session = request.getSession();
            session.setAttribute("user",user.getUsername());
            session.setAttribute("userType",user.getType());
        }else{
            msg="该用户不存在";
        }
      Map<String,String> map = new HashMap<String,String>();
        map.put("Status",msg);
        return map;
    }
    //用户退出
    @GetMapping("/userOut")
    public String userOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userType");
        return "index";
    }
    //用户注册
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    @ResponseBody
    public Map<String,String>  register(Model model, @RequestBody User user){
        String username = user.getUsername();
        String msg=null;
       int isUser = userService.getUserByName(username);
       if(isUser==0){
           msg="注册成功，请返回进行登陆或返回首页";
           user.setType(1);
           userService.registerUser(user);
       }else{
           msg="该用户已经存在";
       }
        Map<String,String> map =new HashMap<String, String>();
       map.put("msg",msg);
       return map;
    }

}
