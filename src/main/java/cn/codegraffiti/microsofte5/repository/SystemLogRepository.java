package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
}
