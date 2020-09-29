package com.ruoyi.tag.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.tag.domain.ReportDefine;
import com.ruoyi.tag.mapper.ReportDefineMapper;
import com.ruoyi.tag.service.IReportDefineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 报表定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class ReportDefineServiceImpl implements IReportDefineService
{

    @Autowired
    private ReportDefineMapper reportDefineMapper;
    
    /**
     * 查询报表定义
     * 
     * @param id 报表定义ID
     * @return 报表定义
     */
    @Override
    public ReportDefine selectReportDefineById(Long id)
    {
        return reportDefineMapper.selectReportDefineById(id);
    }

    /**
     * 查询报表定义列表
     * 
     * @param reportDefine 报表定义
     * @return 报表定义
     */
    @Override
    public List<ReportDefine> selectReportDefineList(ReportDefine reportDefine)
    {
        return reportDefineMapper.selectReportDefineList(reportDefine);
    }

    /**
     * 新增报表定义
     * 
     * @param reportDefine 报表定义
     * @return 结果
     */
    @Override
    public int insertReportDefine(ReportDefine reportDefine)
    {
        reportDefine.setCreateTime(DateUtils.getNowDate());
        reportDefine.setUuid(IdUtils.simpleUUID());
        return reportDefineMapper.insertReportDefine(reportDefine);
    }

    /**
     * 修改报表定义
     * 
     * @param reportDefine 报表定义
     * @return 结果
     */
    @Override
    public int updateReportDefine(ReportDefine reportDefine)
    {
        reportDefine.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isEmpty(reportDefine.getUuid())){
            reportDefine.setUuid(IdUtils.simpleUUID());
        }
        return reportDefineMapper.updateReportDefine(reportDefine);
    }

    /**
     * 批量删除报表定义
     * 
     * @param ids 需要删除的报表定义ID
     * @return 结果
     */
    @Override
    public int deleteReportDefineByIds(Long[] ids)
    {
        return reportDefineMapper.deleteReportDefineByIds(ids);
    }

    /**
     * 删除报表定义信息
     * 
     * @param id 报表定义ID
     * @return 结果
     */
    @Override
    public int deleteReportDefineById(Long id)
    {
        return reportDefineMapper.deleteReportDefineById(id);
    }
}
