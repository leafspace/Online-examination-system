package cn.cslg.Online_examination_system.ToolBean;

import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Course {
	private int courseID;
	private String courseName;
	private String courseInformation;

	public Course(int courseID, String courseName, String courseInformation) {
	    this.courseID = courseID;
	    this.courseName = courseName;
	    this.courseInformation = courseInformation;
    }

	public int getCourseID() {
		return this.courseID;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public String getCourseInformation() {
		return this.courseInformation;
	}

	/**
     * @return 删除题库的成功与否（注：包含删除题库中的所有题目，且本方法依赖于QuestionBank中的deleteAllQuestion方法）
     * @funtion
     *      1.获取数据库代理
     *      2.查询出本课程所有的题库
     *      3.依次删除所有题库内的题目+本题库信息
     *      4.处理返回
     * */
	public boolean deleteAllQuestionBank() {
	    boolean isSuccess = true;
        InterfaceDatabaseProxy interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
        ArrayList<QuestionBank> questionBanks = interfaceDatabaseProxy.queryAllQuestionBank(this.courseID);
        for(int i = 0; i < questionBanks.size(); ++i) {
            isSuccess = isSuccess & questionBanks.get(i).deleteAllQuestion();                      //删除第i个题库当中的所有题目
            isSuccess = isSuccess & interfaceDatabaseProxy.deleteQuestionBank(questionBanks.get(i).getQuestionBankID());//删除第i个题库的题库信息
        }
		return isSuccess;
	}
}