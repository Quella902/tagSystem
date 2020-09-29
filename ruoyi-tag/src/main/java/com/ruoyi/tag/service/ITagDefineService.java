package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TagDefine;
import com.ruoyi.tag.vo.TreeVO;
import java.util.List;

/**
 * 指标定义Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITagDefineService {
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
     * 批量删除指标定义
     * 
     * @param ids 需要删除的指标定义ID
     * @return 结果
     */
    public int deleteTagDefineByIds(Long[] ids);

    /**
     * 删除指标定义信息
     * 
     * @param id 指标定义ID
     * @return 结果
     */
    public int deleteTagDefineById(Long id);
    
    /**
     * 获取指标树结构数据
     * @return
     */
	List<TreeVO<TagDefine>> getTagTreeData();
}
