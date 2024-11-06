"use client";
import { AntdRegistry } from "@ant-design/nextjs-registry";
import BasicLayout from "@/layouts/BasicLayout";
import React, { useCallback, useEffect } from "react";
import { Provider, useDispatch } from "react-redux";
import store, { AppDispatch } from "@/stores";
import { getLoginUserUsingGet } from "@/api/userController";
import { setLoginUser } from "@/stores/loginUser";

/**
 * 全局初始化逻辑
 * @param children
 * @constructor
 */
const InitLayout: React.FC<Readonly<{
    children: React.ReactNode;
}>> = ({children}) => {
    const dispatch = useDispatch<AppDispatch>();

    // 初始化全局用户状态
    const doInitLoginUser = useCallback(async () => {
        const res = await getLoginUserUsingGet();
        console.log("res", res)
        if (res.data) {
            // 更新全局用户状态
            dispatch(setLoginUser(res.data));
        } else {
            // 仅用于测试
            // setTimeout(() => {
            //     const testUser = {
            //         userName: "测试登录",
            //         id: 1,
            //         userAvatar: "https://hmleadnews5283.oss-cn-beijing.aliyuncs.com/07f5bf4c-fc23-44c1-b365-6c2fd47a412d.jpg",
            //         userRole: "admin"
            //     };
            //     dispatch(setLoginUser(testUser));
            // }, 3000);
        }
    }, []);

    useEffect(() => {
        doInitLoginUser();
    }, []);

    return <>{children}</>;
};

export default function RootLayout({
                                       children,
                                   }: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="zh">
        <body>
        <AntdRegistry>
            <Provider store={store}>
                <InitLayout>
                    <BasicLayout>
                        {children}
                    </BasicLayout>
                </InitLayout>
            </Provider>
        </AntdRegistry>
        </body>
        </html>
    );
}
