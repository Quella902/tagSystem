package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagFillTemplateGroup;
import com.ruoyi.tag.service.ITagFillTemplateGroupService;
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
 * 指标填报模版分组Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagFillTemplateGroup")
public class TagFillTemplateGroupController extends BaseController
{
    @Autowired
    private ITagFillTemplateGroupService tagFillTemplateGroupService;

    /**
     * 查询指标填报模版分组列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:list')")
    @GetMapping("/list")
    public TableDataInfo list(TagFillTemplateGroup tagFillTemplateGroup)
    {
        startPage();
        List<TagFillTemplateGroup> list = tagFillTemplateGroupService.selectTagFillTemplateGroupList(tagFillTemplateGroup);
        return getDataTable(list);
    }

    /**
     * 导出指标填报模版分组列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:export')")
    @Log(title = "指标填报模版分组", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagFillTemplateGroup tagFillTemplateGroup)
    {
        List<TagFillTemplateGroup> list = tagFillTemplateGroupService.selectTagFillTemplateGroupList(tagFillTemplateGroup);
        ExcelUtil<TagFillTemplateGroup> util = new ExcelUtil<TagFillTemplateGroup>(TagFillTemplateGroup.class);
        return util.exportExcel(list, "tagFillTemplateGroup");
    }

    /**
     * 获取指标填报模版分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagFillTemplateGroupService.selectTagFillTemplateGroupById(id));
    }

    /**
     * 新增指标填报模版分组
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:add')")
    @Log(title = "指标填报模版分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagFillTemplateGroup tagFillTemplateGroup)
    {
        return toAjax(tagFillTemplateGroupService.insertTagFillTemplateGroup(tagFillTemplateGroup));
    }

    /**
     * 修改指标填报模版分组
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:edit')")
    @Log(title = "指标填报模版分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagFillTemplateGroup tagFillTemplateGroup)
    {
        return toAjax(tagFillTemplateGroupService.updateTagFillTemplateGroup(tagFillTemplateGroup));
    }

    /**
     * 删除指标填报模版分组
     */
    @PreAuthorize("@ss.hasPermi('tag:tagFillTemplateGroup:remove')")
    @Log(title = "指标填报模版分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagFillTemplateGroupService.deleteTagFillTemplateGroupByIds(ids));
    }
}
