package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.TemplateGroupTagInfo;
import java.util.List;

/**
 * 分组指标详情Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ITemplateGroupTagInfoService {
    /**
     * 查询分组指标详情
     * 
     * @param id 分组指标详情ID
     * @return 分组指标详情
     */
    public TemplateGroupTagInfo selectTemplateGroupTagInfoById(Long id);

    /**
     * 查询分组指标详情列表
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 分组指标详情集合
     */
    public List<TemplateGroupTagInfo> selectTemplateGroupTagInfoList(TemplateGroupTagInfo templateGroupTagInfo);

    /**
     * 新增分组指标详情
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 结果
     */
    public int insertTemplateGroupTagInfo(TemplateGroupTagInfo templateGroupTagInfo);

    /**
     * 修改分组指标详情
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 结果
     */
    public int updateTemplateGroupTagInfo(TemplateGroupTagInfo templateGroupTagInfo);

    /**
     * 批量删除分组指标详情
     * 
     * @param ids 需要删除的分组指标详情ID
     * @return 结果
     */
    public int deleteTemplateGroupTagInfoByIds(Long[] ids);

    /**
     * 删除分组指标详情信息
     * 
     * @param id 分组指标详情ID
     * @return 结果
     */
    public int deleteTemplateGroupTagInfoById(Long id);
}
