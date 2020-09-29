package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagType;
import com.ruoyi.tag.vo.TreeVO;
import java.util.List;

/**
 * 指标类型Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagTypeService {
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
     * 批量删除指标类型
     * 
     * @param ids 需要删除的指标类型ID
     * @return 结果
     */
    public int deleteTagTypeByIds(Long[] ids);

    /**
     * 删除指标类型信息
     * 
     * @param id 指标类型ID
     * @return 结果
     */
    public int deleteTagTypeById(Long id);
    
    /**
     * 获取指标类型树形结构数据
     * @return
     */
	List<TreeVO<TagType>> getTreData();
	
}
