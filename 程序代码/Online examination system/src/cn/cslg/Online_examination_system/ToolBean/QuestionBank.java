package cn.cslg.Online_examination_system.ToolBean;

import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-21
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class QuestionBank {
	private int questionBankID;
	private String questionBankName;

	/**
	 * @param questionBankName 题库名
	 * @function 非全参构造方法
	 * 		用于在用户添加题库时构造一个题库对象
	 * */
	public QuestionBank(String questionBankName) {
		this.questionBankID = -1;
		this.questionBankName = questionBankName;
	}

	public QuestionBank(int questionBankID,  String questionBankName) {
		this.questionBankID = questionBankID;
		this.questionBankName = questionBankName;
	}

	public int getQuestionBankID() {
		return this.questionBankID;
	}

	public String getQuestionBankName() {
		return this.questionBankName;
	}

	/**
	 * @return isSuccess 删除成功与否
	 * @function 删除当前题库内所有的问题
	 * 		1.依据题库ID查询所有的题目
	 * 		2.依次删除所有的题目
	 * 		3.处理返回
	 * */
	public boolean deleteAllQuestion() {
		boolean isSuccess = true;
		InterfaceDatabaseProxy interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
		ArrayList<Question> questions = interfaceDatabaseProxy.queryAllQuestion(questionBankID);
		for(int i = 0; i < questions.size(); ++i) {
			isSuccess = isSuccess & interfaceDatabaseProxy.deleteQuestion(questions.get(i).getQuestionID());
		}
		return isSuccess;
	}

}