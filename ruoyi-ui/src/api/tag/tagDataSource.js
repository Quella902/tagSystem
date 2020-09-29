import request from '@/utils/request'

// 查询指标数据源列表
export function listTagDataSource(query) {
  return request({
    url: '/tag/tagDataSource/list',
    method: 'get',
    params: query
  })
}

// 查询指标数据源详细
export function getTagDataSource(id) {
  return request({
    url: '/tag/tagDataSource/' + id,
    method: 'get'
  })
}

// 新增指标数据源
export function addTagDataSource(data) {
  return request({
    url: '/tag/tagDataSource',
    method: 'post',
    data: data
  })
}

// 修改指标数据源
export function updateTagDataSource(data) {
  return request({
    url: '/tag/tagDataSource',
    method: 'put',
    data: data
  })
}

// 删除指标数据源
export function delTagDataSource(id) {
  return request({
    url: '/tag/tagDataSource/' + id,
    method: 'delete'
  })
}

// 导出指标数据源
export function exportTagDataSource(query) {
  return request({
    url: '/tag/tagDataSource/export',
    method: 'get',
    params: query
  })
}