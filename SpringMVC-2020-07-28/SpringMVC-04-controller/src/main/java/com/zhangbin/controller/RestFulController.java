package com.zhangbin.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/8/1-14:57
 */
@Controller
public class RestFulController {

//    http://localhost:8080/add?a=1&b=2 原来的风格
//    http://localhost:8080/add/a/b     restFul风格:添加注解@RathVariable,修改@ResquestMapping里的路径

//    效果相等
    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.DELETE)
//    @DeleteMapping("/add/{a}/{b}")

    //    效果相等
    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String test01(@PathVariable int a,@PathVariable int b, Model model){
        int src = a + b;
        model.addAttribute("msg","结果为=" + src);
        return "hello";
    }

    //    效果相等
    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    @DeleteMapping("/add/{a}/{b}")
    public String test02(@PathVariable int a,@PathVariable int b, Model model){
        int src = a + b;
        model.addAttribute("msg","结果为=" + src);
        return "hello";
    }
}
