import request from '@/utils/request'

// 查询分组指标详情列表
export function listTemplateGroupTagInfo(query) {
  return request({
    url: '/tag/templateGroupTagInfo/list',
    method: 'get',
    params: query
  })
}

// 查询分组指标详情详细
export function getTemplateGroupTagInfo(id) {
  return request({
    url: '/tag/templateGroupTagInfo/' + id,
    method: 'get'
  })
}

// 新增分组指标详情
export function addTemplateGroupTagInfo(data) {
  return request({
    url: '/tag/templateGroupTagInfo',
    method: 'post',
    data: data
  })
}

// 修改分组指标详情
export function updateTemplateGroupTagInfo(data) {
  return request({
    url: '/tag/templateGroupTagInfo',
    method: 'put',
    data: data
  })
}

// 删除分组指标详情
export function delTemplateGroupTagInfo(id) {
  return request({
    url: '/tag/templateGroupTagInfo/' + id,
    method: 'delete'
  })
}

// 导出分组指标详情
export function exportTemplateGroupTagInfo(query) {
  return request({
    url: '/tag/templateGroupTagInfo/export',
    method: 'get',
    params: query
  })
}