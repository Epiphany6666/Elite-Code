'use client';
import { Avatar, Layout, Menu, theme } from 'antd';
import Dropdown from 'antd/es/dropdown/dropdown';
import Image from 'next/image';
import React from 'react';
import './index.css';

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
      <Header
        style={{
          display: 'flex',
          alignItems: 'center',
          borderBlockEnd: '1px solid rgba(5, 5, 5, 0.06)',
        }}
      >
        <div style={{ display: 'flex', alignItems: 'center' }}>
          <Image src="/assets/logo.png" alt="logo" width={40} height={40} />
          <span style={{ marginLeft: '5px' }}>易扣</span>
        </div>
        <Menu
          theme="light"
          mode="horizontal"
          defaultSelectedKeys={['2']}
          items={items}
          style={{ flex: 1, minWidth: 0 }}
        />
        <Dropdown menu={{ items }} placement="bottomRight">
          <div>
            <Avatar
              src={
                <Image
                  src="/assets/notLoginUser.png"
                  alt="avatar"
                  width={40}
                  height={40}
                />
              }
            />
            <span
              style={{
                marginInlineStart: '8px',
                color: 'rgba(0, 0, 0, 0.45)',
              }}
            >
              洛言
            </span>
          </div>
        </Dropdown>
      </Header>
      <Content>
        <div
          style={{
            background: colorBgContainer,
            minHeight: 280,
            padding: '0px 40px 32px',
          }}
        >
          {children}
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>
        Eliete-Code ©{new Date().getFullYear()} Created by 洛言
      </Footer>
    </Layout>
  );
}
