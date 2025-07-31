import request from "@/utils/request.ts";

export function upload(formData) {
    return request({
        url: '/admin-api/minio/upload',
        method: 'post',
        data: formData
    })
}