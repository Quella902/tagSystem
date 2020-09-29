package com.ruoyi.tag.service;

import com.ruoyi.tag.domain.ReportDefine;
import java.util.List;

/**
 * 报表定义Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface IReportDefineService {
    /**
     * 查询报表定义
     * 
     * @param id 报表定义ID
     * @return 报表定义
     */
    public ReportDefine selectReportDefineById(Long id);

    /**
     * 查询报表定义列表
     * 
     * @param reportDefine 报表定义
     * @return 报表定义集合
     */
    public List<ReportDefine> selectReportDefineList(ReportDefine reportDefine);

    /**
     * 新增报表定义
     * 
     * @param reportDefine 报表定义
     * @return 结果
     */
    public int insertReportDefine(ReportDefine reportDefine);

    /**
     * 修改报表定义
     * 
     * @param reportDefine 报表定义
     * @return 结果
     */
    public int updateReportDefine(ReportDefine reportDefine);

    /**
     * 批量删除报表定义
     * 
     * @param ids 需要删除的报表定义ID
     * @return 结果
     */
    public int deleteReportDefineByIds(Long[] ids);

    /**
     * 删除报表定义信息
     * 
     * @param id 报表定义ID
     * @return 结果
     */
    public int deleteReportDefineById(Long id);
}
