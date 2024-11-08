"use server";
import Title from "antd/es/typography/Title";
import {Divider, Flex} from "antd";
import "./index.css";
import Link from "next/link";
import {listQuestionBankVoByPageUsingPost} from "@/api/questionBankController";
import {listQuestionVoByPageUsingPost} from "@/api/questionController";
import QuestionBankList from "@/components/QuestionBankList";
import QuestionList from "@/components/QuestionList";

/**
 * 主页
 * @constructor
 */
export default async function HomePage() {
  let questionBankList = [];
  let questionList = [];

  try {
    const questionBankRes = await listQuestionBankVoByPageUsingPost({
      pageSize: 12,
      sortField: 'create_time',
      sortOrder: 'descend',
    })
    questionBankList = questionBankRes.data.records ?? [];
  } catch (e) {
    console.error('获取题库列表失败，' + e.message);
  }

  try {
    const questionListRes = await listQuestionVoByPageUsingPost({
      pageSize: 12,
      sortField: 'create_time',
      sortOrder: 'descend',
    })
    questionList = questionListRes.data.records ?? [];
  } catch (e) {
    console.error('获取题目列表失败，' + e.message);
  }
  return <div id="homePage" className="max-width-content">
    <Flex justify="space-between" align="center">
      <Title level={3}>最新题库</Title>
      <Link href={"/banks"}>查看更多</Link>
    </Flex>
    <div>
      <QuestionBankList questionBankList={questionBankList}></QuestionBankList>
    </div>
    <Divider />
    <Flex justify="space-between" align="center">
      <Title level={3}>最新题目</Title>
      <Link href={"/questions"}>查看更多</Link>
    </Flex>
    <div>
      <QuestionList questionList={questionList}></QuestionList>
    </div>
  </div>;
}
