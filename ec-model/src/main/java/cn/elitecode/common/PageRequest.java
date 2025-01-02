package cn.elitecode.common;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 分页请求
 */
public class PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6445240999999115607L;

    /**
     * 当前页号
     */
    private Integer current = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;

    /**
     * 排序字段列表，支持多个字段
     * 格式：字段名 + 排序方向（如 "created_time desc" 或 "id asc"）
     */
    private List<String> sortFieldPair;


    public PageRequest() {
    }

    public PageRequest(Integer current, Integer pageSize, List<String> sortFieldPair) {
        this.current = current;
        this.pageSize = pageSize;
        this.sortFieldPair = sortFieldPair;
    }

    /**
     * 获取
     * @return current
     */
    public Integer getCurrent() {
        return current;
    }

    /**
     * 设置
     * @param current
     */
    public void setCurrent(Integer current) {
        this.current = current;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return sortFieldPair
     */
    public List<String> getSortFieldPair() {
        return sortFieldPair;
    }

    /**
     * 设置
     * @param sortFieldPair
     */
    public void setSortFieldPair(List<String> sortFieldPair) {
        this.sortFieldPair = sortFieldPair;
    }

    public String toString() {
        return "PageRequest{current = " + current + ", pageSize = " + pageSize + ", sortFieldPair = " + sortFieldPair + "}";
    }
}
