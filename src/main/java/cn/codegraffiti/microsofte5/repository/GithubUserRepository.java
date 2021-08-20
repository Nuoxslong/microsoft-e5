package cn.codegraffiti.microsofte5.repository;

import cn.codegraffiti.microsofte5.entity.GithubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubUserRepository extends JpaRepository<GithubUser, Long> {

    GithubUser findByGithubId(String githubId);

}
