package com.lmj.train.controller.user;

import com.lmj.train.model.Order;
import com.lmj.train.model.Orders;
import com.lmj.train.model.Route;
import com.lmj.train.model.User;
import com.lmj.train.model.pojo.OrderInfo;
import com.lmj.train.model.pojo.RouteInfo;
import com.lmj.train.service.IRouteService;
import com.lmj.train.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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
    public Map<String,String> login(Model model,HttpSession session, @RequestBody User user){
        User relUser = userService.loginUser(user);
        String msg=null;
        if(relUser!=null){
            msg="ok";
            //HttpSession session = request.getSession();
            //session.setAttribute("userName",relUser.getUsername());
            session.setAttribute("userType",relUser.getType());
            int uid=relUser.getId();
            session.setAttribute("user",relUser);
            session.setAttribute("uid",relUser.getId());
            //model.addAttribute("Uid",relUser.getId());
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
        return "redirect:index";
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

    //支付页面
    @GetMapping("buyTrain")
    public String buyTrain(Model model,int id){
        RouteInfo routeInfoById = routeService.findRouteInfoById(id);
        System.out.println(routeInfoById);
        model.addAttribute("routeInfo",routeInfoById);
        return "buyTrain";
    }
    @PostMapping("buyTrain")
    @ResponseBody
    public Map<String,String> buyTrain(HttpSession session,@RequestBody OrderInfo orderInfo){
        System.out.println(orderInfo);
        //HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        //Integer id = user.getId();
        System.out.println(uid);
        int rid = orderInfo.getRid();
        String trainName = orderInfo.getTrainName();
        Long startTime = orderInfo.getStartTime();
        Long endTime = orderInfo.getEndTime();
        int placeType = orderInfo.getPlaceType();
        float price = orderInfo.getPrice();

        Orders order = new Orders();
        order.setPayStatus(1);
        order.setUid(uid);
        order.setRid(rid);
        order.setPlaceType(placeType);
        order.setPrice(price);
        //根据uid,rid查找订单
        Orders isorder = userService.findOrderByUidAndRid(uid, rid);
        System.out.println(isorder);
        String errMsg=null;
        String msg=null;
        if(isorder!=null){
            errMsg="该订单已经存在，请不要重复购买";
        }else{
            userService.saveOrderInfo(order);
            //根据买的座位种类减去路线表的座位数一
            if(placeType==0){
                routeService.routeSleepBerthNumsLessOne(rid);
            }else if(placeType==1){
                routeService.routeSeatNumsLessOne(rid);
            }else if(placeType==2){
                routeService.routeStandNumsLessOne(rid);
            }
            msg="success";
        }
        Map<String, String> map = new HashMap<>();
        map.put("errMsg",errMsg);
        map.put("msg",msg);
        return map;
    }
    @GetMapping("successBuyTrain")
    public String successBuyTrain(){
        return "successBuyTrain";
    }
    //用户中心
    @GetMapping("/userContre")
    public String userContre(HttpSession session,Model model){
        int uid = (int) session.getAttribute("uid");
            //根据uid查找订单
            List<Orders> orderList = userService.findOrderByUid(uid);
            List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
            for (Orders order : orderList) {
                Route route = routeService.findRouteById(order.getRid());
                String startPoint = route.getStartPoint();
                String endPoint = route.getEndPoint();
                Long startTime = route.getStartTime();
                Long endTime = route.getEndTime();
                String trainName = route.getTrainName();
                Integer payStatus = order.getPayStatus();
                int placeType = order.getPlaceType();
                float price = order.getPrice();
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setTrainName(trainName);
                orderInfo.setStartPoint(startPoint);
                orderInfo.setEndPoint(endPoint);
                orderInfo.setStartTime(startTime);
                orderInfo.setEndTime(endTime);
                orderInfo.setPlaceType(placeType);
                orderInfo.setPrice(price);
                orderInfos.add(orderInfo);
            }
        long currentTimeStamp = (new Date().getTime())/1000;
            model.addAttribute("currentTimeStamp",currentTimeStamp);
            model.addAttribute("orderInfos",orderInfos);
        return "userContre";
    }
}
