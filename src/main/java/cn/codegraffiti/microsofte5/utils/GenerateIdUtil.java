package cn.codegraffiti.microsofte5.utils;

import cn.codegraffiti.microsofte5.utils.id.IdWorker;
import org.springframework.beans.factory.annotation.Value;

public class GenerateIdUtil {

    @Value("${machine.workerId:1}")
    private static long workerId;

    @Value("${machine.dataCenterId:1}")
    private static long dataCenterId;

    public static long nextId() {
        IdWorker idWorker = new IdWorker(workerId, dataCenterId);
        return idWorker.nextId();
    }

}
