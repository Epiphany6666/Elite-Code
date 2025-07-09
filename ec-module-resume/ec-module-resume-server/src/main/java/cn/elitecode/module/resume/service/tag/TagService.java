package cn.elitecode.module.resume.service.tag;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagAddDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagQueryDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagUpdateDTO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;

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
    CommonPage<TagDO> selectTagList(TagQueryDTO tagQueryDTO);

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
