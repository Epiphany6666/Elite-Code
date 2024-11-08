"use client";
import { Avatar, Card, List, Typography } from "antd";
import "./index.css";
import Link from "next/link";

interface Props {
    questionBankList: API.QuestionBankVO[];
}

/**
 * 题库列表组件
 * @param props
 * @constructor
 */
const QuestionBankList = (props: Props) => {
    const { questionBankList = [] } = props;

    return (
        <div className="question-bank-list">
            <List
                grid={{
                    gutter: 16,
                    column: 4,
                    xs: 1,
                    sm: 2,
                    md: 3,
                    lg: 3,
                }}
                dataSource={questionBankList}
                renderItem={(item: API.QuestionBankVO) => (
                    <List.Item>
                        <Card>
                            <Link href={`/bank/${item.id}`}>
                                <Card.Meta
                                    avatar={<Avatar src={item.picture} />}
                                    title={item.title}
                                    description={
                                        <Typography.Paragraph
                                            type="secondary"
                                            ellipsis={{ rows: 1 }}
                                            style={{ marginBottom: 0 }}
                                        >
                                            {item.description}
                                        </Typography.Paragraph>
                                    }
                                />
                            </Link>
                        </Card>
                    </List.Item>
                )}
            />
        </div>
    );
};

export default QuestionBankList;
