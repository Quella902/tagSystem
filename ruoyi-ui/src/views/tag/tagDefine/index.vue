<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="110px">
      <el-form-item label="指标名称" prop="tagName">
        <el-input
          v-model="queryParams.tagName"
          placeholder="请输入指标名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="父指标名称" prop="parentName">
        <el-input
          v-model="queryParams.parentName"
          placeholder="请输入父指标名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据类型" prop="dataType">
        <el-select v-model="queryParams.dataType" placeholder="请选择数据类型" clearable size="small">
          <el-option
            v-for="dict in dataTypeOptions"
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
          v-hasPermi="['tag:tagDefine:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tag:tagDefine:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tag:tagDefine:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tag:tagDefine:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tagDefineList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="指标名称" align="center" prop="tagName" />
      <el-table-column label="指标类型名称" align="center" prop="typeName" :formatter="typeNameFormat" />
      <el-table-column label="父指标名称" align="center" prop="parentName" />
      <el-table-column label="数据类型" align="center" prop="dataType" :formatter="dataTypeFormat" />
      <el-table-column label="单位类型" align="center" prop="unitTypeName" :formatter="unitTypeNameFormat" />
      <el-table-column label="默认单位" align="center" prop="unitNameDefault"  />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tag:tagDefine:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tag:tagDefine:remove']"
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

    <!-- 添加或修改指标定义对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指标名称" prop="tagName">
          <el-input v-model="form.tagName" placeholder="请输入指标名称" />
        </el-form-item>
        <el-form-item label="父指标" prop="parentUuid">
          <treeselect v-model="form.parentUuid" :options="tagTreeOptions" :searchable="true" placeholder="请选择父指标"
                      @select="getTagName" :beforeClearAll="clearParentTagName" />
        </el-form-item>
        <el-form-item label="指标类型名称" prop="typeName">
          <el-input v-model="form.typeName" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单位类型" prop="unitTypeName">
          <el-select v-model="form.unitTypeName" clearable placeholder="请选择单位类型" @change="getUnitList">
            <el-option
              v-for="dict in unitTypeNameOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="默认单位" prop="unitNameDefault">
          <el-select v-model="form.unitUuidDefault" clearable  placeholder="请选择默认单位" @onchange="setTagUnitName">
            <el-option
              v-for="unit in tagUnitOptions"
              :key="unit.id"
              :label="unit.unitName"
              :value="unit.uuid"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数据类型" prop="dataType">
          <el-select v-model="form.dataType" clearable  placeholder="请选择数据类型">
            <el-option
              v-for="dict in dataTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
  import {addTagDefine, delTagDefine, exportTagDefine, getTagDefine, tagTreeData, listTagDefine, updateTagDefine} from "@/api/tag/tagDefine";
  import {tagUnitList} from "@/api/tag/tagUnit"
  import Treeselect from "@riophae/vue-treeselect";
  import "@riophae/vue-treeselect/dist/vue-treeselect.css";

  export default {
  name: "TagDefine",
  components: { Treeselect },
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
      // 指标定义表格数据
      tagDefineList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 指标类型名称字典
      typeNameOptions: [],
      // 单位类型名称字典
      unitTypeNameOptions: [],
      // 数据类型字典
      dataTypeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tagName: null,
        typeName: null,
        parentName: null,
        unitTypeName: null,
        unitNameDefault: null,
        dataType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 指标树结构数据
      tagTreeOptions: [],
      defaultProps: {
        children: "children",
        label: "label",
      },
      // 单位列表
      tagUnitOptions: [],

    };
  },
  created() {
    this.getList();
    this.getDicts("sys_show_hide").then(response => {
      this.typeNameOptions = response.data;
    });
    this.getDicts("tag_unit_type").then(response => {
      this.unitTypeNameOptions = response.data;
    });
    this.getDicts("tag_data_type").then(response => {
      this.dataTypeOptions = response.data;
    });
    this.getTagTreeData();
  },
  methods: {
    /** 查询指标定义列表 */
    getList() {
      this.loading = true;
      listTagDefine(this.queryParams).then(response => {
        this.tagDefineList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 指标类型名称字典翻译
    typeNameFormat(row, column) {
      return this.selectDictLabel(this.typeNameOptions, row.typeName);
    },
    // 单位类型名称字典翻译
    unitTypeNameFormat(row, column) {
      return this.selectDictLabel(this.unitTypeNameOptions, row.unitTypeName);
    },
    // 数据类型字典翻译
    dataTypeFormat(row, column) {
      return this.selectDictLabel(this.dataTypeOptions, row.dataType);
    },
    // 获取指标tree 结构数据
    getTagTreeData() {
      tagTreeData().then((response) => {
        this.tagTreeOptions = response.data;
      });
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
        tagName: null,
        typeUuid: null,
        typeName: null,
        parentUuid: null,
        parentName: null,
        remark: null,
        unitTypeName: null,
        unitTypeUuid: null,
        unitNameDefault: null,
        unitUuidDefault: null,
        dataTypeUuid: null,
        dataType: null,
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
      this.title = "添加指标定义";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTagDefine(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改指标定义";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTagDefine(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addTagDefine(this.form).then(response => {
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
      this.$confirm('是否确认删除指标定义编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTagDefine(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有指标定义数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTagDefine(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    },
    getTagName(val){
      console.log(val)
      this.form.parentName = val.label;
    },
    clearParentTagName(){
      this.form.parentUuid = null;
      this.form.parentName = null;
      console.log(this.form)
      return true;
    },
    getUnitList(tagTypeId){
      tagUnitList(tagTypeId).then((response) =>{
        this.tagUnitOptions = response.data;
      })
    },
    setTagUnitName(val){
      this.form.unitNameDefault = val.unitName;
    }
  }
};
</script>
