package com.github.gazizovrim.controller;

import com.github.gazizovrim.dto.UserRegistrationDTO;
import com.github.gazizovrim.model.User;
import com.github.gazizovrim.service.UserService;
import com.github.gazizovrim.util.SecurityContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by vladislav on 10.05.2015.
 */
@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @RequestMapping(method = RequestMethod.GET, value = {"/reg","/register","/registration"})
    public String renderRegisterPage(Model model) {
        model.addAttribute("page", "auth");
        return "index";
    }
    @RequestMapping("/test")
    public void testAuth() {
        SecurityContextUtil.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registerUser(@Valid UserRegistrationDTO userRegistrationDTO,
                               BindingResult bindingResult,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               Model model) {
        isExist(userRegistrationDTO, bindingResult);
        isPasswordEquals(userRegistrationDTO, bindingResult);
        userRegistrationDTO.setPassword(passwordEncode(userRegistrationDTO.getPassword()));
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "error/reg";//???? ???? ??????- ???????? ???. ?????? TODO ?????????? ????????? ?? ???????
        } else {
            response.setStatus(HttpServletResponse.SC_CREATED);
            User newUser = userService.saveUser(userRegistrationDTO);
            model.addAttribute("page", "auth");
            return "index"; //????? ???? ?? ???????? ??????
        }
    }

    private void isExist(UserRegistrationDTO userDto, Errors errors) {
        if (userService.findUserByName(userDto.getUserName()) != null)
            errors.rejectValue("username", "username", "this username already in user");
    }

    private void isPasswordEquals(UserRegistrationDTO userDto, BindingResult result) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
            result.rejectValue("confirmPassword", "password", "password doesn't match");
    }

    private String passwordEncode(String password) {
        return shaPasswordEncoder.encodePassword(password, ""); //no salt
    }
}
