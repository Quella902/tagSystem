package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.ReportDefine;
import com.ruoyi.tag.service.IReportDefineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表定义Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/reportDefine")
public class ReportDefineController extends BaseController
{
    @Autowired
    private IReportDefineService reportDefineService;

    /**
     * 查询报表定义列表
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReportDefine reportDefine)
    {
        startPage();
        List<ReportDefine> list = reportDefineService.selectReportDefineList(reportDefine);
        return getDataTable(list);
    }

    /**
     * 导出报表定义列表
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:export')")
    @Log(title = "报表定义", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ReportDefine reportDefine)
    {
        List<ReportDefine> list = reportDefineService.selectReportDefineList(reportDefine);
        ExcelUtil<ReportDefine> util = new ExcelUtil<ReportDefine>(ReportDefine.class);
        return util.exportExcel(list, "reportDefine");
    }

    /**
     * 获取报表定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(reportDefineService.selectReportDefineById(id));
    }

    /**
     * 新增报表定义
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:add')")
    @Log(title = "报表定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReportDefine reportDefine)
    {
        return toAjax(reportDefineService.insertReportDefine(reportDefine));
    }

    /**
     * 修改报表定义
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:edit')")
    @Log(title = "报表定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReportDefine reportDefine)
    {
        return toAjax(reportDefineService.updateReportDefine(reportDefine));
    }

    /**
     * 删除报表定义
     */
    @PreAuthorize("@ss.hasPermi('tag:reportDefine:remove')")
    @Log(title = "报表定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(reportDefineService.deleteReportDefineByIds(ids));
    }
}
