package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指标填报模版对象 tag_fill_template
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TagFillTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 模版名称 */
    @Excel(name = "模版名称")
    private String tempName;

    /** 版本 */
    private Long version;

    /** 公司uuid */
    private String companyUuid;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("tempName", getTempName())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("companyUuid", getCompanyUuid())
            .append("companyName", getCompanyName())
            .toString();
    }
}
