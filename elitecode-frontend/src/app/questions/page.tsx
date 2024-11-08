import Title from "antd/es/typography/Title";
import { listQuestionVoByPageUsingPost } from "@/api/questionController";
import "./index.css";
import QuestionTable from "@/components/QuestionTable";

/**
 * 题目列表页面
 * @constructor
 */
export default async function QuestionsPage({ searchParams }) {
  const { q: searchText } = searchParams;
  let questionList = [];
  let total = 0;

  try {
    const questionRes = await listQuestionVoByPageUsingPost({
      title: searchText,
      pageSize: 12,
      sortField: "create_time",
      sortOrder: "descend",
    });
    questionList = questionRes.data.records ?? [];
    total = questionRes.data.total ?? 0;
  } catch (e) {
    console.error("获取题目列表失败，" + e.message);
  }

  return (
      <div id="questionsPage" className="max-width-content">
        <Title level={3}>题目大全</Title>
        <QuestionTable defaultQuestionList={questionList} defaultTotal={total} defaultSearchParams={{
          title: searchText,
        }} />
      </div>
  );
}
