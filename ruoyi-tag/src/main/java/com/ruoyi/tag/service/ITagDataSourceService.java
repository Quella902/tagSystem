package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagDataSource;
import java.util.List;

/**
 * 指标数据源Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagDataSourceService {
    /**
     * 查询指标数据源
     * 
     * @param id 指标数据源ID
     * @return 指标数据源
     */
    public TagDataSource selectTagDataSourceById(Long id);

    /**
     * 查询指标数据源列表
     * 
     * @param tagDataSource 指标数据源
     * @return 指标数据源集合
     */
    public List<TagDataSource> selectTagDataSourceList(TagDataSource tagDataSource);

    /**
     * 新增指标数据源
     * 
     * @param tagDataSource 指标数据源
     * @return 结果
     */
    public int insertTagDataSource(TagDataSource tagDataSource);

    /**
     * 修改指标数据源
     * 
     * @param tagDataSource 指标数据源
     * @return 结果
     */
    public int updateTagDataSource(TagDataSource tagDataSource);

    /**
     * 批量删除指标数据源
     * 
     * @param ids 需要删除的指标数据源ID
     * @return 结果
     */
    public int deleteTagDataSourceByIds(Long[] ids);

    /**
     * 删除指标数据源信息
     * 
     * @param id 指标数据源ID
     * @return 结果
     */
    public int deleteTagDataSourceById(Long id);
}
