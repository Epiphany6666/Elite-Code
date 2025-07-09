package cn.elitecode.framework.common.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * 通用分页数据封装类
 * @param <T> 分页数据泛型
 */
public class CommonPage<T> {

    @ApiModelProperty(value = "总记录数")
    private Long total;

    @ApiModelProperty(value = "列表数据")
    private List<T> list;

    public CommonPage() {
    }

    public CommonPage(Long total, List<T> list) {
        this.total = total;
        this.list = list;
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
    public List<T> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "CommonPage{total = " + total + ", data = " + list + "}";
    }

}
