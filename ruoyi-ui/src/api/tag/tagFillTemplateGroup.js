import request from '@/utils/request'

// 查询指标填报模版分组列表
export function listTagFillTemplateGroup(query) {
  return request({
    url: '/tag/tagFillTemplateGroup/list',
    method: 'get',
    params: query
  })
}

// 查询指标填报模版分组详细
export function getTagFillTemplateGroup(id) {
  return request({
    url: '/tag/tagFillTemplateGroup/' + id,
    method: 'get'
  })
}

// 新增指标填报模版分组
export function addTagFillTemplateGroup(data) {
  return request({
    url: '/tag/tagFillTemplateGroup',
    method: 'post',
    data: data
  })
}

// 修改指标填报模版分组
export function updateTagFillTemplateGroup(data) {
  return request({
    url: '/tag/tagFillTemplateGroup',
    method: 'put',
    data: data
  })
}

// 删除指标填报模版分组
export function delTagFillTemplateGroup(id) {
  return request({
    url: '/tag/tagFillTemplateGroup/' + id,
    method: 'delete'
  })
}

// 导出指标填报模版分组
export function exportTagFillTemplateGroup(query) {
  return request({
    url: '/tag/tagFillTemplateGroup/export',
    method: 'get',
    params: query
  })
}