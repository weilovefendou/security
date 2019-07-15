package cn.edoclub.house.controller;

import cn.edoclub.house.entity.House;
import cn.edoclub.house.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/hello")
public class Hello {
    @Autowired
    private IHouseService iHouseService;

    @GetMapping("one")
    public String hello(ModelMap modelMap){
        List<House> list =iHouseService.list();
        House house =list.get(0);
        modelMap.put("user",house);
        return "hello";
    }
}
