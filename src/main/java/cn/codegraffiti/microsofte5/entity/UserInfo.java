package cn.codegraffiti.microsofte5.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "cn.codegraffiti.microsofte5.utils.id.SnowflakeId")
    private Long id;

    @Basic
    @Column(name = "account", nullable = false)
    private String account;
    @Basic
    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;
    @Basic
    @Column(name = "nick_name", nullable = false)
    private String nickName;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "state", nullable = false)
    private Integer state;
    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
