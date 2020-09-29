package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 报表定义对象 report_define
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class ReportDefine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 行业类型 */
    @Excel(name = "行业类型")
    private String industryType;

    /** 报表名称 */
    @Excel(name = "报表名称")
    private String reportName;

    /** 模版名称 */
    @Excel(name = "模版名称")
    private String tagTemplateName;

    /** 模版uuid */
    private String tagTemplateUuid;

    /** 填报周期 */
    @Excel(name = "填报周期")
    private String cycle;

    /** 填报时间 */
    @Excel(name = "填报时间")
    private String startTime;

    /** 截至时间 */
    @Excel(name = "截至时间")
    private String endTime;

    /** 版本 */
    @Excel(name = "版本")
    private Long version;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司uuid */
    private String companyUuid;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("industryType", getIndustryType())
            .append("reportName", getReportName())
            .append("tagTemplateName", getTagTemplateName())
            .append("tagTemplateUuid", getTagTemplateUuid())
            .append("cycle", getCycle())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("companyName", getCompanyName())
            .append("companyUuid", getCompanyUuid())
            .toString();
    }
}
