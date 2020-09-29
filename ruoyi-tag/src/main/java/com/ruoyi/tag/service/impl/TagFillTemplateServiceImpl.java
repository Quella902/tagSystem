package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagFillTemplate;
import com.ruoyi.tag.mapper.TagFillTemplateMapper;
import com.ruoyi.tag.service.ITagFillTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 指标填报模版Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagFillTemplateServiceImpl implements ITagFillTemplateService
{

    @Autowired
    private TagFillTemplateMapper tagFillTemplateMapper;
    /**
     * 查询指标填报模版
     * 
     * @param id 指标填报模版ID
     * @return 指标填报模版
     */
    @Override
    public TagFillTemplate selectTagFillTemplateById(Long id)
    {
        return tagFillTemplateMapper.selectTagFillTemplateById(id);
    }

    /**
     * 查询指标填报模版列表
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 指标填报模版
     */
    @Override
    public List<TagFillTemplate> selectTagFillTemplateList(TagFillTemplate tagFillTemplate)
    {
        return tagFillTemplateMapper.selectTagFillTemplateList(tagFillTemplate);
    }

    /**
     * 新增指标填报模版
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 结果
     */
    @Override
    public int insertTagFillTemplate(TagFillTemplate tagFillTemplate)
    {
        tagFillTemplate.setCreateTime(DateUtils.getNowDate());
        tagFillTemplate.setUuid(IdUtils.simpleUUID());
        return tagFillTemplateMapper.insertTagFillTemplate(tagFillTemplate);
    }

    /**
     * 修改指标填报模版
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 结果
     */
    @Override
    public int updateTagFillTemplate(TagFillTemplate tagFillTemplate)
    {
        tagFillTemplate.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagFillTemplate.getUuid())){
            tagFillTemplate.setUuid(IdUtils.simpleUUID());
        }
        return tagFillTemplateMapper.updateTagFillTemplate(tagFillTemplate);
    }

    /**
     * 批量删除指标填报模版
     * 
     * @param ids 需要删除的指标填报模版ID
     * @return 结果
     */
    @Override
    public int deleteTagFillTemplateByIds(Long[] ids)
    {
        return tagFillTemplateMapper.deleteTagFillTemplateByIds(ids);
    }

    /**
     * 删除指标填报模版信息
     * 
     * @param id 指标填报模版ID
     * @return 结果
     */
    @Override
    public int deleteTagFillTemplateById(Long id)
    {
        return tagFillTemplateMapper.deleteTagFillTemplateById(id);
    }
}
