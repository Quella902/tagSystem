package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagDataSource;
import com.ruoyi.tag.service.ITagDataSourceService;
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
 * 指标数据源Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagDataSource")
public class TagDataSourceController extends BaseController
{
    @Autowired
    private ITagDataSourceService tagDataSourceService;

    /**
     * 查询指标数据源列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:list')")
    @GetMapping("/list")
    public TableDataInfo list(TagDataSource tagDataSource)
    {
        startPage();
        List<TagDataSource> list = tagDataSourceService.selectTagDataSourceList(tagDataSource);
        return getDataTable(list);
    }

    /**
     * 导出指标数据源列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:export')")
    @Log(title = "指标数据源", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagDataSource tagDataSource)
    {
        List<TagDataSource> list = tagDataSourceService.selectTagDataSourceList(tagDataSource);
        ExcelUtil<TagDataSource> util = new ExcelUtil<TagDataSource>(TagDataSource.class);
        return util.exportExcel(list, "tagDataSource");
    }

    /**
     * 获取指标数据源详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagDataSourceService.selectTagDataSourceById(id));
    }

    /**
     * 新增指标数据源
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:add')")
    @Log(title = "指标数据源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagDataSource tagDataSource)
    {
        return toAjax(tagDataSourceService.insertTagDataSource(tagDataSource));
    }

    /**
     * 修改指标数据源
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:edit')")
    @Log(title = "指标数据源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagDataSource tagDataSource)
    {
        return toAjax(tagDataSourceService.updateTagDataSource(tagDataSource));
    }

    /**
     * 删除指标数据源
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDataSource:remove')")
    @Log(title = "指标数据源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagDataSourceService.deleteTagDataSourceByIds(ids));
    }
}
