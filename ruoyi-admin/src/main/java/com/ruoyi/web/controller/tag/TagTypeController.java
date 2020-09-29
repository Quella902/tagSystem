package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagType;
import com.ruoyi.tag.service.ITagTypeService;
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
 * 指标类型Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagType")
public class TagTypeController extends BaseController
{
    @Autowired
    private ITagTypeService tagTypeService;

    /**
     * 查询指标类型列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:list')")
    @GetMapping("/list")
    public AjaxResult list(TagType tagType)
    {
//        startPage();
        List<TagType> list = tagTypeService.selectTagTypeList(tagType);
        return AjaxResult.success(list);
    }

    /**
     * 导出指标类型列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:export')")
    @Log(title = "指标类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagType tagType)
    {
        List<TagType> list = tagTypeService.selectTagTypeList(tagType);
        ExcelUtil<TagType> util = new ExcelUtil<TagType>(TagType.class);
        return util.exportExcel(list, "tagType");
    }

    /**
     * 获取指标类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagTypeService.selectTagTypeById(id));
    }

    /**
     * 新增指标类型
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:add')")
    @Log(title = "指标类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagType tagType)
    {
        return toAjax(tagTypeService.insertTagType(tagType));
    }

    /**
     * 修改指标类型
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:edit')")
    @Log(title = "指标类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagType tagType)
    {
        return toAjax(tagTypeService.updateTagType(tagType));
    }

    /**
     * 删除指标类型
     */
    @PreAuthorize("@ss.hasPermi('tag:tagType:remove')")
    @Log(title = "指标类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagTypeService.deleteTagTypeByIds(ids));
    }
    
    /**
     * 获取指标类型树形结构数据
     * @return
     */
    @GetMapping("/getTreeData")
    public AjaxResult getTreeData(){
        List<TreeVO<TagType>> treeData = tagTypeService.getTreData();
        return AjaxResult.success(treeData);
    }



}
