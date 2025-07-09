package cn.elitecode.module.resume.dal.mysql.tag;

import cn.elitecode.module.resume.controller.admin.tag.vo.TagQueryDTO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;
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
     * @param tagDO
     */
    void insert(TagDO tagDO);

    /**
     * 根据id数组批量删除标签
     * @param tagIds
     */
    void deleteTagByIds(@Param("tagIds") Long[] tagIds);

    /**
     * 根据id修改标签
     * @param tagDO
     */
    void updateTagById(TagDO tagDO);

    /**
     * 根据分页条件查询标签信息
     * @param tagQueryDTO
     * @return
     */
    List<TagDO> selectTagList(TagQueryDTO tagQueryDTO);

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
    List<TagDO> selectTagAll();

    /**
     * 根据id查询标签信息
     * @param tagId
     * @return
     */
    TagDO selectTagById(Long tagId);
}




