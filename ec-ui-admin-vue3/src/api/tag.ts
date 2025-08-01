import type {TagAddDTO, TagDO, TagQueryDTO, TagUpdateDTO} from "@/types/tag";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

export function addTag(tagAddDTO: TagAddDTO) {
    return request<string>({
        url: '/admin-api/tag',
        method: 'post',
        data: tagAddDTO
    })
}

export function getTagPage(tagQueryDTO: TagQueryDTO) {
    return request<CommonPage<TagDO>>({
        url: '/admin-api/tag/list',
        method: 'post',
        data: tagQueryDTO
    })
}

/* 批量删除标签 */
export function removeTags(tagIds: string | Array<string>) {
    return request({
        url: '/admin-api/tag/' + tagIds,
        method: 'delete'
    })
}

/* 根据id查询标签 */
export function getTag(tagId: string) {
    return request<TagDO>({
        url: '/admin-api/tag/' + tagId,
        method: 'get'
    })
}

/* 根据id修改标签信息 */
export function updateTag(tagUpdateDTO: TagUpdateDTO) {
    return request({
        url: '/admin-api/tag',
        method: 'put',
        data: tagUpdateDTO
    })
}