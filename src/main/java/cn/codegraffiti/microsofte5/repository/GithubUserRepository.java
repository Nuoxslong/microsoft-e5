package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.GithubUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubUserRepository extends JpaRepository<GithubUser, Long> {
}
