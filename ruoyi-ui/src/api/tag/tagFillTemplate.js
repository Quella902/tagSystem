import request from '@/utils/request'

// 查询指标填报模版列表
export function listTagFillTemplate(query) {
  return request({
    url: '/tag/tagFillTemplate/list',
    method: 'get',
    params: query
  })
}

// 查询指标填报模版详细
export function getTagFillTemplate(id) {
  return request({
    url: '/tag/tagFillTemplate/' + id,
    method: 'get'
  })
}

// 新增指标填报模版
export function addTagFillTemplate(data) {
  return request({
    url: '/tag/tagFillTemplate',
    method: 'post',
    data: data
  })
}

// 修改指标填报模版
export function updateTagFillTemplate(data) {
  return request({
    url: '/tag/tagFillTemplate',
    method: 'put',
    data: data
  })
}

// 删除指标填报模版
export function delTagFillTemplate(id) {
  return request({
    url: '/tag/tagFillTemplate/' + id,
    method: 'delete'
  })
}

// 导出指标填报模版
export function exportTagFillTemplate(query) {
  return request({
    url: '/tag/tagFillTemplate/export',
    method: 'get',
    params: query
  })
}