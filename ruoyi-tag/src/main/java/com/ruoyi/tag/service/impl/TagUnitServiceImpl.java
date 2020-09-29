package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagUnit;
import com.ruoyi.tag.mapper.TagUnitMapper;
import com.ruoyi.tag.service.ITagUnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

/**
 * 指标单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagUnitServiceImpl implements ITagUnitService
{
    @Autowired
    private TagUnitMapper tagUnitMapper;

    /**
     * 查询指标单位
     * 
     * @param id 指标单位ID
     * @return 指标单位
     */
    @Override
    public TagUnit selectTagUnitById(Long id)
    {
        return tagUnitMapper.selectTagUnitById(id);
    }

    /**
     * 查询指标单位列表
     * 
     * @param tagUnit 指标单位
     * @return 指标单位
     */
    @Override
    public List<TagUnit> selectTagUnitList(TagUnit tagUnit)
    {
        return tagUnitMapper.selectTagUnitList(tagUnit);
    }

    /**
     * 新增指标单位
     * 
     * @param tagUnit 指标单位
     * @return 结果
     */
    @Override
    public int insertTagUnit(TagUnit tagUnit)
    {
        tagUnit.setCreateTime(DateUtils.getNowDate());
        tagUnit.setUuid(IdUtils.simpleUUID());
        return tagUnitMapper.insertTagUnit(tagUnit);
    }

    /**
     * 修改指标单位
     * 
     * @param tagUnit 指标单位
     * @return 结果
     */
    @Override
    public int updateTagUnit(TagUnit tagUnit)
    {
        tagUnit.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagUnit.getUuid())){
            tagUnit.setUuid(IdUtils.simpleUUID());
        }
        return tagUnitMapper.updateTagUnit(tagUnit);
    }

    /**
     * 批量删除指标单位
     * 
     * @param ids 需要删除的指标单位ID
     * @return 结果
     */
    @Override
    public int deleteTagUnitByIds(Long[] ids)
    {
        return tagUnitMapper.deleteTagUnitByIds(ids);
    }

    /**
     * 删除指标单位信息
     * 
     * @param id 指标单位ID
     * @return 结果
     */
    @Override
    public int deleteTagUnitById(Long id)
    {
        return tagUnitMapper.deleteTagUnitById(id);
    }
    
    /**
     * 根据单位类型 获取单位列表
     * @param unitTypeId
     * @return
     */
	@Override
	public List<TagUnit> getUnitListByTypeId(String unitTypeId){
        TagUnit tagUnit = new TagUnit();
        tagUnit.setUnitType(unitTypeId);
        return tagUnitMapper.selectTagUnitList(tagUnit);
    }
}
