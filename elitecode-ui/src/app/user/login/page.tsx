'use client';
import type { FormProps } from 'antd';
import { Button, Form, Input } from 'antd';
import axios from 'axios';
import React from 'react';

type FieldType = {
  userAccount?: string;
  userPassword?: string;
};

const onFinish: FormProps<FieldType>['onFinish'] = (values) => {
  console.log('Success:', values);
  axios({
    method: 'post',
    url: 'http://localhost:8901/user/login',
    data: values,
  })
    .then((res) => {
      console.log('res======', res);

      alert('登陆成功');
    })
    .catch(() => {
      alert('登录失败');
    });
};

const onFinishFailed: FormProps<FieldType>['onFinishFailed'] = (errorInfo) => {
  console.log('Failed:', errorInfo);
};

const UserLoginPage: React.FC = () => (
  <Form
    name="basic"
    labelCol={{ span: 8 }}
    wrapperCol={{ span: 16 }}
    style={{ maxWidth: 600 }}
    initialValues={{ remember: true }}
    onFinish={onFinish}
    onFinishFailed={onFinishFailed}
    autoComplete="off"
  >
    <Form.Item<FieldType>
      label="Username"
      name="userAccount"
      rules={[{ required: true, message: 'Please input your userAccount!' }]}
    >
      <Input />
    </Form.Item>

    <Form.Item<FieldType>
      label="Password"
      name="userPassword"
      rules={[{ required: true, message: 'Please input your userPassword!' }]}
    >
      <Input.Password />
    </Form.Item>

    <Form.Item label={null}>
      <Button type="primary" htmlType="submit">
        Submit
      </Button>
    </Form.Item>
  </Form>
);

export default UserLoginPage;
