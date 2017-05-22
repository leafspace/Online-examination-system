package cn.cslg.Online_examination_system.ToolBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-21
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Student extends User {
	public Student(int userID, int gradeID, String username, String password, String identity) {
		super(userID, gradeID, username, password, identity);


	}

	/**
     * @funtion 创建一个无序的试卷
     *
     * */
	public void createExamPaper() {
		// TODO implement here
	}

	/**
     * @return score 试卷评分
     * @function 提交试卷并评分
     * */
	public double submitExamPaper(ArrayList<Question> question_list) {
		// TODO implement here
        return 0;
	}

}