package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指标填报模版分组对象 tag_fill_template_group
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TagFillTemplateGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 分组名称 */
    @Excel(name = "分组名称")
    private String groupName;

    /** 模版名称 */
    @Excel(name = "模版名称")
    private String tempName;

    /** 模版uuid */
    private String tempUuid;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private Integer toUse;

    /** 排序 */
    private Long sort;

    /** 版本 */
    private Long version;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("groupName", getGroupName())
            .append("tempName", getTempName())
            .append("tempUuid", getTempUuid())
            .append("toUse", getToUse())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
