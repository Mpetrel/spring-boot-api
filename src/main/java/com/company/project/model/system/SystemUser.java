package com.company.project.model.system;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_system_user")
@Data
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 真实名称
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 登录名称
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 最后更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记
     */
    private Integer del;

}