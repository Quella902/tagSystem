package com.ruoyi.tag.mapper;

import com.ruoyi.tag.domain.TagUnit;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 指标单位Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Mapper
public interface TagUnitMapper {
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
     * 删除指标单位
     * 
     * @param id 指标单位ID
     * @return 结果
     */
    public int deleteTagUnitById(Long id);

    /**
     * 批量删除指标单位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTagUnitByIds(Long[] ids);
}
