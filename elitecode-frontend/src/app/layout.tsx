import localFont from "next/font/local";
import {AntdRegistry} from "@ant-design/nextjs-registry";
import BasicLayout from "@/layouts/BasicLayout";
import React from "react";
import "./globals.css";

const geistSans = localFont({
    src: "./fonts/GeistVF.woff",
    variable: "--font-geist-sans",
    weight: "100 900",
});
const geistMono = localFont({
    src: "./fonts/GeistMonoVF.woff",
    variable: "--font-geist-mono",
    weight: "100 900",
});

export default function RootLayout({
                                       children,
                                   }: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="zh">
        <body className={`${geistSans.variable} ${geistMono.variable}`}>
        <AntdRegistry>
            <BasicLayout>
                {children}
            </BasicLayout>
        </AntdRegistry>
        </body>
        </html>
    );
}
