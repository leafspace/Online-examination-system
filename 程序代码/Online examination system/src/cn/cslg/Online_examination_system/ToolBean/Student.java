package cn.cslg.Online_examination_system.ToolBean;

import java.util.ArrayList;
import java.util.Random;

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

	public ArrayList<Question> queryAllQuestion(int questionBankID) {
		return this.interfaceDatabaseProxy.queryAllQuestion(questionBankID);
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

    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public int[] randomOptions(String type) {
	    int[] randomNumber = null;
	    int allNumber = 0;
	    if(type.equals("OneChoice")) {
	        randomNumber = new int[4];
	        allNumber = 4;
        } else if(type.equals("MoreChoice")) {
            randomNumber = new int[5];
            allNumber = 5;
        }

        int alreadyNumber = 0;
        while(alreadyNumber != allNumber) {
	        int tempNumber = randomNumber(1, allNumber);
	        int i;
	        for(i = 0; i < alreadyNumber; ++i) {
	            if(randomNumber[i] == tempNumber) {
	                break;
                }
            }
            if(i >= alreadyNumber) {
	            randomNumber[alreadyNumber] = tempNumber;
                alreadyNumber++;
            }
        }

        return randomNumber;
    }

    public boolean addScore(int examID, double score) {
	    return this.interfaceDatabaseProxy.addStudentScore(examID, this.userID, score);
    }
}