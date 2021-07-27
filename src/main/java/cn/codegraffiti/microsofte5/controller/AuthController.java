package cn.codegraffiti.microsofte5.controller;

import cn.codegraffiti.microsofte5.service.impl.GithubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    final GithubService githubService;

    @GetMapping(value = "/oath2/url")
    public String githubAuthUrl() {
        return "redirect:" + githubService.auth();
    }

}
