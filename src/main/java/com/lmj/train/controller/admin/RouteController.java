package com.lmj.train.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmj.train.model.Price;
import com.lmj.train.model.Route;
import com.lmj.train.model.pojo.RouteInfo;
import com.lmj.train.model.Station;
import com.lmj.train.service.IRouteService;
import com.lmj.train.service.IStationService;
import com.lmj.train.utils.ConstantUtils;
import com.lmj.train.utils.PageNumsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RouteController {
    /**
     *
     * 路线管理控制器
     * **/
    @Autowired
    private IStationService stationService;
    @Autowired
    private IRouteService routeService;
    //管理路线
    @GetMapping("manageRoute")
    public String manageRoute(Model model,@RequestParam(name="pageNum",defaultValue = "1")int pageNum){
        //分页
        PageHelper.startPage(pageNum, ConstantUtils.size);
        List<Route> allRoute = routeService.findAllRoute();
        PageInfo<Route> routesPageInfo = new PageInfo<Route>(allRoute);
        int pages = routesPageInfo.getPages();//查询总数
        //设置一个页面最多允许5个分页
        //获取时间戳
        long currentTimeStamp = new Date().getTime();
        model.addAttribute("currentTimeStamp",currentTimeStamp);
        PageNumsList pageNumsList = new PageNumsList();
        int[] pageNumArray = pageNumsList.getPageNumArray(pageNum, pages);
        model.addAttribute("routesPageInfo",routesPageInfo);
        model.addAttribute("pageNumArray",pageNumArray);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        return "manageRoute";
    }
    //新增路线
    @GetMapping("saveRoute")
    public String saveRoute(Model model){
        //查找所有的站点信息
        List<Station> stationList = stationService.findAllStation();

        model.addAttribute("stationList",stationList);
        return "saveRoute";
    }
    @PostMapping("saveRoute")
    @ResponseBody
    public Map<String,String> saveRoute(Model model,@RequestBody RouteInfo routeInfo){
        String trainName = routeInfo.getTrainName();//车次名
        String startPoint = routeInfo.getStartPoint();//起始站
        String endPoint = routeInfo.getEndPoint();//终点站
        Long startTime = routeInfo.getStartTime();//发车时间
        Long endTime = routeInfo.getEndTime();//抵达时间
        int trainType = routeInfo.getTrainType();//列车类型
        int sleepBerthNums = routeInfo.getSleepBerthNums();//卧铺数
        int seatNums = routeInfo.getSeatNums();//硬座数
        int standNums = routeInfo.getStandNums();//站票数
        float sleepBerthPrice = routeInfo.getSleepBerthPrice();//卧铺价格
        float seatPrice = routeInfo.getSeatPrice();//硬座价格
        float standPrice = routeInfo.getStandPrice();//站票价格
        List<Station> stationList = stationService.findAllStation();
        Map<String,String> map = new HashMap<>();
        model.addAttribute("stationList",stationList);
        String msg=null;
        String errMsg=null;
        if(" ".equals(trainName)){
                errMsg = "请输入车次名";
        }else if("--请选择起始站--".equals(startPoint)){
            errMsg = "请输入起始站";
        }else if("--请选择终点站--".equals(endPoint)){
            errMsg = "请输入终点站";
        }else if(startTime==null){
            errMsg = "请输入发车时间";
        }else if(endTime==null){
            errMsg = "请输入抵达时间";
        }else if(trainType!=0&&trainType!=1){
            errMsg = "请选择火车类型";
        }
            Route route = new Route(trainName,startPoint,endPoint,startTime,endTime,trainType,sleepBerthNums,seatNums,standNums);
            routeService.saveRoute(route);
            int rid = routeService.findRoutebyId(trainName);
            Price price = new Price(sleepBerthPrice,seatPrice,standPrice,rid);
            routeService.savePrice(price);
            msg = "保存路线成功";
            map.put("errMsg",errMsg);
            map.put("msg",msg);
        return map;
    }

    //删除路线
    @GetMapping("deleteRoute")
    public String deleteRoute(int id){
        routeService.deleteRouteById(id);
        routeService.deletePriceByRid(id);
        return "redirect:manageRoute";
    }
    //修改路线
    @GetMapping("updateRoute")
    public String updateRoute(Model model,int id) throws Exception{
        Route routeById = routeService.findRouteById(id);
        Price priceById = routeService.findPriceById(id);
        List<Station> stationList = stationService.findAllStation();
        model.addAttribute("stationList",stationList);
        model.addAttribute("routeById",routeById);
        model.addAttribute("priceById",priceById);
        return "updateRoute";
    }
    @PostMapping("updateRoute")
    @ResponseBody
    public Map<String,String> updateRoute(@RequestBody RouteInfo routeInfo){
        String trainName = routeInfo.getTrainName();
        int id = routeService.findIdByTrainName(trainName);
        routeInfo.setId(id);
        routeService.updateRouteInfo(routeInfo);
        Map<String,String> map = new HashMap<String,String>();
        String msg = "更新路线成功";
        map.put("msg",msg);
        return map;
    }
}
