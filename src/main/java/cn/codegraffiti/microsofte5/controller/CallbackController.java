package cn.codegraffiti.microsofte5.controller;

import cn.codegraffiti.microsofte5.service.impl.GithubService;
import cn.codegraffiti.microsofte5.service.impl.SystemLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CallbackController {

    final GithubService githubService;

    final SystemLogService systemLogService;

    @GetMapping(value = "/call")
    public ResponseEntity<Void> call(String code) {
        try {
            this.systemLogService.record(code);
        } catch (Exception e) {
            log.error("记录错误！");
            log.error("error msg --> ", e);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/auth/{source}")
    public ResponseEntity<Void> auth(@PathVariable(value = "source") String source, @RequestParam String code, @RequestParam(required = false) String state) {
        log.info("auth call source: {}", source);
        log.info("auth call code: {}", code);
        log.info("auth call state: {}", state);
        this.githubService.call(code, state);
        return ResponseEntity.ok().build();
    }
}
