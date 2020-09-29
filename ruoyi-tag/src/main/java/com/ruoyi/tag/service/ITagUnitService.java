package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagUnit;
import java.util.List;

/**
 * 指标单位Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagUnitService {
    /**
     * 查询指标单位
     * 
     * @param id 指标单位ID
     * @return 指标单位
     */
    public TagUnit selectTagUnitById(Long id);

    /**
     * 查询指标单位列表
     * 
     * @param tagUnit 指标单位
     * @return 指标单位集合
     */
    public List<TagUnit> selectTagUnitList(TagUnit tagUnit);

    /**
     * 新增指标单位
     * 
     * @param tagUnit 指标单位
     * @return 结果
     */
    public int insertTagUnit(TagUnit tagUnit);

    /**
     * 修改指标单位
     * 
     * @param tagUnit 指标单位
     * @return 结果
     */
    public int updateTagUnit(TagUnit tagUnit);

    /**
     * 批量删除指标单位
     * 
     * @param ids 需要删除的指标单位ID
     * @return 结果
     */
    public int deleteTagUnitByIds(Long[] ids);

    /**
     * 删除指标单位信息
     * 
     * @param id 指标单位ID
     * @return 结果
     */
    public int deleteTagUnitById(Long id);
    
    /**
     * 根据单位类型 获取单位列表
     * @param unitTypeId
     * @return
     */
	List<TagUnit> getUnitListByTypeId(String unitTypeId);
}
