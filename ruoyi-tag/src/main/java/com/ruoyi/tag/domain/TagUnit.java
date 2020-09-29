package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指标单位对象 tag_unit
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TagUnit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 名称 */
    @Excel(name = "名称")
    private String unitName;

    /** 符号标识 */
    @Excel(name = "符号标识")
    private String uintSymbol;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private String unitType;

    /** 版本 */
    private Long version;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("unitName", getUnitName())
            .append("uintSymbol", getUintSymbol())
            .append("unitType", getUnitType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
