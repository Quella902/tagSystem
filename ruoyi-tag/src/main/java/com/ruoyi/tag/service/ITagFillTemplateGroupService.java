package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagFillTemplateGroup;
import java.util.List;

/**
 * 指标填报模版分组Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagFillTemplateGroupService {
    /**
     * 查询指标填报模版分组
     * 
     * @param id 指标填报模版分组ID
     * @return 指标填报模版分组
     */
    public TagFillTemplateGroup selectTagFillTemplateGroupById(Long id);

    /**
     * 查询指标填报模版分组列表
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 指标填报模版分组集合
     */
    public List<TagFillTemplateGroup> selectTagFillTemplateGroupList(TagFillTemplateGroup tagFillTemplateGroup);

    /**
     * 新增指标填报模版分组
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 结果
     */
    public int insertTagFillTemplateGroup(TagFillTemplateGroup tagFillTemplateGroup);

    /**
     * 修改指标填报模版分组
     * 
     * @param tagFillTemplateGroup 指标填报模版分组
     * @return 结果
     */
    public int updateTagFillTemplateGroup(TagFillTemplateGroup tagFillTemplateGroup);

    /**
     * 批量删除指标填报模版分组
     * 
     * @param ids 需要删除的指标填报模版分组ID
     * @return 结果
     */
    public int deleteTagFillTemplateGroupByIds(Long[] ids);

    /**
     * 删除指标填报模版分组信息
     * 
     * @param id 指标填报模版分组ID
     * @return 结果
     */
    public int deleteTagFillTemplateGroupById(Long id);
}
