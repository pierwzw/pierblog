package com.pier.controller;

import com.pier.entity.User;
import com.pier.service.UserService;
import com.pier.util.Result;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.pier.util.MyUtils.getIpAddr;

/**
 * @author pierwzw
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(HttpServletRequest request) {

        Result result = new Result();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try{
            User user = new User();
            user.setUserName(username);
            user.setUserPass(password);
            user.setUserRegisterTime(new Date());
            user.setUserStatus(1);
            user.setUserNickname("");
            userService.insertUser(user);
        }catch (Exception e){
            result.setCode("1");
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 检查用户名是否存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    @ResponseBody
    public Result checkUserName(HttpServletRequest request)  {
        Result result = new Result();
        String username = request.getParameter("username");
        User user = userService.getUserByName(username);
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if(user!=null) {
            result.put("code", 1);
            result.put("msg", "用户名已存在！");
        }
        return result;
    }
}
