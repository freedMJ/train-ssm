package com.lmj.train.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmj.train.mapper.RouteMapper;
import com.lmj.train.model.Station;
import com.lmj.train.utils.PageNumsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StationController {
    @Autowired
    private RouteMapper routeMapper;

    //站点管理
    @GetMapping("manageStation")
    public String manageStation(Model model,@RequestParam(name = "pageNum",defaultValue = "1")int pageNum){
        //分页
        int pageSize=2;
        PageHelper.startPage(pageNum,pageSize);
        List<Station> stationList = routeMapper.findStatinByPageHepler();
        PageInfo<Station> stationPageInfo = new PageInfo<Station>(stationList);
        int pages = stationPageInfo.getPages();//查询总数
        //设置一个页面最多允许5个分页
        PageNumsList pageNumsList = new PageNumsList();
        int[] pageNumArray = pageNumsList.getPageNumArray(pageNum, pages);
        model.addAttribute("stationList",stationPageInfo);
        model.addAttribute("pageNumArray",pageNumArray);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        System.out.println(stationList);
        System.out.println(stationPageInfo);
        return "manageStation";
    }
    //新增站点
    @GetMapping("addStation")
    public String addStation(){
        return "addStation";
    }
    @PostMapping("addStation")
    public String addStation(Model model,String stationName){
        if(stationName==null){
            model.addAttribute("errMsg","站点名称不为空");
        }
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
    public String updateStation(Model model,int id){
        Station station = routeMapper.findStationNameById(id);
        model.addAttribute("station",station);
        return "updateStation";
    }

    @PostMapping("updateStation")
    public String updateStation(Model model,@RequestParam(name = "id",required = true)Integer id,@RequestParam(name="stationName",required = true)String stationName){
        System.out.println(stationName);
        System.out.println(id);
        if(stationName==null){
            model.addAttribute("errMsg","修改后的站点名称不为空");
        }else{
            Station isstation = routeMapper.findStationByName(stationName);
            if(isstation!=null){
                model.addAttribute("errMsg","站点已经存在，请重新输入");
            }else{
                //routeMapper.addStation(stationName);
                routeMapper.updateStation(stationName,id);
                Station updateStation = new Station(id,stationName);
                model.addAttribute("msg","修改站点名称成功");
                model.addAttribute("station",updateStation);
            }
        }
        return "updateStation";
    }
    //删除站点
    @GetMapping("deleteStation")
    public String deleteStation(int id){
        routeMapper.deleteStation(id);
        return "redirect:manageStation";
    }

}
