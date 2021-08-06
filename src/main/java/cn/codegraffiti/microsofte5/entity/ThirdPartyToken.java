package cn.codegraffiti.microsofte5.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "third_party_token")
public class ThirdPartyToken implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.codegraffiti.microsofte5.utils.id.SnowflakeId")
    private Long id;

    @Basic
    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Basic
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Basic
    @Column(name = "expires_in", nullable = false)
    private String expiresIn;

    @Basic
    @Column(name = "source", nullable = false)
    private String source;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;


    public ThirdPartyToken(String accessToken, String source) {
        this.accessToken = accessToken;
        this.source = source;
        this.createTime = new Date();
    }

    public ThirdPartyToken() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
