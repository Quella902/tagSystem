<template>
  <div class="app-container">
    <!--部门数据-->
    <el-col :span="4" :xs="24">
      <div class="head-container">
        <el-input v-model="deptName" placeholder="请输入部门名称" clearable size="small" prefix-icon="el-icon-search" style="margin-bottom: 20px" />
      </div>
      <div class="head-container">
        <el-tree :data="deptOptions" :props="defaultProps" :expand-on-click-node="false" :filter-node-method="filterNode" ref="tree" default-expand-all @node-click="handleNodeClick" />
      </div>
    </el-col>
  </div>
</template>

<style>
</style>

<script>
  import * as dept from "@/api/system/dept";

  export default {
    data() {
      return {
        deptOptions: undefined,
        deptName: undefined,
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },
    created() {
      this.getTreeselect();
    },
    methods: {
      /** 查询部门下拉树结构 */
      getTreeselect() {
        dept.treeselect().then((response) => {
          this.deptOptions = response.data;
        });
      },
      // 筛选节点
      filterNode(value, data) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
      },
      // 节点单击事件
      handleNodeClick(data) {
        this.queryParams.deptId = data.id;
        this.getList();
      }
    }
  };
</script>
