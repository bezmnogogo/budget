package com.budget.web.controller;

import com.budget.dao.entities.User;
import com.budget.services.IRecordService;
import com.budget.services.IUserDetailsService;
import com.budget.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by home on 14.12.16.
 */
@Controller
@RequestMapping(value = "/private-room")
public class PrivateRoomController {
    private final IUserService userService;
    private final IRecordService recordService;
    private final IUserDetailsService userDetailsService;

    @Autowired
    public PrivateRoomController(IUserService userService, IRecordService recordService, IUserDetailsService iUserDetailsService) {
        this.userService = userService;
        this.recordService = recordService;
        this.userDetailsService = iUserDetailsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/*")
    public String getPrivateRoom(@AuthenticationPrincipal User user, HttpServletRequest request, ModelMap modelMap){
        if(user == null){
            modelMap.addAttribute("message", "Авторизируйтесь!");
            return "login";
        }

        modelMap.addAttribute("user", user);
        return "Person_page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changeUser")
    public String changeUser(@AuthenticationPrincipal User user, HttpServletRequest request, ModelMap modelMap){
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/action/{action}")
    public String changeUserData(@AuthenticationPrincipal User user, HttpServletRequest request, ModelMap modelMap, @PathVariable("action") String action){
        switch (action){
            case "changeUsername":
                //user = userService.changeUsername(user.getId(),request.getParameter("p_name"));
                //userDetailsService.changeUsername(user, request.getParameter("p_name"));
                user.setUsername(request.getParameter("p_name"));
                break;
            case "changeLimit":
                //user = userService.changeUserLimit(user.getId(), new Float(request.getParameter("p_limit")));
                user.setMounthlyLimit(new Float(request.getParameter("p_limit")));
                break;
            case "changeMail":
                //user = userService.changeUserMail(user.getId(), request.getParameter("p_email"));
                user.setMail(request.getParameter("p_email"));
                break;
        }

        user = userService.saveCurrentUserWithDetailsUpdate(user);
        modelMap.addAttribute("user", user);
        return "Person_page";
    }

}
