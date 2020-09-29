package com.ruoyi.tag.mapper;

import com.ruoyi.tag.domain.TagFillTemplate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 指标填报模版Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Mapper
public interface TagFillTemplateMapper {
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
     * 删除指标填报模版
     * 
     * @param id 指标填报模版ID
     * @return 结果
     */
    public int deleteTagFillTemplateById(Long id);

    /**
     * 批量删除指标填报模版
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTagFillTemplateByIds(Long[] ids);
}
