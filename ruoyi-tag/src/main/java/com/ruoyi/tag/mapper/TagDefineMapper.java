package com.ruoyi.tag.mapper;

import com.ruoyi.tag.domain.TagDefine;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 指标定义Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Mapper
public interface TagDefineMapper {
    /**
     * 查询指标定义
     * 
     * @param id 指标定义ID
     * @return 指标定义
     */
    public TagDefine selectTagDefineById(Long id);

    /**
     * 查询指标定义列表
     * 
     * @param tagDefine 指标定义
     * @return 指标定义集合
     */
    public List<TagDefine> selectTagDefineList(TagDefine tagDefine);

    /**
     * 新增指标定义
     * 
     * @param tagDefine 指标定义
     * @return 结果
     */
    public int insertTagDefine(TagDefine tagDefine);

    /**
     * 修改指标定义
     * 
     * @param tagDefine 指标定义
     * @return 结果
     */
    public int updateTagDefine(TagDefine tagDefine);

    /**
     * 删除指标定义
     * 
     * @param id 指标定义ID
     * @return 结果
     */
    public int deleteTagDefineById(Long id);

    /**
     * 批量删除指标定义
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTagDefineByIds(Long[] ids);
}
