package cn.elitecode.model.dto.menu;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;

public class MenuAddDTO {

    @ApiModelProperty(value = "菜单标题", required = true)
    @NotEmpty(message = "菜单标题不能为空")
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

    public MenuAddDTO() {
    }

    public MenuAddDTO(String title, Long parentId, Integer sort, String component, Integer ifFrame, String type, String visible, String status) {
        this.title = title;
        this.parentId = parentId;
        this.sort = sort;
        this.component = component;
        this.ifFrame = ifFrame;
        this.type = type;
        this.visible = visible;
        this.status = status;
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

    public String toString() {
        return "MenuAddDTO{title = " + title + ", parentId = " + parentId + ", sort = " + sort + ", component = " + component + ", ifFrame = " + ifFrame + ", type = " + type + ", visible = " + visible + ", status = " + status + "}";
    }
}
