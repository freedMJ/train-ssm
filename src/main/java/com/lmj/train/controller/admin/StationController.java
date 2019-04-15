package com.lmj.train.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmj.train.mapper.StationMapper;
import com.lmj.train.model.Station;
import com.lmj.train.service.IStationService;
import com.lmj.train.utils.Constant;
import com.lmj.train.utils.PageNumsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StationController {

    /**
     *
     * 站点管理控制器
     * **/
    @Autowired
    private IStationService stationService;

    //站点管理
    @GetMapping("manageStation")
    public String manageStation(Model model,@RequestParam(name = "pageNum",defaultValue = "1")int pageNum){
        //分页
        int pageSize= Constant.size;
        PageHelper.startPage(pageNum,pageSize);
        List<Station> stationList = stationService.findStatinByPageHepler();
        PageInfo<Station> stationPageInfo = new PageInfo<Station>(stationList);
        int pages = stationPageInfo.getPages();//查询总数
        //设置一个页面最多允许5个分页
        PageNumsList pageNumsList = new PageNumsList();
        int[] pageNumArray = pageNumsList.getPageNumArray(pageNum, pages);
        model.addAttribute("stationList",stationPageInfo);
        model.addAttribute("pageNumArray",pageNumArray);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
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
        Station station = stationService.findStationByName(stationName);
        if(station!=null){
            model.addAttribute("errMsg","站点已经存在，请重新输入");
        }else{
            stationService.addStation(stationName);
            model.addAttribute("msg","新增站点成功");
        }

        return "addStation";
    }
    //修改站点
    @GetMapping("updateStation")
    public String updateStation(Model model,int id){
        Station station = stationService.findStationNameById(id);
        model.addAttribute("station",station);
        return "updateStation";
    }

    @PostMapping("updateStation")
    public String updateStation(Model model,@RequestParam(name = "id",required = true)Integer id,@RequestParam(name="stationName",required = true)String stationName){
        if(stationName==null){
            model.addAttribute("errMsg","修改后的站点名称不为空");
        }else{
            Station isstation = stationService.findStationByName(stationName);
            if(isstation!=null){
                model.addAttribute("errMsg","站点已经存在，请重新输入");
            }else{
                stationService.updateStation(stationName,id);
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
        stationService.deleteStation(id);
        return "redirect:manageStation";
    }
}
