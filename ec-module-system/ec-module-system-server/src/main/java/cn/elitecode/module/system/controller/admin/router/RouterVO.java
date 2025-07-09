package cn.elitecode.module.system.controller.admin.router;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterVO {

    @ApiModelProperty(value = "路由地址")
    private String path;
    @ApiModelProperty(value = "路由名称")
    private String name;
    @ApiModelProperty(value = "重定向地址")
    private String redirect;
    @ApiModelProperty(value = "组件地址")
    private String component;
    @ApiModelProperty(value = "其它元素")
    private MetaVO meta;
    @ApiModelProperty(value = "子路由")
    private List<RouterVO> children;

    public RouterVO() {
    }

    public RouterVO(String path, String name, String redirect, String component, MetaVO meta, List<RouterVO> children) {
        this.path = path;
        this.name = name;
        this.redirect = redirect;
        this.component = component;
        this.meta = meta;
        this.children = children;
    }

    /**
     * 获取
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return redirect
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置
     * @param redirect
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
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
     * @return meta
     */
    public MetaVO getMeta() {
        return meta;
    }

    /**
     * 设置
     * @param meta
     */
    public void setMeta(MetaVO meta) {
        this.meta = meta;
    }

    /**
     * 获取
     * @return children
     */
    public List<RouterVO> getChildren() {
        return children;
    }

    /**
     * 设置
     * @param children
     */
    public void setChildren(List<RouterVO> children) {
        this.children = children;
    }

    public String toString() {
        return "RouterVO{path = " + path + ", name = " + name + ", redirect = " + redirect + ", component = " + component + ", meta = " + meta + ", children = " + children + "}";
    }
}
