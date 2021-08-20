package cn.codegraffiti.microsofte5.controller;

import cn.codegraffiti.microsofte5.utils.SendMessageMq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    final SendMessageMq sendMessageMq;

    private static int count = 1;

    @GetMapping(value = "/test")
    public ResponseEntity<Integer> test() {
        count += 1;
        return ResponseEntity.ok(count);
    }

    @GetMapping(value = "sendMq")
    public ResponseEntity<Void> sendMq() {
        this.sendMessageMq.sendRandomQueue();
        return ResponseEntity.ok().build();
    }
}