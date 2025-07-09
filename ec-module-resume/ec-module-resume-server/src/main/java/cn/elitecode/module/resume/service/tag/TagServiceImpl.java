package cn.elitecode.module.resume.service.tag;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagAddDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagQueryDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagUpdateDTO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;
import cn.elitecode.module.resume.dal.mysql.tag.TagMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* question_tag(题目标签表) | 业务处理层
*/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Long addTag(TagAddDTO tagAddDTO) {
        TagDO tagDO = new TagDO();
        BeanUtils.copyProperties(tagAddDTO, tagDO);
        tagDO.setCreateBy(SecurityUtil.getUserId());
        tagMapper.insert(tagDO);
        return tagDO.getId();
    }

    @Override
    public void removeTagByIds(Long[] tagIds) {
        tagMapper.deleteTagByIds(tagIds);
    }

    @Override
    public void updateTag(TagUpdateDTO tagUpdateDTO) {
        TagDO tagDO = new TagDO();
        BeanUtils.copyProperties(tagUpdateDTO, tagDO);
        tagDO.setUpdateBy(SecurityUtil.getUserId());
        tagMapper.updateTagById(tagDO);
    }

    @Override
    public CommonPage<TagDO> selectTagList(TagQueryDTO tagQueryDTO) {
        if (tagQueryDTO.getCurrent() != null && tagQueryDTO.getPageSize() != null) {
            tagQueryDTO.setCurrent((tagQueryDTO.getCurrent() - 1) * tagQueryDTO.getPageSize());
        }
        List<TagDO> tagDOList = tagMapper.selectTagList(tagQueryDTO);
        Long total = tagMapper.getTotal(tagQueryDTO);
        CommonPage<TagDO> page = new CommonPage<>(total, tagDOList);
        return page;
    }

    @Override
    public List<TagDO> selectTagAll() {
        List<TagDO> tagDOList = tagMapper.selectTagAll();
        return tagDOList;
    }

    @Override
    public TagDO selectTagById(Long tagId) {
        TagDO tagDO = tagMapper.selectTagById(tagId);
        return tagDO;
    }

}




