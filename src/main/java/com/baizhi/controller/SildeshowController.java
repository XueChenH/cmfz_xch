package com.baizhi.controller;

import com.baizhi.entity.Sildeshow;
import com.baizhi.service.SildeshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sildeshow")
public class SildeshowController {
    @Autowired
    private SildeshowService sildeshowService;

    @RequestMapping("showAll")
    public @ResponseBody Map<String, Object> showAll(){
        Map<String, Object> result = new HashMap<String, Object>();
        List<Sildeshow> list = sildeshowService.showAll();
        Long totals = sildeshowService.findTotals();
        result.put("rows",list);
        result.put("total",totals);
        return result;
    }
    @ResponseBody
    @RequestMapping("add")
    public Map<String,Object> add(MultipartFile file, Sildeshow sildeshow, HttpSession session){
        HashMap<String,Object> result=new HashMap<>();
        try{
            String realPath = session.getServletContext().getRealPath("/SildeImg/");
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            //存图片路径
            sildeshow.setPath("/SildeImg/"+file.getOriginalFilename());

            sildeshowService.add(sildeshow);
        result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("removeAll")
    public Map<String,Object> insert(String []id){
        HashMap<String,Object> result=new HashMap<>();
        try{
            for (int i=0;i<id.length;i++){
                sildeshowService.remove(id[i]);
            }
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return  result;
    }
    @ResponseBody
    @RequestMapping("update")
    public Map<String,Object> update(Sildeshow sildeshow){
        HashMap<String ,Object> result=new HashMap<>();
        try {
            sildeshowService.update(sildeshow);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return  result;
    }
    @ResponseBody
    @RequestMapping("showOne")
    public Sildeshow showOne(String id){
        Sildeshow sildeshow = sildeshowService.showOne(id);
        return sildeshow;
    }
}
