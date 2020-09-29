package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagType;
import com.ruoyi.tag.mapper.TagTypeMapper;
import com.ruoyi.tag.service.ITagTypeService;
import com.ruoyi.tag.vo.TreeVO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 指标类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagTypeServiceImpl implements ITagTypeService
{

    @Autowired
    private TagTypeMapper tagTypeMapper;
    
    /**
     * 查询指标类型
     * 
     * @param id 指标类型ID
     * @return 指标类型
     */
    @Override
    public TagType selectTagTypeById(Long id)
    {
        return tagTypeMapper.selectTagTypeById(id);
    }

    /**
     * 查询指标类型列表
     * 
     * @param tagType 指标类型
     * @return 指标类型
     */
    @Override
    public List<TagType> selectTagTypeList(TagType tagType)
    {
        return tagTypeMapper.selectTagTypeList(tagType);
    }

    /**
     * 新增指标类型
     * 
     * @param tagType 指标类型
     * @return 结果
     */
    @Override
    public int insertTagType(TagType tagType)
    {
        tagType.setCreateTime(DateUtils.getNowDate());
        tagType.setUuid(IdUtils.simpleUUID());
        return tagTypeMapper.insertTagType(tagType);
    }

    /**
     * 修改指标类型
     * 
     * @param tagType 指标类型
     * @return 结果
     */
    @Override
    public int updateTagType(TagType tagType)
    {
        tagType.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagType.getUuid())){
            tagType.setUuid(IdUtils.simpleUUID());
        }
        return tagTypeMapper.updateTagType(tagType);
    }

    /**
     * 批量删除指标类型
     * 
     * @param ids 需要删除的指标类型ID
     * @return 结果
     */
    @Override
    public int deleteTagTypeByIds(Long[] ids)
    {
        return tagTypeMapper.deleteTagTypeByIds(ids);
    }

    /**
     * 删除指标类型信息
     * 
     * @param id 指标类型ID
     * @return 结果
     */
    @Override
    public int deleteTagTypeById(Long id)
    {
        return tagTypeMapper.deleteTagTypeById(id);
    }
    
    /**
     * 获取指标类型树形结构数据
     * @return
     */
	@Override
	public List<TreeVO<TagType>> getTreData(){
        List<TagType> list = this.selectTagTypeList(null);
        List<TreeVO<TagType>> result = list.stream()
            .filter(item -> "0".equals(item.getParentUuid()))
            .map(item -> {
                TreeVO<TagType> vo = new TreeVO();
                vo.setLabel(item.getTypeName());
                vo.setId(item.getUuid());
                vo.setData(item);
                vo.setChildren(getChildren(item.getUuid(),list));
                return vo;
            })
            .collect(Collectors.toList());
        return result;
        
        
    }
    
    /**
     * 递归获取子节点
     * @param parentUUId
     * @param list
     * @return
     */
    private List<TreeVO<TagType>> getChildren(String parentUUId,List<TagType> list){
    
        List<TreeVO<TagType>> result = null;
        result = list.stream()
            .filter(item -> parentUUId.equals(item.getParentUuid()))
            .map(item -> {
                TreeVO<TagType> vo = new TreeVO();
                vo.setLabel(item.getTypeName());
                vo.setId(item.getUuid());
                vo.setData(item);
                vo.setChildren(getChildren(item.getUuid(),list));
                return vo;
            })
            .collect(Collectors.toList());
        return result == null ? new ArrayList<>() : result;
    
    }
    
}
