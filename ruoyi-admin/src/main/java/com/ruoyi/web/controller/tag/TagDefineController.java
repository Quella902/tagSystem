package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagDefine;
import com.ruoyi.tag.service.ITagDefineService;
import com.ruoyi.tag.vo.TreeVO;
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
 * 指标定义Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagDefine")
public class TagDefineController extends BaseController
{
    @Autowired
    private ITagDefineService tagDefineService;

    /**
     * 查询指标定义列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:list')")
    @GetMapping("/list")
    public TableDataInfo list(TagDefine tagDefine)
    {
        startPage();
        List<TagDefine> list = tagDefineService.selectTagDefineList(tagDefine);
        return getDataTable(list);
    }

    /**
     * 导出指标定义列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:export')")
    @Log(title = "指标定义", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagDefine tagDefine)
    {
        List<TagDefine> list = tagDefineService.selectTagDefineList(tagDefine);
        ExcelUtil<TagDefine> util = new ExcelUtil<TagDefine>(TagDefine.class);
        return util.exportExcel(list, "tagDefine");
    }

    /**
     * 获取指标定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagDefineService.selectTagDefineById(id));
    }

    /**
     * 新增指标定义
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:add')")
    @Log(title = "指标定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagDefine tagDefine)
    {
        return toAjax(tagDefineService.insertTagDefine(tagDefine));
    }

    /**
     * 修改指标定义
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:edit')")
    @Log(title = "指标定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagDefine tagDefine)
    {
        return toAjax(tagDefineService.updateTagDefine(tagDefine));
    }

    /**
     * 删除指标定义
     */
    @PreAuthorize("@ss.hasPermi('tag:tagDefine:remove')")
    @Log(title = "指标定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagDefineService.deleteTagDefineByIds(ids));
    }
    
    /**
     * 获取指标树结构数据
     * @return
     */
    @GetMapping(value = "/getTagTreeData")
    public AjaxResult getTagTreeData(){
        List<TreeVO<TagDefine>> result =  tagDefineService.getTagTreeData();
        return AjaxResult.success(result);
        
    }
    
}
