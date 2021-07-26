package cn.codegraffiti.microsofte5.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

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


}
