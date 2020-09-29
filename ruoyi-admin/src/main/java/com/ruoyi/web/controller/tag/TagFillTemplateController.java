package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagFillTemplate;
import com.ruoyi.tag.service.ITagFillTemplateService;
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
 * 指标填报模版Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagFillTemplate")
public class TagFillTemplateController extends BaseController
{
    @Autowired
    private ITagFillTemplateService tagFillTemplateService;

    /**
     * 查询指标填报模版列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:list')")
    @GetMapping("/list")
    public TableDataInfo list(TagFillTemplate tagFillTemplate)
    {
        startPage();
        List<TagFillTemplate> list = tagFillTemplateService.selectTagFillTemplateList(tagFillTemplate);
        return getDataTable(list);
    }

    /**
     * 导出指标填报模版列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:export')")
    @Log(title = "指标填报模版", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagFillTemplate tagFillTemplate)
    {
        List<TagFillTemplate> list = tagFillTemplateService.selectTagFillTemplateList(tagFillTemplate);
        ExcelUtil<TagFillTemplate> util = new ExcelUtil<TagFillTemplate>(TagFillTemplate.class);
        return util.exportExcel(list, "tagFillTemplate");
    }

    /**
     * 获取指标填报模版详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagFillTemplateService.selectTagFillTemplateById(id));
    }

    /**
     * 新增指标填报模版
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:add')")
    @Log(title = "指标填报模版", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagFillTemplate tagFillTemplate)
    {
        return toAjax(tagFillTemplateService.insertTagFillTemplate(tagFillTemplate));
    }

    /**
     * 修改指标填报模版
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:edit')")
    @Log(title = "指标填报模版", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagFillTemplate tagFillTemplate)
    {
        return toAjax(tagFillTemplateService.updateTagFillTemplate(tagFillTemplate));
    }

    /**
     * 删除指标填报模版
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplate:remove')")
    @Log(title = "指标填报模版", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagFillTemplateService.deleteTagFillTemplateByIds(ids));
    }
}
