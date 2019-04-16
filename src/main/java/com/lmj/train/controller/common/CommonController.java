package com.lmj.train.controller.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmj.train.model.Route;
import com.lmj.train.model.User;
import com.lmj.train.model.pojo.OrderInfo;
import com.lmj.train.model.pojo.RouteInfo;
import com.lmj.train.service.IRouteService;
import com.lmj.train.utils.ConstantUtils;
import com.lmj.train.utils.PageNumsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private IRouteService routeService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model, @RequestParam(name="pageNum",defaultValue = "1")int pageNum){
        //分页查询列车相关信息
        PageHelper.startPage(pageNum, ConstantUtils.size);
        //首页显示未抵达的火车，抵达时间不超过一个小时时间的火车，未发车的火车
        long currentTimeStamp = (new Date().getTime())/1000;
        long time=currentTimeStamp-ConstantUtils.notMoreArrivalTime;
        List<Route> allRoute = routeService.findAllRouteByLessTime(time,currentTimeStamp);
        PageInfo<Route> routesPageInfo = new PageInfo<>(allRoute);
        int pages = routesPageInfo.getPages();//查询总数
        //设置一个页面最多允许5个分页
        //获取时间戳
        model.addAttribute("currentTimeStamp",currentTimeStamp);
        PageNumsList pageNumsList = new PageNumsList();
        int[] pageNumArray = pageNumsList.getPageNumArray(pageNum, pages);
        model.addAttribute("routesPageInfo",routesPageInfo);
        model.addAttribute("pageNumArray",pageNumArray);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        return "index";
    }
    //购票中心
    @GetMapping("/buyTicketContre")
    public String buyTicketContre(Model model,@RequestParam(name="pageNum",defaultValue = "1")int pageNum){
        //查询所有未发车的列车
        //购票中心显示发车之前三十分钟以内的火车
        long currentTimeStamp = (new Date().getTime())/1000;
        //System.out.println(currentTimeStamp);
        //long time=currentTimeStamp-ConstantUtils.time;
        PageHelper.startPage(pageNum, ConstantUtils.size);
        List<RouteInfo> allRoute = routeService.findAllNotStartTrain(currentTimeStamp);
        PageInfo<RouteInfo> routesPageInfo = new PageInfo<>(allRoute);
        int pages = routesPageInfo.getPages();//查询总数
        //设置一个页面最多允许5个分页
        //获取时间戳
        long canByTrainTime=ConstantUtils.canByTrainTime;
        model.addAttribute("canByTrainTime",canByTrainTime);
        model.addAttribute("currentTimeStamp",currentTimeStamp);
        PageNumsList pageNumsList = new PageNumsList();
        int[] pageNumArray = pageNumsList.getPageNumArray(pageNum, pages);
        model.addAttribute("routesPageInfo",routesPageInfo);
        model.addAttribute("pageNumArray",pageNumArray);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        //从订单表中查找座位详情

        return "buyTicketContre";
    }







}
