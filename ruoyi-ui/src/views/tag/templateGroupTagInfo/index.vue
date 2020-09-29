<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="模版" prop="tempUuid">
        <el-select v-model="queryParams.tempUuid" placeholder="请选择模版" clearable size="small">
          <el-option
            v-for="dict in tempUuidOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="分组" prop="groupUuid">
        <el-input
          v-model="queryParams.groupUuid"
          placeholder="请输入分组"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="指标数据类型" prop="dataType">
        <el-select v-model="queryParams.dataType" placeholder="请选择指标数据类型" clearable size="small">
          <el-option
            v-for="dict in dataTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="填报指标单位" prop="tagUnit">
        <el-select v-model="queryParams.tagUnit" placeholder="请选择填报指标单位" clearable size="small">
          <el-option
            v-for="dict in tagUnitOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="填报类型(指标值，平均值，最大值，最小值 随意组合)" prop="fillType">
        <el-select v-model="queryParams.fillType" placeholder="请选择填报类型(指标值，平均值，最大值，最小值 随意组合)" clearable size="small">
          <el-option label="请选择字典生成" value="" />
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
          v-hasPermi="['tag:templateGroupTagInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tag:templateGroupTagInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tag:templateGroupTagInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tag:templateGroupTagInfo:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="templateGroupTagInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增id" align="center" prop="id" />
      <el-table-column label="分组" align="center" prop="groupUuid" />
      <el-table-column label="指标名称" align="center" prop="tagName" />
      <el-table-column label="指标数据类型" align="center" prop="dataType" :formatter="dataTypeFormat" />
      <el-table-column label="填报指标单位" align="center" prop="tagUnit" :formatter="tagUnitFormat" />
      <el-table-column label="填报类型(指标值，平均值，最大值，最小值 随意组合)" align="center" prop="fillType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tag:templateGroupTagInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tag:templateGroupTagInfo:remove']"
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

    <!-- 添加或修改分组指标详情对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="分组" prop="groupUuid">
          <el-input v-model="form.groupUuid" placeholder="请输入分组" />
        </el-form-item>
        <el-form-item label="指标名称" prop="tagName">
          <el-input v-model="form.tagName" placeholder="请输入指标名称" />
        </el-form-item>
        <el-form-item label="指标数据类型" prop="dataType">
          <el-select v-model="form.dataType" placeholder="请选择指标数据类型">
            <el-option
              v-for="dict in dataTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="填报指标单位" prop="tagUnit">
          <el-select v-model="form.tagUnit" placeholder="请选择填报指标单位">
            <el-option
              v-for="dict in tagUnitOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="指标别名，填报时显示" prop="fillTagName">
          <el-input v-model="form.fillTagName" placeholder="请输入指标别名，填报时显示" />
        </el-form-item>
        <el-form-item label="填报类型(指标值，平均值，最大值，最小值 随意组合)" prop="fillType">
          <el-select v-model="form.fillType" placeholder="请选择填报类型(指标值，平均值，最大值，最小值 随意组合)">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="排序" prop="排序">
          <el-input v-model="form.排序" placeholder="请输入排序" />
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
  import {
    addTemplateGroupTagInfo,
    delTemplateGroupTagInfo,
    exportTemplateGroupTagInfo,
    getTemplateGroupTagInfo,
    listTemplateGroupTagInfo,
    updateTemplateGroupTagInfo
  } from "@/api/tag/templateGroupTagInfo";

  export default {
  name: "TemplateGroupTagInfo",
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
      // 分组指标详情表格数据
      templateGroupTagInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 模版字典
      tempUuidOptions: [],
      // 指标数据类型字典
      dataTypeOptions: [],
      // 填报指标单位字典
      tagUnitOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tempUuid: null,
        groupUuid: null,
        dataType: null,
        tagUnit: null,
        fillType: null,
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
    this.getDicts("sys_user_sex").then(response => {
      this.tempUuidOptions = response.data;
    });
    this.getDicts("tag_data_type").then(response => {
      this.dataTypeOptions = response.data;
    });
    this.getDicts("sys_show_hide").then(response => {
      this.tagUnitOptions = response.data;
    });
  },
  methods: {
    /** 查询分组指标详情列表 */
    getList() {
      this.loading = true;
      listTemplateGroupTagInfo(this.queryParams).then(response => {
        this.templateGroupTagInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 模版字典翻译
    tempUuidFormat(row, column) {
      return this.selectDictLabel(this.tempUuidOptions, row.tempUuid);
    },
    // 指标数据类型字典翻译
    dataTypeFormat(row, column) {
      return this.selectDictLabel(this.dataTypeOptions, row.dataType);
    },
    // 填报指标单位字典翻译
    tagUnitFormat(row, column) {
      return this.selectDictLabel(this.tagUnitOptions, row.tagUnit);
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
        tempUuid: null,
        groupUuid: null,
        tagName: null,
        tagUuid: null,
        dataType: null,
        tagUnit: null,
        fillTagName: null,
        fillType: null,
        排序: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        version: null
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
      this.title = "添加分组指标详情";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTemplateGroupTagInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改分组指标详情";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTemplateGroupTagInfo(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addTemplateGroupTagInfo(this.form).then(response => {
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
      this.$confirm('是否确认删除分组指标详情编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTemplateGroupTagInfo(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有分组指标详情数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTemplateGroupTagInfo(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
