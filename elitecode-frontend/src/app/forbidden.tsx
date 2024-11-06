import { Result, Button } from "antd";
import React from "react";

/**
 * 无权限访问的页面
 * @constructor
 */
const Forbidden = () => {
    return (
        <Result
            status="403"
            title="403"
            subTitle="抱歉，您无权访问此页面。 "
            extra={
                <Button type="primary" href="/">
                    返回主页
                </Button>
            }
        />
    );
};

export default Forbidden;
