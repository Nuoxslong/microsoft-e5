package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.ThirdPartyToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyTokenRepository extends JpaRepository<ThirdPartyToken, Long> {
}
