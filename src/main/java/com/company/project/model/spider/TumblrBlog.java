package com.company.project.model.spider;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_tumblr_blog")
public class TumblrBlog {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 类型
     */
    private String type;

    /**
     * 原始地址
     */
    private String url;

    /**
     * 关注统计
     */
    @Column(name = "note_count")
    private String noteCount;

    /**
     * 标题图
     */
    @Column(name = "head_image")
    private String headImage;

    /**
     * 标签
     */
    private String tags;

    /**
     * 发布时间
     */
    @Column(name = "post_time")
    private Date postTime;

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
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取原始地址
     *
     * @return url - 原始地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置原始地址
     *
     * @param url 原始地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取关注统计
     *
     * @return note_count - 关注统计
     */
    public String getNoteCount() {
        return noteCount;
    }

    /**
     * 设置关注统计
     *
     * @param noteCount 关注统计
     */
    public void setNoteCount(String noteCount) {
        this.noteCount = noteCount;
    }

    /**
     * 获取标题图
     *
     * @return head_image - 标题图
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * 设置标题图
     *
     * @param headImage 标题图
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    /**
     * 获取标签
     *
     * @return tags - 标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签
     *
     * @param tags 标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取发布时间
     *
     * @return post_time - 发布时间
     */
    public Date getPostTime() {
        return postTime;
    }

    /**
     * 设置发布时间
     *
     * @param postTime 发布时间
     */
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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