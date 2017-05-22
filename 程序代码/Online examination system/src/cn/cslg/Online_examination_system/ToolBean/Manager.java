package cn.cslg.Online_examination_system.ToolBean;

import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-21
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Manager extends User {
	public Manager(int userID, int gradeID, String username, String password, String identity) {
		super(userID, gradeID, username, password, identity);
	}

	public ArrayList<Teacher> querryAllTeacher() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllTeacher();
	}

	public ArrayList<Student> querryAllStudent() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllStudent();
	}

	public ArrayList<Course> querryAllCourse() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllCourse();
	}

	public ArrayList<Grade> querryAllGrade() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllGrade();
	}

	public ArrayList<QuestionBank> querryAllQuestionBank() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllQuestionBank();
	}

	public ArrayList<Question> querryAllQuestion() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllQuestion();
	}
	
	public ArrayList<Exam> querryAllExam() {
        return new DatabaseProxyFactory().getDatabaseProxy("MySQL").queryAllExam();
	}
}