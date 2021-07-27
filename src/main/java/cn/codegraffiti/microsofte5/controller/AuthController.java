package cn.codegraffiti.microsofte5.controller;

import cn.codegraffiti.microsofte5.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    final Map<String, AuthService> authService;

    @GetMapping(value = "/oath2/{source}/url")
    public String githubAuthUrl(@PathVariable(value = "source") String source) {
        return "redirect:" + authService.get(source).auth();
    }

}
