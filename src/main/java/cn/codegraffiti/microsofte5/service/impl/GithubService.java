package cn.codegraffiti.microsofte5.service.impl;

import cn.codegraffiti.microsofte5.service.AuthService;
import cn.codegraffiti.microsofte5.entity.GithubUser;
import cn.codegraffiti.microsofte5.repository.GithubUserRepository;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("github")
@RequiredArgsConstructor
public class GithubService implements AuthService {

    private static final String CLIENT_ID = "839b8af05a1d42c00372";
    private static final String CLIENT_SECRETS = "c0b1a214a618420b6457244e0df9536d295655cd";


    private static final String REDIRECT_URI = "https://service.codegraffiti.cn/auth/github";

    // 授权地址
    private static final String GITHUB_AUTH_URL = "https://github.com/login/oauth/authorize?client_id=CLIENT_ID&redirect_uri=REDIRECT_URI&state=STATE";

    // 获取令牌地址
    private static final String GITHUB_ACCESS_URL = "https://github.com/login/oauth/access_token?client_id=CLIENT_ID&client_secret=CLIENT_SECRET&code=CODE";

    // 获取用户信息
    private static final String USER_INFO_URL = "https://api.github.com/user";

    final GithubUserRepository repository;


    @Override
    public String auth() {
        String url = GITHUB_AUTH_URL.replace("CLIENT_ID", CLIENT_ID);
        url = url.replace("REDIRECT_URI", REDIRECT_URI);
        url = url.replace("STATE", "9001");
        return url;
    }

    @Override
    public String call(String code, String state) {
        String accessToken = getAccessToken(code);
        GithubUser userInfo = getUserInfo(accessToken);
        return userInfo.getName();
    }

    public String getAccessToken(String code) {
        String url = GITHUB_ACCESS_URL.replace("CLIENT_ID", CLIENT_ID);
        url = url.replace("CLIENT_SECRET", CLIENT_SECRETS);
        url = url.replace("CODE", code);
        HttpRequest httpRequest = HttpRequest.get(url);
        httpRequest.header("accept", "application/json");
        HttpResponse httpResponse = httpRequest.execute();
        String body = httpResponse.body();
        log.info("body:{}", body);
        JSONObject jsonObject = JSONUtil.parseObj(body);
        return (String) jsonObject.get("access_token");
    }

    public GithubUser getUserInfo(String accessToken) {
        HttpRequest httpRequest = HttpRequest.get(USER_INFO_URL);
        httpRequest.auth("token " + accessToken);
        httpRequest.contentType("application/vnd.github.machine-man-preview+json");
        HttpResponse httpResponse = httpRequest.execute();
        String body = httpResponse.body();
        log.info("body:{}", body);

        JSONObject jsonObject = JSONUtil.parseObj(body);
        GithubUser user = new GithubUser();
        user.setLogin(jsonObject.get("login").toString());
        user.setName(jsonObject.get("name").toString());
        user.setAvatarUrl(jsonObject.get("avatar_url").toString());
        user.setGithubId(jsonObject.get("id").toString());
        user.setNodeId(jsonObject.get("node_id").toString());
        this.repository.save(user);
        return user;
    }

}
