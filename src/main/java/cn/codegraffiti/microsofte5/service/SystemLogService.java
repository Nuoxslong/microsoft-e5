package cn.codegraffiti.microsofte5.service;

import cn.codegraffiti.microsofte5.entity.SystemLog;
import cn.codegraffiti.microsofte5.repository.SystemLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemLogService {

    final SystemLogRepository repository;

    public void record(String content) {
        SystemLog log = new SystemLog();
        log.setContent(content);
        log.setCreateTime(new Date());
        log.setSource("un");
        this.repository.save(log);
    }

}
