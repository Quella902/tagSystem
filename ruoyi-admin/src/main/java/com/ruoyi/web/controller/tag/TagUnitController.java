package com.ruoyi.web.controller.tag;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.tag.domain.TagUnit;
import com.ruoyi.tag.service.ITagUnitService;
import java.util.List;
import javax.websocket.server.PathParam;
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
 * 指标单位Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/tag/tagUnit")
public class TagUnitController extends BaseController
{
    @Autowired
    private ITagUnitService tagUnitService;

    /**
     * 查询指标单位列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:list')")
    @GetMapping("/list")
    public TableDataInfo list(TagUnit tagUnit)
    {
        startPage();
        List<TagUnit> list = tagUnitService.selectTagUnitList(tagUnit);
        return getDataTable(list);
    }

    /**
     * 导出指标单位列表
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:export')")
    @Log(title = "指标单位", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TagUnit tagUnit)
    {
        List<TagUnit> list = tagUnitService.selectTagUnitList(tagUnit);
        ExcelUtil<TagUnit> util = new ExcelUtil<TagUnit>(TagUnit.class);
        return util.exportExcel(list, "tagUnit");
    }

    /**
     * 获取指标单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tagUnitService.selectTagUnitById(id));
    }

    /**
     * 新增指标单位
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:add')")
    @Log(title = "指标单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagUnit tagUnit)
    {
        return toAjax(tagUnitService.insertTagUnit(tagUnit));
    }

    /**
     * 修改指标单位
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:edit')")
    @Log(title = "指标单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagUnit tagUnit)
    {
        return toAjax(tagUnitService.updateTagUnit(tagUnit));
    }

    /**
     * 删除指标单位
     */
    @PreAuthorize("@ss.hasPermi('tag:tagUnit:remove')")
    @Log(title = "指标单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tagUnitService.deleteTagUnitByIds(ids));
    }
    
    /**
     * 根据单位类型 获取单位列表
     * @param unitTypeId
     * @return
     */
    @GetMapping("/getUnitListByTypeId/{unitTypeId}")
    public AjaxResult getUnitListByTypeId(@PathVariable("unitTypeId") Long unitTypeId){
        List<TagUnit> result = tagUnitService.getUnitListByTypeId(unitTypeId.toString());
        return AjaxResult.success(result);
        
    }
}
