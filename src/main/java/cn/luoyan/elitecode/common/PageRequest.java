package cn.luoyan.elitecode.common;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 分页起始索引（默认为0）
     * 添加 @JsonIgnore 注解使该字段在序列化和反序列化时被忽略，从而不在 Swagger 文档中显示
     */
    @JsonIgnore
    private transient int offset = 0;

    /**
     * 排序字段列表，支持多个字段
     * 格式：字段名 + 排序方向（如 "created_time desc" 或 "id asc"）
     */
    private List<String> sortFieldPair;


    public PageRequest() {
    }

    public PageRequest(int current, int pageSize, int offset, List<String> SortFieldPair) {
        this.current = current;
        this.pageSize = pageSize;
        this.offset = offset;
        this.sortFieldPair = SortFieldPair;
    }

    /**
     * 获取
     * @return current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * 设置
     * @param current
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * 获取
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * 设置
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * 获取
     * @return SortFieldPair
     */
    public List<String> getSortFieldPair() {
        return sortFieldPair;
    }

    /**
     * 设置
     * @param SortFieldPair
     */
    public void setSortFieldPair(List<String> SortFieldPair) {
        this.sortFieldPair = SortFieldPair;
    }

    public String toString() {
        return "PageRequest{current = " + current + ", pageSize = " + pageSize + ", offset = " + offset + ", SortFieldPair = " + sortFieldPair + "}";
    }
}
