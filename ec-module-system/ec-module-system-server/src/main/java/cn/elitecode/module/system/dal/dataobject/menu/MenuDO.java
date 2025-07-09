package cn.elitecode.module.system.dal.dataobject.menu;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;

/**
* menu(菜单权限表) | 实体类
*/
public class MenuDO {

    @ApiModelProperty("菜单id，主键")
    private Long id;

    @ApiModelProperty("菜单标题")
    private String title;

    @ApiModelProperty("父菜单ID")
    private Long parentId;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("是否为外链 (0是 1否)")
    private Integer ifFrame;

    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String type;

    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty("菜单状态 (0正常 1停用)")
    private String status;

    @ApiModelProperty("创建者")
    private Long createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Long updateBy;

    @ApiModelProperty("编辑时间")
    private Date updateTime;

    @ApiModelProperty("子菜单")
    private List<MenuDO> children;

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置
     * @param component
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取
     * @return ifFrame
     */
    public Integer getIfFrame() {
        return ifFrame;
    }

    /**
     * 设置
     * @param ifFrame
     */
    public void setIfFrame(Integer ifFrame) {
        this.ifFrame = ifFrame;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return visible
     */
    public String getVisible() {
        return visible;
    }

    /**
     * 设置
     * @param visible
     */
    public void setVisible(String visible) {
        this.visible = visible;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return children
     */
    public List<MenuDO> getChildren() {
        return children;
    }

    /**
     * 设置
     * @param children
     */
    public void setChildren(List<MenuDO> children) {
        this.children = children;
    }

    public String toString() {
        return "MenuDO{id = " + id + ", title = " + title + ", parentId = " + parentId + ", sort = " + sort + ", component = " + component + ", ifFrame = " + ifFrame + ", type = " + type + ", visible = " + visible + ", status = " + status + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", children = " + children + "}";
    }
}
