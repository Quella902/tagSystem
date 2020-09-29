package com.ruoyi.tag.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 指标数据源对象 tag_data_source
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Data
public class TagDataSource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增id */
    private Long id;

    /** 逻辑id */
    private String uuid;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String tagName;

    /** 指标uuid */
    private String tagUuid;

    /** 数据源类型（填报、接口、公式、其他表属性值） */
    @Excel(name = "数据源类型", readConverterExp = "填=报、接口、公式、其他表属性值")
    private String dataType;

    /** 公式/数据库-表-属性 */
    private String dataSource;

    /** 版本 */
    @Excel(name = "版本")
    private Long version;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("tagName", getTagName())
            .append("tagUuid", getTagUuid())
            .append("dataType", getDataType())
            .append("dataSource", getDataSource())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .toString();
    }
}
