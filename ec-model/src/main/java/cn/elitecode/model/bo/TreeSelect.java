package cn.elitecode.model.bo;

import cn.elitecode.model.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * TreeSelect树结构实体类
 */
public class TreeSelect implements Serializable {

    @Serial
    private static final long serialVersionUID = 5670025775938809095L;

    /**
     * 节点id
     */
    private Long id;

    /**
     * 节点名称
     */
    private String label;

    /**
     * 子结点
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect() {
    }

    public TreeSelect(Menu menu) {
        this.id = menu.getId();
        this.label = menu.getTitle();
        this.children = menu.getChildren().stream().map(TreeSelect::new).toList();
    }

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
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取
     * @return children
     */
    public List<TreeSelect> getChildren() {
        return children;
    }

    /**
     * 设置
     * @param children
     */
    public void setChildren(List<TreeSelect> children) {
        this.children = children;
    }

}
