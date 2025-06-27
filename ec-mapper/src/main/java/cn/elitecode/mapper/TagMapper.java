package cn.elitecode.mapper;

import cn.elitecode.model.dto.tag.TagQueryDTO;
import cn.elitecode.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* question_tag(题目标签表)
*/
@Mapper
public interface TagMapper {

    /**
     * 插入标签
     * @param tag
     */
    void insert(Tag tag);

    /**
     * 根据id数组批量删除标签
     * @param tagIds
     */
    void deleteTagByIds(@Param("tagIds") Long[] tagIds);

    /**
     * 根据id修改标签
     * @param tag
     */
    void updateTagById(Tag tag);

    /**
     * 根据分页条件查询标签信息
     * @param tagQueryDTO
     * @return
     */
    List<Tag> selectTagList(TagQueryDTO tagQueryDTO);

    /**
     * 根据分页条件获取标签数量
     * @param tagQueryDTO
     * @return
     */
    Long getTotal(TagQueryDTO tagQueryDTO);

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> selectTagAll();

    /**
     * 根据id查询标签信息
     * @param tagId
     * @return
     */
    Tag selectTagById(Long tagId);
}




