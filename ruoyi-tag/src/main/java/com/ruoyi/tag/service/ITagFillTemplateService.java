package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagFillTemplate;
import java.util.List;

/**
 * 指标填报模版Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagFillTemplateService {
    /**
     * 查询指标填报模版
     * 
     * @param id 指标填报模版ID
     * @return 指标填报模版
     */
    public TagFillTemplate selectTagFillTemplateById(Long id);

    /**
     * 查询指标填报模版列表
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 指标填报模版集合
     */
    public List<TagFillTemplate> selectTagFillTemplateList(TagFillTemplate tagFillTemplate);

    /**
     * 新增指标填报模版
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 结果
     */
    public int insertTagFillTemplate(TagFillTemplate tagFillTemplate);

    /**
     * 修改指标填报模版
     * 
     * @param tagFillTemplate 指标填报模版
     * @return 结果
     */
    public int updateTagFillTemplate(TagFillTemplate tagFillTemplate);

    /**
     * 批量删除指标填报模版
     * 
     * @param ids 需要删除的指标填报模版ID
     * @return 结果
     */
    public int deleteTagFillTemplateByIds(Long[] ids);

    /**
     * 删除指标填报模版信息
     * 
     * @param id 指标填报模版ID
     * @return 结果
     */
    public int deleteTagFillTemplateById(Long id);
}
