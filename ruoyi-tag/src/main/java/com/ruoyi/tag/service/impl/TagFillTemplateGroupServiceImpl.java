package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagFillTemplateGroup;
import com.ruoyi.tag.mapper.TagFillTemplateGroupMapper;
import com.ruoyi.tag.service.ITagFillTemplateGroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 指标填报模版分组Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagFillTemplateGroupServiceImpl implements ITagFillTemplateGroupService
{

    @Autowired
    private TagFillTemplateGroupMapper tagFillTemplateGroupMapper;
    /**
     * 查询指标填报模版分组
     * 
     * @param id 指标填报模版分组ID
     * @return 指标填报模版分组
     */
    @Override
    public TagFillTemplateGroup selectTagFillTemplateGroupById(Long id)
    {
        return tagFillTemplateGroupMapper.selectTagFillTemplateGroupById(id);
    }

    /**
     * 查询指标填报模版分组列表
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 指标填报模版分组
     */
    @Override
    public List<TagFillTemplateGroup> selectTagFillTemplateGroupList(TagFillTemplateGroup tagFillTemplateGroup)
    {
        return tagFillTemplateGroupMapper.selectTagFillTemplateGroupList(tagFillTemplateGroup);
    }

    /**
     * 新增指标填报模版分组
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 结果
     */
    @Override
    public int insertTagFillTemplateGroup(TagFillTemplateGroup tagFillTemplateGroup)
    {
        tagFillTemplateGroup.setCreateTime(DateUtils.getNowDate());
        tagFillTemplateGroup.setUuid(IdUtils.simpleUUID());
        return tagFillTemplateGroupMapper.insertTagFillTemplateGroup(tagFillTemplateGroup);
    }

    /**
     * 修改指标填报模版分组
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 结果
     */
    @Override
    public int updateTagFillTemplateGroup(TagFillTemplateGroup tagFillTemplateGroup)
    {
        tagFillTemplateGroup.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagFillTemplateGroup.getUuid())){
            tagFillTemplateGroup.setUuid(IdUtils.simpleUUID());
        }
        return tagFillTemplateGroupMapper.updateTagFillTemplateGroup(tagFillTemplateGroup);
    }

    /**
     * 批量删除指标填报模版分组
     * 
     * @param ids 需要删除的指标填报模版分组ID
     * @return 结果
     */
    @Override
    public int deleteTagFillTemplateGroupByIds(Long[] ids)
    {
        return tagFillTemplateGroupMapper.deleteTagFillTemplateGroupByIds(ids);
    }

    /**
     * 删除指标填报模版分组信息
     * 
     * @param id 指标填报模版分组ID
     * @return 结果
     */
    @Override
    public int deleteTagFillTemplateGroupById(Long id)
    {
        return tagFillTemplateGroupMapper.deleteTagFillTemplateGroupById(id);
    }
}
