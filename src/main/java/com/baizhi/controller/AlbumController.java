package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Sildeshow;
import com.baizhi.service.AlbumService;
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

@RequestMapping("Album")
@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("showByPage")
    public @ResponseBody Map<String, Object> showByPage(Integer page,Integer rows){
        HashMap<String,Object> result=new HashMap<>();
        List<Album> list = albumService.ShowByPage(page,rows);
        Long totals = albumService.findTotals();
        result.put("rows",list);
        result.put("total",totals);
        return result;
    }
    @ResponseBody
    @RequestMapping("add")
    public Map<String,Object> add(MultipartFile file, Album album, HttpSession session){
        HashMap<String,Object> result=new HashMap<>();
        try{
            String realPath = session.getServletContext().getRealPath("/AlbumImg/");
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            //存图片路径
            album.setAlbumpath("/AlbumImg/"+file.getOriginalFilename());

            albumService.add(album);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }
}
