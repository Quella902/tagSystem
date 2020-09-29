import request from '@/utils/request'

// 查询指标类型列表
export function listTagType(query) {
  return request({
    url: '/tag/tagType/list',
    method: 'get',
    params: query
  })
}

// 查询指标类型详细
export function getTagType(id) {
  return request({
    url: '/tag/tagType/' + id,
    method: 'get'
  })
}

// 新增指标类型
export function addTagType(data) {
  return request({
    url: '/tag/tagType',
    method: 'post',
    data: data
  })
}

// 修改指标类型
export function updateTagType(data) {
  return request({
    url: '/tag/tagType',
    method: 'put',
    data: data
  })
}

// 删除指标类型
export function delTagType(id) {
  return request({
    url: '/tag/tagType/' + id,
    method: 'delete'
  })
}

// 导出指标类型
export function exportTagType(query) {
  return request({
    url: '/tag/tagType/export',
    method: 'get',
    params: query
  })
}

//查看指标类型树结构数据
export function tagTypeTreeData() {
  return request({
    url: '/tag/tagType/getTreeData',
    method: 'get',
  })
}

