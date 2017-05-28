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
	public Student(String username, String password, String identity) {
		super(username, password, identity);
	}

	public Student(int userID, int gradeID, String username, String password, String identity) {
		super(userID, gradeID, username, password, identity);
	}

    public Exam queryExam(int examID) {
        return this.interfaceDatabaseProxy.queryExam(examID);
    }

	public ArrayList<Exam> queryAllExam() {
		return this.interfaceDatabaseProxy.queryAllExam(this.getGradeID());
	}

	public StudentScore queryStudentScore(int examID) {
	    return this.interfaceDatabaseProxy.queryStudentScoreObject(examID, this.userID);
    }
}