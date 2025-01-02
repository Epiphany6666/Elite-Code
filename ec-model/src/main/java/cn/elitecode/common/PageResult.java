package cn.elitecode.common;

import java.util.List;

public class PageResult<T> {
    private Long total;
    private List<T> data;


    public PageResult() {
    }

    public PageResult(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    /**
     * 获取
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    public String toString() {
        return "PageResult{total = " + total + ", data = " + data + "}";
    }
}
