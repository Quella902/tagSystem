package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TagDefine;
import com.ruoyi.tag.mapper.TagDefineMapper;
import com.ruoyi.tag.service.ITagDefineService;
import com.ruoyi.tag.vo.TreeVO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 指标定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TagDefineServiceImpl implements ITagDefineService
{

    @Autowired
    private TagDefineMapper tagDefineMapper;
    
    /**
     * 查询指标定义
     * 
     * @param id 指标定义ID
     * @return 指标定义
     */
    @Override
    public TagDefine selectTagDefineById(Long id)
    {
        return tagDefineMapper.selectTagDefineById(id);
    }

    /**
     * 查询指标定义列表
     * 
     * @param tagDefine 指标定义
     * @return 指标定义
     */
    @Override
    public List<TagDefine> selectTagDefineList(TagDefine tagDefine)
    {
        return tagDefineMapper.selectTagDefineList(tagDefine);
    }

    /**
     * 新增指标定义
     * 
     * @param tagDefine 指标定义
     * @return 结果
     */
    @Override
    public int insertTagDefine(TagDefine tagDefine)
    {
        tagDefine.setCreateTime(DateUtils.getNowDate());
        tagDefine.setUuid(IdUtils.simpleUUID());
        if(StringUtils.isEmpty(tagDefine.getParentUuid())){
            tagDefine.setParentUuid(null);
            tagDefine.setParentName(null);
        }
        return tagDefineMapper.insertTagDefine(tagDefine);
    }

    /**
     * 修改指标定义
     * 
     * @param tagDefine 指标定义
     * @return 结果
     */
    @Override
    public int updateTagDefine(TagDefine tagDefine)
    {
        tagDefine.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(tagDefine.getUuid())){
            tagDefine.setUuid(IdUtils.simpleUUID());
        }
        if(StringUtils.isEmpty(tagDefine.getParentUuid())){
            tagDefine.setParentUuid("0");
            tagDefine.setParentName(null);
        }
        return tagDefineMapper.updateTagDefine(tagDefine);
    }

    /**
     * 批量删除指标定义
     * 
     * @param ids 需要删除的指标定义ID
     * @return 结果
     */
    @Override
    public int deleteTagDefineByIds(Long[] ids)
    {
        return tagDefineMapper.deleteTagDefineByIds(ids);
    }

    /**
     * 删除指标定义信息
     * 
     * @param id 指标定义ID
     * @return 结果
     */
    @Override
    public int deleteTagDefineById(Long id)
    {
        return tagDefineMapper.deleteTagDefineById(id);
    }
    
    /**
     * 获取指标树结构数据
     * @return
     */
	@Override
	public List<TreeVO<TagDefine>> getTagTreeData(){
        List<TagDefine> list = tagDefineMapper.selectTagDefineList(null);
        List<TreeVO<TagDefine>> result = list.stream()
            .filter(item -> item.getParentUuid() == "0")
            .map(item -> {
                TreeVO<TagDefine> vo = new TreeVO();
                vo.setLabel(item.getTagName());
                vo.setId(item.getUuid());
                vo.setData(item);
                vo.setChildren(getChilds(item.getUuid(),list));
                return vo;
            })
            .collect(Collectors.toList());
        return result;
	}
	
	private List<TreeVO<TagDefine>> getChilds(String parentId ,List<TagDefine> list){
        List<TreeVO<TagDefine>> result = null;
        result = list.stream()
            .filter(item -> parentId.equals(item.getParentUuid()))
            .map(item -> {
                TreeVO<TagDefine> vo = new TreeVO();
                vo.setLabel(item.getTagName());
                vo.setId(item.getUuid());
                vo.setData(item);
                vo.setChildren(getChilds(item.getUuid(),list));
                return vo;
            })
            .collect(Collectors.toList());
        return result == null ? new ArrayList<>() : result;
    }
}
