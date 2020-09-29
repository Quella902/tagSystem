<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="行业类型" prop="industryType">
        <el-select v-model="queryParams.industryType" placeholder="请选择行业类型" clearable size="small">
          <el-option
            v-for="dict in industryTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="报表名称" prop="reportName">
        <el-input
          v-model="queryParams.reportName"
          placeholder="请输入报表名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="模版名称" prop="tagTemplateName">
        <el-select v-model="queryParams.tagTemplateName" placeholder="请选择模版名称" clearable size="small">
          <el-option
            v-for="dict in tagTemplateNameOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="填报周期" prop="cycle">
        <el-input
          v-model="queryParams.cycle"
          placeholder="请输入填报周期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="填报时间" prop="startTime">
        <el-input
          v-model="queryParams.startTime"
          placeholder="请输入填报时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="截至时间" prop="endTime">
        <el-input
          v-model="queryParams.endTime"
          placeholder="请输入截至时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="版本" prop="version">
        <el-input
          v-model="queryParams.version"
          placeholder="请输入版本"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名称" prop="companyName">
        <el-select v-model="queryParams.companyName" placeholder="请选择公司名称" clearable size="small">
          <el-option
            v-for="dict in companyNameOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['tag:reportDefine:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tag:reportDefine:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tag:reportDefine:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tag:reportDefine:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reportDefineList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增id" align="center" prop="id" />
      <el-table-column label="行业类型" align="center" prop="industryType" :formatter="industryTypeFormat" />
      <el-table-column label="报表名称" align="center" prop="reportName" />
      <el-table-column label="模版名称" align="center" prop="tagTemplateName" :formatter="tagTemplateNameFormat" />
      <el-table-column label="填报周期" align="center" prop="cycle" />
      <el-table-column label="填报时间" align="center" prop="startTime" />
      <el-table-column label="截至时间" align="center" prop="endTime" />
      <el-table-column label="版本" align="center" prop="version" />
      <el-table-column label="公司名称" align="center" prop="companyName" :formatter="companyNameFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tag:reportDefine:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tag:reportDefine:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改报表定义对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="行业类型" prop="industryType">
          <el-select v-model="form.industryType" placeholder="请选择行业类型">
            <el-option
              v-for="dict in industryTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="报表名称" prop="reportName">
          <el-input v-model="form.reportName" placeholder="请输入报表名称" />
        </el-form-item>
        <el-form-item label="模版名称" prop="tagTemplateName">
          <el-select v-model="form.tagTemplateName" placeholder="请选择模版名称">
            <el-option
              v-for="dict in tagTemplateNameOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="填报周期" prop="cycle">
          <el-input v-model="form.cycle" placeholder="请输入填报周期" />
        </el-form-item>
        <el-form-item label="填报时间" prop="startTime">
          <el-input v-model="form.startTime" placeholder="请输入填报时间" />
        </el-form-item>
        <el-form-item label="截至时间" prop="endTime">
          <el-input v-model="form.endTime" placeholder="请输入截至时间" />
        </el-form-item>
        <el-form-item label="版本" prop="version">
          <el-input v-model="form.version" placeholder="请输入版本" />
        </el-form-item>
        <el-form-item label="公司名称" prop="companyName">
          <el-select v-model="form.companyName" placeholder="请选择公司名称">
            <el-option
              v-for="dict in companyNameOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {addReportDefine, delReportDefine, exportReportDefine, getReportDefine, listReportDefine, updateReportDefine} from "@/api/tag/reportDefine";

  export default {
  name: "ReportDefine",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 报表定义表格数据
      reportDefineList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 行业类型字典
      industryTypeOptions: [],
      // 模版名称字典
      tagTemplateNameOptions: [],
      // 公司名称字典
      companyNameOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        industryType: null,
        reportName: null,
        tagTemplateName: null,
        cycle: null,
        startTime: null,
        endTime: null,
        version: null,
        companyName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("tag_industry_type").then(response => {
      this.industryTypeOptions = response.data;
    });
    this.getDicts("sys_user_sex").then(response => {
      this.tagTemplateNameOptions = response.data;
    });
    this.getDicts("sys_user_sex").then(response => {
      this.companyNameOptions = response.data;
    });
  },
  methods: {
    /** 查询报表定义列表 */
    getList() {
      this.loading = true;
      listReportDefine(this.queryParams).then(response => {
        this.reportDefineList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 行业类型字典翻译
    industryTypeFormat(row, column) {
      return this.selectDictLabel(this.industryTypeOptions, row.industryType);
    },
    // 模版名称字典翻译
    tagTemplateNameFormat(row, column) {
      return this.selectDictLabel(this.tagTemplateNameOptions, row.tagTemplateName);
    },
    // 公司名称字典翻译
    companyNameFormat(row, column) {
      return this.selectDictLabel(this.companyNameOptions, row.companyName);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        uuid: null,
        industryType: null,
        reportName: null,
        tagTemplateName: null,
        tagTemplateUuid: null,
        cycle: null,
        startTime: null,
        endTime: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        version: null,
        companyName: null,
        companyUuid: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加报表定义";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getReportDefine(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改报表定义";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateReportDefine(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addReportDefine(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除报表定义编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delReportDefine(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有报表定义数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportReportDefine(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
