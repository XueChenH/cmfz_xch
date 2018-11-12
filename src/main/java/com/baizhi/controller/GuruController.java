package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Guru")
public class GuruController {
    @Resource
    private GuruService guruService;

    @RequestMapping("showByPage")
    public @ResponseBody
    Map<String, Object> showByPage(Integer page, Integer rows) {
        Map<String, Object> result = new HashMap<>();
        List<Guru> list = guruService.ShowByPage(page, rows);
        Long totals = guruService.findTotals();
        result.put("rows", list);
        result.put("total", totals);
        return result;
    }

    @ResponseBody
    @RequestMapping("removeAll")
    public Map<String, Object> delete(String[] id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            for (int i = 0; i < id.length; i++) {
                guruService.remove(id[i]);
            }
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("add")
    public Map<String, Object> add(MultipartFile file, Guru guru, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            String realPath = session.getServletContext().getRealPath("/GuruImg/");
            file.transferTo(new File(realPath, file.getOriginalFilename()));
            //存图片路径
            guru.setHeadPic("/GuruImg/" + file.getOriginalFilename());

            guruService.add(guru);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("showOne")
    public Guru showOne(String id){

        Guru guru = guruService.showOne(id);

        return guru;
    }

    @ResponseBody
    @RequestMapping("update")
    public Map<String, Object> update(Guru gurn) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            guruService.update(gurn);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    @RequestMapping("showAll")
    public @ResponseBody
    List<Guru> showAll() {
        List<Guru> gurus = guruService.showAll();
        return gurus;
    }
}
