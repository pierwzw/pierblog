package com.pier.controller;

import com.pier.entity.User;
import com.pier.service.UserService;
import com.pier.util.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import static com.pier.util.MyUtils.getIpAddr;

/**
 * @author pierwzw
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "redirect:/";
    }


    /**
     * 登录验证
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
    @ResponseBody
    public Result loginVerify(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        Result result = new Result();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByNameOrEmail(username);
        if(user==null) {
            session.removeAttribute("piccode");
            result.put("code","1");
            result.put("msg","用户名无效！");
            return result;
        }
        if(!user.getUserPass().equals(password)) {
            session.removeAttribute("piccode");
            result.put("code","2");
            result.put("msg","密码错误！");
            return result;
        }

        String piccode = (String) session.getAttribute("piccode");
        if (StringUtils.isBlank(verifycode) || !piccode.equalsIgnoreCase(verifycode)) {
            session.removeAttribute("piccode");
            result.put("code","3");
            result.put("msg","验证码错误！");
            return result;
        }
        //登录成功
        //添加session
        session.setAttribute("user", user);
        //添加cookie
        if(rememberme!=null) {
            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", username);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60 * 60 * 24 * 3);
            Cookie pwdCookie = new Cookie("password", password);
            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);
        }
        user.setUserLastLoginTime(new Date());
        user.setUserLastLoginIp(getIpAddr(request));
        userService.updateUser(user);
        return result;
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(@RequestParam String path, HttpSession session)  {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:" + path;
    }

    /**
     * 获取session
     */
    @RequestMapping("/getSession")
    @ResponseBody
    public Map getSession(HttpSession session){
        Result result = new Result();
        String username = (String)session.getAttribute("username");
        if (username == null){
            result.setError("1", "username is null");
            return result;
        }
        result.put("username", username);
        return result;
    }
}
