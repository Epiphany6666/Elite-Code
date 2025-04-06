package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
* menu(菜单权限表) | 实体类
*/
public class Menu {

    @ApiModelProperty("菜单id，主键")
    private Long id;

    @ApiModelProperty("菜单标题")
    private Integer title;
    /**
    * 父菜单ID
    */
    @ApiModelProperty("父菜单ID")
    private Long parentId;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("是否为外链 (0是 1否)")
    private Integer ifFrame;

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

    public Menu() {
    }

    public Menu(Long id, Integer title, Long parentId, Integer sort, String component, Integer ifFrame, String status, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.sort = sort;
        this.component = component;
        this.ifFrame = ifFrame;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    /**
    * 菜单id，主键
    */
    public void setId(Long id){
    this.id = id;
    }

    /**
    * 菜单标题
    */
    public void setTitle(Integer title){
    this.title = title;
    }

    /**
    * 父菜单ID
    */
    public void setParentId(Long parentId){
    this.parentId = parentId;
    }

    /**
    * 显示顺序
    */
    public void setSort(Integer sort){
    this.sort = sort;
    }

    /**
    * 组件路径
    */
    public void setComponent(String component){
    this.component = component;
    }

    /**
    * 是否为外链 (0是 1否)
    */
    public void setIfFrame(Integer ifFrame){
    this.ifFrame = ifFrame;
    }

    /**
    * 菜单状态 (0正常 1停用)
    */
    public void setStatus(String status){
    this.status = status;
    }

    /**
    * 创建者
    */
    public void setCreateBy(Long createBy){
    this.createBy = createBy;
    }

    /**
    * 创建时间
    */
    public void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 更新者
    */
    public void setUpdateBy(Long updateBy){
    this.updateBy = updateBy;
    }

    /**
    * 编辑时间
    */
    public void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }

    /**
    * 菜单id，主键
    */
    public Long getId(){
    return this.id;
    }

    /**
    * 菜单标题
    */
    public Integer getTitle(){
    return this.title;
    }

    /**
    * 父菜单ID
    */
    public Long getParentId(){
    return this.parentId;
    }

    /**
    * 显示顺序
    */
    public Integer getSort(){
    return this.sort;
    }

    /**
    * 组件路径
    */
    public String getComponent(){
    return this.component;
    }

    /**
    * 是否为外链 (0是 1否)
    */
    public Integer getIfFrame(){
    return this.ifFrame;
    }

    /**
    * 菜单状态 (0正常 1停用)
    */
    public String getStatus(){
    return this.status;
    }

    /**
    * 创建者
    */
    public Long getCreateBy(){
    return this.createBy;
    }

    /**
    * 创建时间
    */
    public Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 更新者
    */
    public Long getUpdateBy(){
    return this.updateBy;
    }

    /**
    * 编辑时间
    */
    public Date getUpdateTime(){
    return this.updateTime;
    }

    public String toString() {
        return "Menu{id = " + id + ", title = " + title + ", parentId = " + parentId + ", sort = " + sort + ", component = " + component + ", ifFrame = " + ifFrame + ", status = " + status + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }

}
