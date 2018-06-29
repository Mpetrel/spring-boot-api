package com.company.project.model.system;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_system_permit")
public class SystemPermit {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型(1. 菜单 2.按钮)
     */
    private Integer type;

    /**
     * 地址
     */
    private String url;

    /**
     * 权限字符
     */
    private String permit;

    /**
     * 父级id
     */
    private Long parent;

    /**
     * 图标
     */
    private String icon;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 创建者id
     */
    @Column(name = "create_id")
    private Long createId;

    /**
     * 更新者id
     */
    @Column(name = "update_id")
    private Long updateId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型(1. 菜单 2.按钮)
     *
     * @return type - 类型(1. 菜单 2.按钮)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型(1. 菜单 2.按钮)
     *
     * @param type 类型(1. 菜单 2.按钮)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取地址
     *
     * @return url - 地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置地址
     *
     * @param url 地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限字符
     *
     * @return permit - 权限字符
     */
    public String getPermit() {
        return permit;
    }

    /**
     * 设置权限字符
     *
     * @param permit 权限字符
     */
    public void setPermit(String permit) {
        this.permit = permit;
    }

    /**
     * 获取父级id
     *
     * @return parent - 父级id
     */
    public Long getParent() {
        return parent;
    }

    /**
     * 设置父级id
     *
     * @param parent 父级id
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建者id
     *
     * @return create_id - 创建者id
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置创建者id
     *
     * @param createId 创建者id
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取更新者id
     *
     * @return update_id - 更新者id
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置更新者id
     *
     * @param updateId 更新者id
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标记
     *
     * @return delete_flag - 删除标记
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记
     *
     * @param deleteFlag 删除标记
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}