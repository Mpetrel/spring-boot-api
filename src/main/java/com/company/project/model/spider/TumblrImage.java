package com.company.project.model.spider;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_tumblr_image")
public class TumblrImage {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 原始图片地址
     */
    @Column(name = "raw_url")
    private String rawUrl;

    /**
     * offset
     */
    private String offset;

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
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取图片地址
     *
     * @return url - 图片地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片地址
     *
     * @param url 图片地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取原始图片地址
     *
     * @return raw_url - 原始图片地址
     */
    public String getRawUrl() {
        return rawUrl;
    }

    /**
     * 设置原始图片地址
     *
     * @param rawUrl 原始图片地址
     */
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    /**
     * 获取offset
     *
     * @return offset - offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * 设置offset
     *
     * @param offset offset
     */
    public void setOffset(String offset) {
        this.offset = offset;
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