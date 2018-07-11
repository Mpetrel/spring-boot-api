package com.company.project.model.spider;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_tumblr_user")
public class TumblrUser {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 中文名
     */
    private String cname;

    /**
     * 时区
     */
    private String timezone;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客地址
     */
    private String url;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取中文名
     *
     * @return cname - 中文名
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置中文名
     *
     * @param cname 中文名
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取时区
     *
     * @return timezone - 时区
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 设置时区
     *
     * @param timezone 时区
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * 获取博客标题
     *
     * @return title - 博客标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置博客标题
     *
     * @param title 博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取博客地址
     *
     * @return url - 博客地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置博客地址
     *
     * @param url 博客地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}