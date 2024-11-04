"use client";

import {GithubFilled, LogoutOutlined, SearchOutlined,} from '@ant-design/icons';
import {ProLayout,} from '@ant-design/pro-components';
import {Dropdown, Input,} from  'antd';
import React from 'react';
import Image from "next/image";
import {usePathname} from "next/navigation";
import Link from "next/link";
import GlobalFooter from "@/components/GlobalFooter";
import './index.css'

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
                    src: 'https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg',
                    size: 'small',
                    title: '洛言',
                    render: (props, dom) => {
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
                    const defaultDom = (
                        <a>
                            {logo}
                            {title}
                        </a>
                    );
                    if (typeof window === 'undefined') return defaultDom;
                    if (document.body.clientWidth < 1400) {
                        return defaultDom;
                    }
                    if (_.isMobile) return defaultDom;
                    return (
                        <>
                            {defaultDom}
                        </>
                    );
                }}
                // 渲染底部栏
                footerRender={() => {
                    return <GlobalFooter/>;
                }}
                onMenuHeaderClick={(e) => console.log(e)}
                // 定义有哪些菜单
                menuDataRender={() => {
                    return [
                        {
                            path: "/questions",
                            name: "题目"
                        },
                        {
                            path: "/banks",
                            name: "题库"
                        },
                    ]
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