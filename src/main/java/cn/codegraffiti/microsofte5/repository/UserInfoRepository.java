package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;
import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /**
     * 手机号或账户是否已存在
     */
    @Query(value = "SELECT u.id FROM UserInfo u WHERE u.account = :account")
    List<UserInfo> isAccountExists(@Param("account") String account);

    @Query(value = "SELECT u.id FROM UserInfo u WHERE u.mobilePhone = :mobilePhone")
    List<UserInfo> isMobilePhoneExists(@Param("mobilePhone") String mobilePhone);

    @Query(value = "SELECT u FROM UserInfo u WHERE u.mobilePhone = :identifier OR u.account = :identifier")
    UserInfo findByIdentifier(@Param("identifier") String identifier);
}
