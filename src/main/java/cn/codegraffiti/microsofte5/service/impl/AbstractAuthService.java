package cn.codegraffiti.microsofte5.service.impl;

import cn.codegraffiti.microsofte5.entity.ThirdPartyToken;
import cn.codegraffiti.microsofte5.repository.ThirdPartyTokenRepository;
import cn.codegraffiti.microsofte5.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractAuthService implements AuthService {

    @Autowired
    private ThirdPartyTokenRepository tokenRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String getAccessToken(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public Long saveToken(ThirdPartyToken token) {
        token = this.tokenRepository.save(token);
        return token.getId();
    }


}
