package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.tag.TagAddDTO;
import cn.elitecode.model.dto.tag.TagQueryDTO;
import cn.elitecode.model.dto.tag.TagUpdateDTO;
import cn.elitecode.model.entity.Tag;
import java.util.List;

/**
* question_tag(题目标签表) | 业务层
*/
public interface TagService {

    /**
     * 新增标签
     * @param tagAddDTO
     * @return
     */
    Long addTag(TagAddDTO tagAddDTO);

    /**
     * 根据id数组批量删除标签
     * @param tagIds
     */
    void removeTagByIds(Long[] tagIds);

    /**
     * 根据id修改标签
     * @param tagUpdateDTO
     */
    void updateTag(TagUpdateDTO tagUpdateDTO);

    /**
     * 根据分页条件查询标签信息
     * @param tagQueryDTO
     * @return
     */
    CommonPage<Tag> selectTagList(TagQueryDTO tagQueryDTO);

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
