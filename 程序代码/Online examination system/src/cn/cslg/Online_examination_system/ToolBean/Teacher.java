package cn.cslg.Online_examination_system.ToolBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Teacher extends User {
	public Teacher(int userID, int gradeID, String username, String password, String identity) {
		super(userID, gradeID, username, password, identity);
	}

	/**
	 * @param courseID 课程ID
	 * @return course 课程对象
     * @function 依据课程ID查询课程对象
	 */
	public Course queryCourse(int courseID) {
	    return this.interfaceDatabaseProxy.queryCourse(courseID);
	}

	/**
	 * @return courseList 课程列表
     * @funtion 查询本人所拥有的所有课程
	 */
	public ArrayList<Course> queryAllCourse() {
		return this.interfaceDatabaseProxy.queryAllCourse(this.userID);
	}

	/**
	 * @param courseID 课程ID
	 * @return isSuccess 成功与否
     * @function 依据课程ID删除课程
	 */
	public boolean deleteCourse(int courseID) {
		return this.interfaceDatabaseProxy.deleteCourse(courseID);
	}

	/**
	 * @param courseName 课程名
	 * @param courseInformation 课程信息
	 * @return courseID 课程ID
     * @function 依据课程信息添加一个课程
	 */
	public int addCourse(String courseName, String courseInformation) {
        boolean isSuccess = this.interfaceDatabaseProxy.addCourse(this.userID, new Course(courseName, courseInformation));
        if(isSuccess) {
            Course course = this.interfaceDatabaseProxy.queryCourse(this.userID, courseName, courseInformation);
            return course.getCourseID();
        } else {
            return -1;
        }
	}

	/**
	 * @param course 课程对象
	 * @return isSuccess 成功与否
     * @function 更新课程信息
	 */
	public boolean updateCourse(Course course) {
		return this.interfaceDatabaseProxy.updateCourse(course);
	}

	/**
	 * @param questionBankID 题库ID
	 * @return questionBank 题库对象
	 * @function 查询出题库对象
	 */
	public QuestionBank queryQuestionBank(int questionBankID) {
		return this.interfaceDatabaseProxy.queryQuestionBank(questionBankID);
	}

	public ArrayList<QuestionBank> queryAllQuestionBank() {
		return this.interfaceDatabaseProxy.queryAllQuestionBank();
	}

	/**
	 * @param courseID 课程ID
	 * @return question list 题目列表
     * @function 查询某个课程下的所有题库
	 */
	public ArrayList<QuestionBank> queryAllQuestionBank(int courseID) {
		return this.interfaceDatabaseProxy.queryAllQuestionBank(courseID);
	}

	/**
	 * @param questionBankID 题库ID
	 * @return isSuccess 成功与否
     * @function 删除题库
	 */
	public boolean deleteQuestionBank(int questionBankID) {
		boolean isSuccess = this.interfaceDatabaseProxy.deleteAllQuestion(questionBankID);
		if(!isSuccess) {
			return isSuccess;
		}
		isSuccess = this.interfaceDatabaseProxy.deleteQuestionBank(questionBankID);
		return isSuccess;
	}

	/**
     * @param courseID 课程ID
	 * @param questionBankName 题库名
	 * @return isSuccess 成功与否
     * @function 添加题库
	 */
	public int addQuestionBank(int courseID, String questionBankName) {
        boolean isSuccess = this.interfaceDatabaseProxy.addQuestionBank(courseID, new QuestionBank(questionBankName));
        if(isSuccess) {
            QuestionBank questionBank = this.interfaceDatabaseProxy.queryQuestionBank(courseID, questionBankName);
            return questionBank.getQuestionBankID();
        } else {
            return -1;
        }
	}

	/**
	 * @param questionBankName 题库名
	 * @param questionList 问题列表
	 * @return questionBankID 题库ID
     * @function 添加题库
	 */
	public int addQuestionBank(int courseID, String questionBankName, ArrayList<Question> questionList) {
		int questionBankID = this.addQuestionBank(courseID, questionBankName);
		if(questionBankID >= 0) {
		    for(int i = 0; i < questionList.size(); ++i) {
                this.interfaceDatabaseProxy.addQuestion(questionBankID, questionList.get(i));
            }
        }
        return questionBankID;
	}

	/**
	 * @param questionBank 题库对象
	 * @return isSuccess 成功与否
     * @function 更新题库
	 */
	public boolean updateQuestionBank(QuestionBank questionBank) {
		return this.interfaceDatabaseProxy.updateQuestinBank(questionBank);
	}

	public Question queryQuestion(int questionID) {
		return this.interfaceDatabaseProxy.queryQuestion(questionID);
	}

	/**
	 * @param questionBankID 题库ID
	 * @return questionList 问题列表
	 * @function 查询所有的问题
	 */
	public ArrayList<Question> queryAllQuestion(int questionBankID) {
		return this.interfaceDatabaseProxy.queryAllQuestion(questionBankID);
	}

	/**
	 * @param question 问题对象
	 * @return isSuccess 成功与否
     * @function 更新问题
	 */
	public boolean updateQuestion(Question question) {
		return this.interfaceDatabaseProxy.updateQuestion(question);
	}

	/**
	 * @param questionID 问题ID
	 * @return isSuccess 成功与否
     * @function 删除问题
	 */
	public boolean deleteQuestion(int questionID) {
		return this.interfaceDatabaseProxy.deleteQuestion(questionID);
	}

	/**
	 * @param gradeID 
	 * @return grade 班级对象
     * @function 依据班级ID获取班级对象
	 */
	public Grade queryGrade(int gradeID) {
		return this.interfaceDatabaseProxy.queryGrade(gradeID);
	}

	/**
	 * @return gradeList 班级列表
     * @function 获取本人所拥有的所有课程
	 */
	public ArrayList<Grade> queryAllGrade() {
		return this.interfaceDatabaseProxy.queryAllGrade(this.userID);
	}

	/**
	 * @param gradeID 班级ID
	 * @return isSuccess 成功与否
     * @function 删除班级
	 */
	public boolean deleteGrade(int gradeID) {
		boolean isSuccess = this.interfaceDatabaseProxy.deleteAllStudent(gradeID);
		if(!isSuccess) {
		    return false;
        }
		return this.interfaceDatabaseProxy.deleteGrade(gradeID);
	}

	/**
	 * @param gradeName 班级名
	 * @return gradeID
     * @function 添加班级
	 */
	public int addGrade(String gradeName) {
        boolean isSuccess = this.interfaceDatabaseProxy.addGrade(userID, new Grade(gradeName));
        if(isSuccess) {
            Grade grade = this.interfaceDatabaseProxy.queryGrade(userID, gradeName);
            return grade.getGradeID();
        } else {
            return -1;
        }
	}

	/**
	 * @param gradeName 班级名
	 * @param studentList 学生列表
	 * @return gradeID 班级ID
     * @function 添加一个班级
	 */
	public int addGrade(String gradeName, ArrayList<Student> studentList) {
	    int gradeID = this.addGrade(gradeName);
	    if(gradeID >= 0) {
	        for(int i = 0; i < studentList.size(); ++i) {
	        	studentList.get(i).setGradeID(gradeID);
	            this.interfaceDatabaseProxy.addStudent(studentList.get(i));
            }
        }
		return gradeID;
	}

	/**
	 * @param grade 班级对象
	 * @return isSuccess 成功与否
     * @function 更新班级
	 */
	public boolean updateGrade(Grade grade) {
		return this.interfaceDatabaseProxy.updateGrade(grade);
	}

    public Student queryStudent(int userID) {
        return this.interfaceDatabaseProxy.queryStudent(userID);
    }

	public ArrayList<Student> queryAllStudent(int gradeID) {
	    return this.interfaceDatabaseProxy.queryAllStudent(gradeID);
    }

	/**
     * @param userID 班级ID
	 * @param password 密码
	 * @return isSuccess 成功与否
     * @function 更新学生信息
	 */
	public boolean updateStudent(int userID, String password) {
		return this.interfaceDatabaseProxy.updateUser(userID, password);
	}

	public boolean deleteStudent(int userID) {
	    return this.interfaceDatabaseProxy.deleteStudent(userID);
    }

	/**
	 * @return examList 测试列表
     * @function 查询教师拥有的所有测试
	 */
	public ArrayList<Exam> queryAllExam() {
	    return this.interfaceDatabaseProxy.queryAllExam(this.userID);
	}

	/**
	 * @param exam 测试对象
	 * @return examID 测试ID
     * @function 添加一个测试
	 */
	public int addExam(Exam exam) {
	    boolean isSuccess = this.interfaceDatabaseProxy.addExam(exam);
	    if(isSuccess) {
	        return this.interfaceDatabaseProxy.queryExam(exam).examID;
        } else {
	        return -1;
        }
	}

	/**
	 * @param examID 测试ID
	 * @return isSuccess 成功与否
     * @function 删除测试
	 */
	public boolean deleteExam(int examID) {
		return this.interfaceDatabaseProxy.deleteExam(examID);
	}

	public int queryQuestionBankCourseID(int questionBankID) {
	    return this.interfaceDatabaseProxy.queryQuestionBankCourseID(questionBankID);
    }

    public int queryQuestionQuestionBankID(int questionID) {
        return this.interfaceDatabaseProxy.queryQuestionQuestionBankID(questionID);
    }
}