package cn.codegraffiti.microsofte5.service;

public interface AuthService {

    String auth();

    String call(String code, String state);
}
