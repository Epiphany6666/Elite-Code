"use client";

import {GithubFilled, LogoutOutlined, SearchOutlined,} from '@ant-design/icons';
import {ProLayout,} from '@ant-design/pro-components';
import {Dropdown, Input, message,} from 'antd';
import React, {useState} from 'react';
import Image from "next/image";
import {usePathname, useRouter} from "next/navigation";
import Link from "next/link";
import GlobalFooter from "/src/components/GlobalFooter";
import './index.css'
import menus from "../../../config/menus";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "@/stores";
import getAccessibleMenus from "@/access/menuAccess";
import MdViewer from "@/components/MdViewer";
import MdEditor from "@/components/MdEditor";
import {userLogoutUsingPost} from "@/api/userController";
import AccessEnum from "@/access/accessEnum";
import {setLoginUser} from "@/stores/loginUser";
import {DEFAULT_USER} from "@/constants/user";

/**
 * 搜索条
 * @constructor
 */
const SearchInput = () => {
    return (
        <div
            key="SearchOutlined"
            aria-hidden
            style={{
                display: 'flex',
                alignItems: 'center',
                marginInlineEnd: 24,
            }}
            onMouseDown={(e) => {
                e.stopPropagation();
                e.preventDefault();
            }}
        >
            <Input
                style={{
                    borderRadius: 4,
                    marginInlineEnd: 12,
                }}
                prefix={
                    <SearchOutlined
                        style={{}}
                    />
                }
                placeholder="搜索题目"
                variant="borderless"
            />
        </div>
    );
};

interface Props {
    children: React.ReactNode;
}

export default function BasicLayout({children}: Props) {
    const pathname: string = usePathname();
    // 当前登录用户
    const loginUser = useSelector((state: RootState) => state.loginUser);
    /**
     * 用户注销
     */
    const dispatch = useDispatch();
    const router = useRouter();
    const userLogout = async () => {
        try {
            await userLogoutUsingPost();
            message.success("已退出登录");
            dispatch(setLoginUser(DEFAULT_USER));
            router.push("/user/login");
        } catch (e) {
            message.error("操作失败，" + e.message);
        }
        return;
    }
    return (
        <div
            id="basicLayout"
            style={{
                height: '100vh',
                overflow: 'auto',
            }}
        >
            <ProLayout
                layout="top"
                title="易扣刷题平台"
                logo={
                    <Image src="/assets/logo.png" height={32} width={32} alt="易扣刷题平台 - 洛言"/>
                }
                location={{
                    pathname,
                }}
                avatarProps={{
                    src: loginUser.userAvatar || "/assets/logo.png",
                    size: "small",
                    title: loginUser.userName || "luoyan",
                    render: (props, dom) => {
                        if (!loginUser.id) {
                            return (
                                <div
                                    onClick={() => {
                                    router.push("/user/login");
                                }}
                                >
                                    {dom}
                                </div>
                            )
                        }
                        return (
                            <Dropdown
                                menu={{
                                    items: [
                                        {
                                            key: 'logout',
                                            icon: <LogoutOutlined/>,
                                            label: '退出登录',
                                        },
                                    ],
                                    onClick: async (event: { key: React.Key }) => {
                                        const { key } = event;
                                        // 退出登录
                                        if (key === "logout") {
                                            userLogout();
                                        }
                                    },
                                }}
                            >
                                {dom}
                            </Dropdown>
                        );
                    },
                }}
                actionsRender={(props) => {
                    if (props.isMobile) return [];
                    return [
                        <SearchInput key="search"/>,
                        <a key="github" href="https://github.com/Epiphany6666/Elite-Code" target="_blank">
                            <GithubFilled key="GithubFilled"/>
                        </a>,
                    ];
                }}
                headerTitleRender={(logo, title, _) => {
                    return (
                        <a>
                            {logo}
                            {title}
                        </a>
                    );
                }}
                // 渲染底部栏
                footerRender={() => {
                    return <GlobalFooter/>;
                }}
                onMenuHeaderClick={(e) => console.log(e)}
                // 定义有哪些菜单
                menuDataRender={() => {
                    return getAccessibleMenus(loginUser, menus);
                }}
                // 定义了菜单项如何渲染
                menuItemRender={(item, dom) => (
                    <Link href={item.path || "/"} target={item.target}>
                        {dom}
                    </Link>
                )}
            >
                {children}
            </ProLayout>
        </div>
    );
};
