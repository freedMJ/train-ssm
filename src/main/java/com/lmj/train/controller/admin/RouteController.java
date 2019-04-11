package com.lmj.train.controller.admin;

import com.lmj.train.mapper.RouteMapper;
import com.lmj.train.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouteController {
    @Autowired
    private RouteMapper routeMapper;

    //站点管理
    @GetMapping("manageStation")
    public String manageStation(){
        //分页
        return "manageStation";
    }
    //新增站点
    @GetMapping("addStation")
    public String addStation(){
        return "addStation";
    }
    @PostMapping("addStation")
    public String addStation(Model model,String stationName){
        Station station = routeMapper.findStationByName(stationName);
        if(station!=null){
            model.addAttribute("errMsg","站点已经存在，请重新输入");
        }else{
            routeMapper.addStation(stationName);
            model.addAttribute("msg","新增站点成功");
        }

        return "addStation";
    }
    //修改站点
    @GetMapping("updateStation")
    public String updateStation(){
        return "addStation";
    }

    @PostMapping("updateStation")
    public void updateStation(String stationName){
        routeMapper.updateStation(stationName);
    }
    //删除站点
    @GetMapping("deleteStation")
    public String deleteStation(){
        return "manageStation";
    }

}
