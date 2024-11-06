import {MenuDataItem} from "@ant-design/pro-layout";
import {CrownOutlined} from "@ant-design/icons";
import ACCESS_ENUM from "@/app/access/accessEnum";

// 菜单列表
const menus = [
    {
        path: "/",
        name: "主页",
    },
    {
        path: "/banks",
        name: "题库",
    },
    {
        path: "/questions",
        name: "题目",
    },
    {
        name: "面试鸭",
        path: "https://mianshiya.com",
        target: "_blank",
    },
    {
        path: "/admin",
        name: "管理",
        icon: <CrownOutlined />,
        access: ACCESS_ENUM.ADMIN,
        children: [
            {
                path: "/admin/user",
                name: "用户管理",
                access: ACCESS_ENUM.ADMIN,
            },
        ],
    },,
] as MenuDataItem[];

// 导出
export default menus;
