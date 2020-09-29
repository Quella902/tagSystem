package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.TemplateGroupTagInfo;
import com.ruoyi.tag.mapper.TemplateGroupTagInfoMapper;
import com.ruoyi.tag.service.ITemplateGroupTagInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分组指标详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class TemplateGroupTagInfoServiceImpl implements ITemplateGroupTagInfoService
{

    @Autowired
    private TemplateGroupTagInfoMapper templateGroupTagInfoMapper;
    
    /**
     * 查询分组指标详情
     * 
     * @param id 分组指标详情ID
     * @return 分组指标详情
     */
    @Override
    public TemplateGroupTagInfo selectTemplateGroupTagInfoById(Long id)
    {
        return templateGroupTagInfoMapper.selectTemplateGroupTagInfoById(id);
    }

    /**
     * 查询分组指标详情列表
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 分组指标详情
     */
    @Override
    public List<TemplateGroupTagInfo> selectTemplateGroupTagInfoList(TemplateGroupTagInfo templateGroupTagInfo)
    {
        return templateGroupTagInfoMapper.selectTemplateGroupTagInfoList(templateGroupTagInfo);
    }

    /**
     * 新增分组指标详情
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 结果
     */
    @Override
    public int insertTemplateGroupTagInfo(TemplateGroupTagInfo templateGroupTagInfo)
    {
        templateGroupTagInfo.setCreateTime(DateUtils.getNowDate());
        templateGroupTagInfo.setUuid(IdUtils.simpleUUID());
        return templateGroupTagInfoMapper.insertTemplateGroupTagInfo(templateGroupTagInfo);
    }

    /**
     * 修改分组指标详情
     * 
     * @param templateGroupTagInfo 分组指标详情
     * @return 结果
     */
    @Override
    public int updateTemplateGroupTagInfo(TemplateGroupTagInfo templateGroupTagInfo)
    {
        templateGroupTagInfo.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(templateGroupTagInfo.getUuid())){
            templateGroupTagInfo.setUuid(IdUtils.simpleUUID());
        }
        return templateGroupTagInfoMapper.updateTemplateGroupTagInfo(templateGroupTagInfo);
    }

    /**
     * 批量删除分组指标详情
     * 
     * @param ids 需要删除的分组指标详情ID
     * @return 结果
     */
    @Override
    public int deleteTemplateGroupTagInfoByIds(Long[] ids)
    {
        return templateGroupTagInfoMapper.deleteTemplateGroupTagInfoByIds(ids);
    }

    /**
     * 删除分组指标详情信息
     * 
     * @param id 分组指标详情ID
     * @return 结果
     */
    @Override
    public int deleteTemplateGroupTagInfoById(Long id)
    {
        return templateGroupTagInfoMapper.deleteTemplateGroupTagInfoById(id);
    }
}
