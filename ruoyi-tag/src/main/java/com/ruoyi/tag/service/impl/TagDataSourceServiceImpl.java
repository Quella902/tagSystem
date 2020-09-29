package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagDataSource;
import com.ruoyi.tag.mapper.TagDataSourceMapper;
import com.ruoyi.tag.service.ITagDataSourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 指标数据源Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagDataSourceServiceImpl implements ITagDataSourceService
{
    
    @Autowired
    private TagDataSourceMapper tagDataSourceMapper;
    /**
     * 查询指标数据源
     * 
     * @param id 指标数据源ID
     * @return 指标数据源
     */
    @Override
    public TagDataSource selectTagDataSourceById(Long id)
    {
        return tagDataSourceMapper.selectTagDataSourceById(id);
    }

    /**
     * 查询指标数据源列表
     * 
     * @param tagDataSource 指标数据源
     * @return 指标数据源
     */
    @Override
    public List<TagDataSource> selectTagDataSourceList(TagDataSource tagDataSource)
    {
        return tagDataSourceMapper.selectTagDataSourceList(tagDataSource);
    }

    /**
     * 新增指标数据源
     * 
     * @param tagDataSource 指标数据源
     * @return 结果
     */
    @Override
    public int insertTagDataSource(TagDataSource tagDataSource)
    {
        tagDataSource.setCreateTime(DateUtils.getNowDate());
        tagDataSource.setUuid(IdUtils.simpleUUID());
        return tagDataSourceMapper.insertTagDataSource(tagDataSource);
    }

    /**
     * 修改指标数据源
     * 
     * @param tagDataSource 指标数据源
     * @return 结果
     */
    @Override
    public int updateTagDataSource(TagDataSource tagDataSource)
    {
        tagDataSource.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagDataSource.getUuid())){
            tagDataSource.setUuid(IdUtils.simpleUUID());
        }
        return tagDataSourceMapper.updateTagDataSource(tagDataSource);
    }

    /**
     * 批量删除指标数据源
     * 
     * @param ids 需要删除的指标数据源ID
     * @return 结果
     */
    @Override
    public int deleteTagDataSourceByIds(Long[] ids)
    {
        return tagDataSourceMapper.deleteTagDataSourceByIds(ids);
    }

    /**
     * 删除指标数据源信息
     * 
     * @param id 指标数据源ID
     * @return 结果
     */
    @Override
    public int deleteTagDataSourceById(Long id)
    {
        return tagDataSourceMapper.deleteTagDataSourceById(id);
    }
}
