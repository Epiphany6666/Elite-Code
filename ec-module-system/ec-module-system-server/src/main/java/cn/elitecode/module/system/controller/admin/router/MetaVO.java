package cn.elitecode.module.system.controller.admin.router;

import io.swagger.annotations.ApiModelProperty;

public class MetaVO {

    @ApiModelProperty(value = "设置该路由在侧边栏的名字")
    private String title;
    @ApiModelProperty(value = "设置该路由的图标，对应路径src/assets/icons/svg")
    private String icon;
    @ApiModelProperty(value = "是否隐藏路由，当设置为 true 的时候该路由不会在侧边栏出现")
    private boolean hidden;
    @ApiModelProperty(value = "路由参数，如：{ \"id\": 1, \"name\": \"ly\" }")
    private String query;
    @ApiModelProperty(value = "当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面")
    private Boolean alwaysShow;
    @ApiModelProperty(value = "内链地址（http(s)://开头）")
    private String link;

    public MetaVO() {
    }

    public MetaVO(String title, String icon, boolean hidden, String query, Boolean alwaysShow, String link) {
        this.title = title;
        this.icon = icon;
        this.hidden = hidden;
        this.query = query;
        this.alwaysShow = alwaysShow;
        this.link = link;
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
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取
     * @return hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * 设置
     * @param hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 获取
     * @return query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置
     * @param query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 获取
     * @return alwaysShow
     */
    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    /**
     * 设置
     * @param alwaysShow
     */
    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    /**
     * 获取
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return "MetaVO{title = " + title + ", icon = " + icon + ", hidden = " + hidden + ", query = " + query + ", alwaysShow = " + alwaysShow + ", link = " + link + "}";
    }
}
