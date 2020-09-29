package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分组指标详情对象 template_group_tag_info
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TemplateGroupTagInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 模版 */
    private String tempUuid;

    /** 分组 */
    @Excel(name = "分组")
    private String groupUuid;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String tagName;

    /** 指标 */
    private String tagUuid;

    /** 指标数据类型 */
    @Excel(name = "指标数据类型")
    private String dataType;

    /** 填报指标单位 */
    @Excel(name = "填报指标单位")
    private String tagUnit;

    /** 指标别名，填报时显示（例如：age(平均值/最大值)） */
    private String fillTagName;

    /** 填报类型(指标值，平均值，最大值，最小值 随意组合) */
    @Excel(name = "填报类型(指标值，平均值，最大值，最小值 随意组合)")
    private String fillType;

    /** 排序 */
    private Long 排序;

    /** 版本 */
    private Long version;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("tempUuid", getTempUuid())
            .append("groupUuid", getGroupUuid())
            .append("tagName", getTagName())
            .append("tagUuid", getTagUuid())
            .append("dataType", getDataType())
            .append("tagUnit", getTagUnit())
            .append("fillTagName", getFillTagName())
            .append("fillType", getFillType())
            .append("排序", get排序())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
