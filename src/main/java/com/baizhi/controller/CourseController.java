package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("course")
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("showByPage")
    public @ResponseBody Map<String,Object> showByPage(Integer page,Integer rows){
        HashMap<String ,Object> result=new HashMap<>();
        List<Course> courses = courseService.showByPage(page, rows);
        long totals = courseService.findTotals();
        result.put("rows",courses);
        result.put("total",totals);
        return result;
    }



    @ResponseBody
    @RequestMapping("removeAll")
    public Map<String, Object> delete(String[] id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            for (int i = 0; i < id.length; i++) {
                courseService.remove(id[i]);
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
    public Map<String, Object> add(Course course) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            courseService.add(course);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("update")
    public Map<String,Object> update(Course course){
        HashMap<String ,Object> result=new HashMap<>();
        try {
            courseService.update(course);
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
    public Course showOne(String id){
        Course course = courseService.showOne(id);
        return course;
    }
}
