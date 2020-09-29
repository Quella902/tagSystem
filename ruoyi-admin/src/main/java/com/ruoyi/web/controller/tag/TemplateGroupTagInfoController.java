package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TemplateGroupTagInfo;
import com.ruoyi.tag.service.ITemplateGroupTagInfoService;
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
 * 分组指标详情Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/templateGroupTagInfo")
public class TemplateGroupTagInfoController extends BaseController
{
    @Autowired
    private ITemplateGroupTagInfoService templateGroupTagInfoService;

    /**
     * 查询分组指标详情列表
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TemplateGroupTagInfo templateGroupTagInfo)
    {
        startPage();
        List<TemplateGroupTagInfo> list = templateGroupTagInfoService.selectTemplateGroupTagInfoList(templateGroupTagInfo);
        return getDataTable(list);
    }

    /**
     * 导出分组指标详情列表
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:export')")
    @Log(title = "分组指标详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TemplateGroupTagInfo templateGroupTagInfo)
    {
        List<TemplateGroupTagInfo> list = templateGroupTagInfoService.selectTemplateGroupTagInfoList(templateGroupTagInfo);
        ExcelUtil<TemplateGroupTagInfo> util = new ExcelUtil<TemplateGroupTagInfo>(TemplateGroupTagInfo.class);
        return util.exportExcel(list, "templateGroupTagInfo");
    }

    /**
     * 获取分组指标详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(templateGroupTagInfoService.selectTemplateGroupTagInfoById(id));
    }

    /**
     * 新增分组指标详情
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:add')")
    @Log(title = "分组指标详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TemplateGroupTagInfo templateGroupTagInfo)
    {
        return toAjax(templateGroupTagInfoService.insertTemplateGroupTagInfo(templateGroupTagInfo));
    }

    /**
     * 修改分组指标详情
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:edit')")
    @Log(title = "分组指标详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TemplateGroupTagInfo templateGroupTagInfo)
    {
        return toAjax(templateGroupTagInfoService.updateTemplateGroupTagInfo(templateGroupTagInfo));
    }

    /**
     * 删除分组指标详情
     */
    @PreAuthorize("@ss.hasPermi('tag:templateGroupTagInfo:remove')")
    @Log(title = "分组指标详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(templateGroupTagInfoService.deleteTemplateGroupTagInfoByIds(ids));
    }
}
