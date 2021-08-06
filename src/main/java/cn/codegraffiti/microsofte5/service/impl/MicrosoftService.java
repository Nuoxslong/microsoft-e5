package cn.codegraffiti.microsofte5.service.impl;

import cn.codegraffiti.microsofte5.service.AuthService;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("microsoft")
@RequiredArgsConstructor
public class MicrosoftService implements AuthService {

    private static final String CLIENT_ID = "654232c8-d7aa-446f-8a15-d65a2bec77b9";
    private static final String CLIENT_SECRETS = "sS845aeT-bg1kf_PS8CY99_KZSxit18C~1";


    private static final String REDIRECT_URI = "https://service.codegraffiti.cn/auth/microsoft";

    // 获取邮箱授权地址
    private static final String MICROSOFT_AUTH_URL = "https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=CLIENT_ID&redirect_uri=REDIRECT_URI&response_type=code&state=STATE&scope=openid offline_access Mail.Read";

    // 获取令牌地址
    private static final String MICROSOFT_ACCESS_URL = "https://login.microsoftonline.com/common/oauth2/v2.0/token";


    @Override
    public String auth() {
        String url = MICROSOFT_AUTH_URL.replace("CLIENT_ID", CLIENT_ID);
        url = url.replace("REDIRECT_URI", REDIRECT_URI);
        url = url.replace("STATE", "9001");
        return url;
    }

    @Override
    public String call(String code, String state) {
        return getAccessToken(code);
    }


    public String getAccessToken(String code) {
        HttpRequest httpRequest = HttpRequest.post(MICROSOFT_ACCESS_URL);
        httpRequest.header("accept", "application/x-www-form-urlencoded");
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", CLIENT_ID);
        params.put("client_secret", CLIENT_SECRETS);
        params.put("code", code);
        params.put("redirect_uri", REDIRECT_URI);
        params.put("grant_type", "authorization_code");
        httpRequest.form(params);
        HttpResponse httpResponse = httpRequest.execute();
        String body = httpResponse.body();
        log.info("body:{}", body);
        JSONObject jsonObject = JSONUtil.parseObj(body);
        return (String) jsonObject.get("access_token");
    }

    public String getMailList(String accessToken) throws Exception {
        HttpRequest httpRequest = HttpRequest.post("https://graph.microsoft.com/v1.0/me/messages?$select=sender,subject");
        httpRequest.contentType("application/json");
        httpRequest.auth(accessToken);
        HttpResponse httpResponse = httpRequest.execute();
        String body = httpResponse.body();
        log.info("body:{}", body);
        JSONObject jsonObject = JSONUtil.parseObj(body);
        return (String) jsonObject.get("access_token");
    }

    public String getMailContent(String mailId) {
        HttpRequest httpRequest = HttpRequest.get("https://graph.microsoft.com/v1.0/me/messages/" + mailId);
        return null;
    }
}
