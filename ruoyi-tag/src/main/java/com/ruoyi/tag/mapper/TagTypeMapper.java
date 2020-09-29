package com.ruoyi.tag.mapper;

import com.ruoyi.tag.domain.TagType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 指标类型Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Mapper
public interface TagTypeMapper {
    /**
     * 查询指标类型
     * 
     * @param id 指标类型ID
     * @return 指标类型
     */
    public TagType selectTagTypeById(Long id);

    /**
     * 查询指标类型列表
     * 
     * @param tagType 指标类型
     * @return 指标类型集合
     */
    public List<TagType> selectTagTypeList(TagType tagType);

    /**
     * 新增指标类型
     * 
     * @param tagType 指标类型
     * @return 结果
     */
    public int insertTagType(TagType tagType);

    /**
     * 修改指标类型
     * 
     * @param tagType 指标类型
     * @return 结果
     */
    public int updateTagType(TagType tagType);

    /**
     * 删除指标类型
     * 
     * @param id 指标类型ID
     * @return 结果
     */
    public int deleteTagTypeById(Long id);

    /**
     * 批量删除指标类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTagTypeByIds(Long[] ids);
}
