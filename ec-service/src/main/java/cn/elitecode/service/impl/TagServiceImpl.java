package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.framework.core.utils.SecurityUtil;
import cn.elitecode.mapper.TagMapper;
import cn.elitecode.model.dto.tag.TagAddDTO;
import cn.elitecode.model.dto.tag.TagQueryDTO;
import cn.elitecode.model.dto.tag.TagUpdateDTO;
import cn.elitecode.model.entity.Tag;
import cn.elitecode.service.TagService;
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
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagAddDTO, tag);
        tag.setCreateBy(SecurityUtil.getUserId());
        tagMapper.insert(tag);
        return tag.getId();
    }

    @Override
    public void removeTagByIds(Long[] tagIds) {
        tagMapper.deleteTagByIds(tagIds);
    }

    @Override
    public void updateTag(TagUpdateDTO tagUpdateDTO) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagUpdateDTO, tag);
        tag.setUpdateBy(SecurityUtil.getUserId());
        tagMapper.updateTagById(tag);
    }

    @Override
    public CommonPage<Tag> selectTagList(TagQueryDTO tagQueryDTO) {
        if (tagQueryDTO.getCurrent() != null && tagQueryDTO.getPageSize() != null) {
            tagQueryDTO.setCurrent((tagQueryDTO.getCurrent() - 1) * tagQueryDTO.getPageSize());
        }
        List<Tag> tagList = tagMapper.selectTagList(tagQueryDTO);
        Long total = tagMapper.getTotal(tagQueryDTO);
        CommonPage<Tag> page = new CommonPage<>(total, tagList);
        return page;
    }

    @Override
    public List<Tag> selectTagAll() {
        List<Tag> tagList = tagMapper.selectTagAll();
        return tagList;
    }

    @Override
    public Tag selectTagById(Long tagId) {
        Tag tag = tagMapper.selectTagById(tagId);
        return tag;
    }

}




