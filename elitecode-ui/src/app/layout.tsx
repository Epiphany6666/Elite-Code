import React from 'react';
import { AntdRegistry } from '@ant-design/nextjs-registry';
import BasicLayout from '@/layouts/BasicLayout';

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <BasicLayout>
          <AntdRegistry>{children}</AntdRegistry>
        </BasicLayout>
      </body>
    </html>
  );
}
