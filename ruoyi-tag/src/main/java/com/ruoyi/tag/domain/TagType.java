package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指标类型对象 tag_type
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TagType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String typeName;

    /** 父分类名称 */
    @Excel(name = "父分类名称")
    private String parentName;

    /** 父分类uuid */
    private String parentUuid;

    /** 版本 */
    private Long version;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("typeName", getTypeName())
            .append("parentName", getParentName())
            .append("parentUuid", getParentUuid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("remark", getRemark())
            .toString();
    }
}
