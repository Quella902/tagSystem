import request from '@/utils/request'

// 查询指标定义列表
export function listTagDefine(query) {
  return request({
    url: '/tag/tagDefine/list',
    method: 'get',
    params: query
  })
}

// 查询指标定义详细
export function getTagDefine(id) {
  return request({
    url: '/tag/tagDefine/' + id,
    method: 'get'
  })
}

// 新增指标定义
export function addTagDefine(data) {
  return request({
    url: '/tag/tagDefine',
    method: 'post',
    data: data
  })
}

// 修改指标定义
export function updateTagDefine(data) {
  return request({
    url: '/tag/tagDefine',
    method: 'put',
    data: data
  })
}

// 删除指标定义
export function delTagDefine(id) {
  return request({
    url: '/tag/tagDefine/' + id,
    method: 'delete'
  })
}

// 导出指标定义
export function exportTagDefine(query) {
  return request({
    url: '/tag/tagDefine/export',
    method: 'get',
    params: query
  })
}

export function tagTreeData() {
  return request({
    url: '/tag/tagDefine/getTagTreeData',
    method: 'get'
  })
}
