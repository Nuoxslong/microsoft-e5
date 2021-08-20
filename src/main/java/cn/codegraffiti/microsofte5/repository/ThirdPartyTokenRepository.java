package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.ThirdPartyToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyTokenRepository extends JpaRepository<ThirdPartyToken, Long> {
}
