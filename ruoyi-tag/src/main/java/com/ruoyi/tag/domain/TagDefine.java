package com.ruoyi.tag.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 指标定义对象 tag_define
 *
 * @author ruoyi
 * @date 2020-09-18
 */
@Data
public class TagDefine extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    /** 自增id */
    private Long id;
    
    /** 逻辑id */
    private String uuid;
    
    /** 指标名称 */
    @Excel(name = "指标名称")
    private String tagName;
    
    /** 指标类型uuid */
    @Excel(name = "指标类型uuid")
    private String typeUuid;
    
    /** 指标类型名称 */
    @Excel(name = "指标类型名称")
    private String typeName;
    
    /** 父指标uuid */
    @Excel(name = "父指标uuid")
    private String parentUuid;
    
    /** 父指标名称 */
    private String parentName;
    
    /** 单位类型 */
    @Excel(name = "单位类型")
    private String unitType;
    
    /** 默认单位名称 */
    @Excel(name = "默认单位名称")
    private String unitNameDefault;
    
    /** 默认单位uuid */
    @Excel(name = "默认单位uuid")
    private String unitUuidDefault;
    
    /** 数据类型（文本、数值） */
    @Excel(name = "数据类型", readConverterExp = "文=本、数值")
    private String dataType;
    
    /** 版本 */
    private Long version;
    
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("tagName", getTagName())
            .append("typeUuid", getTypeUuid())
            .append("typeName", getTypeName())
            .append("parentUuid", getParentUuid())
            .append("parentName", getParentName())
            .append("unitType", getUnitType())
            .append("unitNameDefault", getUnitNameDefault())
            .append("unitUuidDefault", getUnitUuidDefault())
            .append("dataType", getDataType())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}