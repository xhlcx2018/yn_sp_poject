package springmybatis.control;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springmybatis.basemd5.MD5Util;
import springmybatis.model.SystemUser;
import springmybatis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserService userService;


    @RequestMapping("/saverUser")
    public SystemUser saverUser(@NonNull @ModelAttribute SystemUser u) {
        u.setLoginPassword(MD5Util.MD5(u.getLoginPassword()));
        System.out.println(u.toString());
       if(userService.save(u)>0)
       {
           return u;
       }

        return  null;
    }

    @RequestMapping("/getusername")
    public String getusername(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session=request.getSession();
        return (String)session.getAttribute("username");
    }
}




