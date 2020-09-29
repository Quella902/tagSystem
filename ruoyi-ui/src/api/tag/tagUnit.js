import request from '@/utils/request'

// 查询指标单位列表
export function listTagUnit(query) {
  return request({
    url: '/tag/tagUnit/list',
    method: 'get',
    params: query
  })
}

// 查询指标单位详细
export function getTagUnit(id) {
  return request({
    url: '/tag/tagUnit/' + id,
    method: 'get'
  })
}

// 新增指标单位
export function addTagUnit(data) {
  return request({
    url: '/tag/tagUnit',
    method: 'post',
    data: data
  })
}

// 修改指标单位
export function updateTagUnit(data) {
  return request({
    url: '/tag/tagUnit',
    method: 'put',
    data: data
  })
}

// 删除指标单位
export function delTagUnit(id) {
  return request({
    url: '/tag/tagUnit/' + id,
    method: 'delete'
  })
}

// 导出指标单位
export function exportTagUnit(query) {
  return request({
    url: '/tag/tagUnit/export',
    method: 'get',
    params: query
  })
}
// 根据单位类型获取指标单位
export function tagUnitList(tagTypeId) {
  return request({
    url: '/tag/tagUnit/getUnitListByTypeId/' + tagTypeId,
    method: 'get',
  })

}
