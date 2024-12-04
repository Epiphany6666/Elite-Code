'use client';
import React from 'react';
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import Image from 'next/image';

const { Header, Content, Footer } = Layout;

const items = new Array(3).fill(null).map((_, index) => ({
  key: index + 1,
  label: `nav ${index + 1}`,
}));

interface props {
  children: React.ReactNode;
}

export default function BasicLayout({ children }: props) {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  return (
    <Layout>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div
          className="demo-logo"
          style={{ display: 'flex', alignItems: 'center' }}
        >
          <Image src="/assets/logo.png" alt="logo" width={40} height={40} />
          <span style={{ color: 'red', marginLeft: '5px' }}>
            易扣面试刷题平台
          </span>
        </div>
        <Menu
          theme="light"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          items={items}
          style={{ flex: 1, minWidth: 0 }}
        />
      </Header>
      <Content style={{ padding: '0 48px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>Home</Breadcrumb.Item>
          <Breadcrumb.Item>List</Breadcrumb.Item>
          <Breadcrumb.Item>App</Breadcrumb.Item>
        </Breadcrumb>
        <div
          style={{
            background: colorBgContainer,
            minHeight: 280,
            padding: 24,
            borderRadius: borderRadiusLG,
          }}
        >
          {children}
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>
        Eliete-Code面试刷题平台 ©{new Date().getFullYear()} Created by 洛言
      </Footer>
    </Layout>
  );
}
