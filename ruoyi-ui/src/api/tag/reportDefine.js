import request from '@/utils/request'

// 查询报表定义列表
export function listReportDefine(query) {
  return request({
    url: '/tag/reportDefine/list',
    method: 'get',
    params: query
  })
}

// 查询报表定义详细
export function getReportDefine(id) {
  return request({
    url: '/tag/reportDefine/' + id,
    method: 'get'
  })
}

// 新增报表定义
export function addReportDefine(data) {
  return request({
    url: '/tag/reportDefine',
    method: 'post',
    data: data
  })
}

// 修改报表定义
export function updateReportDefine(data) {
  return request({
    url: '/tag/reportDefine',
    method: 'put',
    data: data
  })
}

// 删除报表定义
export function delReportDefine(id) {
  return request({
    url: '/tag/reportDefine/' + id,
    method: 'delete'
  })
}

// 导出报表定义
export function exportReportDefine(query) {
  return request({
    url: '/tag/reportDefine/export',
    method: 'get',
    params: query
  })
}