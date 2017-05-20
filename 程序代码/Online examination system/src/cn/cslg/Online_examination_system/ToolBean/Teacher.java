package cn.cslg.Online_examination_system.ToolBean;


import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Teacher extends User {

	/**
	 * Default constructor
	 */
	public Teacher() {
	}






	/**
	 * @param courseID 
	 * @return
	 */
	public Course querryCourse(int courseID) {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Course> querryAllCourse() {
		// TODO implement here
		return null;
	}

	/**
	 * @param courseID 
	 * @return
	 */
	public boolean deleteCourse(int courseID) {
		// TODO implement here
		return false;
	}

	/**
	 * @param courseName 
	 * @param courseInformation 
	 * @return
	 */
	public int addCourse(String courseName, String courseInformation) {
		// TODO implement here
		return 0;
	}

	/**
	 * @param course 
	 * @return
	 */
	public boolean updateCourse(Course course) {
		// TODO implement here
		return false;
	}

	/**
	 * @param courseID 
	 * @return
	 */
	public ArrayList<QuestionBank> querryAllQuestionBank(int courseID) {
		// TODO implement here
		return null;
	}

	/**
	 * @param questionBankID 
	 * @return
	 */
	public boolean deleteQuestionBank(int questionBankID) {
		// TODO implement here
		return false;
	}

	/**
	 * @param questionName 
	 * @return
	 */
	public int addQuestionBank(String questionName) {
		// TODO implement here
		return 0;
	}

	/**
	 * @param questionName 
	 * @param questionList 
	 * @return
	 */
	public int addQuestionBank(String questionName, ArrayList<Question> questionList) {
		// TODO implement here
		return 0;
	}

	/**
	 * @param questionBank 
	 * @return
	 */
	public boolean updateQuestionBank(QuestionBank questionBank) {
		// TODO implement here
		return false;
	}

	/**
	 * @param question 
	 * @return
	 */
	public boolean updateQuestion(Question question) {
		// TODO implement here
		return false;
	}

	/**
	 * @param questionID 
	 * @return
	 */
	public boolean deleteQuestion(int questionID) {
		// TODO implement here
		return false;
	}

	/**
	 * @param gradeID 
	 * @return
	 */
	public Grade querryGrade(int gradeID) {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Grade> querryAllGrade() {
		// TODO implement here
		return null;
	}

	/**
	 * @param gradeID 
	 * @return
	 */
	public boolean deleteGrade(int gradeID) {
		// TODO implement here
		return false;
	}

	/**
	 * @param gradeName 
	 * @return
	 */
	public int addGrade(String gradeName) {
		// TODO implement here
		return 0;
	}

	/**
	 * @param gradeName 
	 * @param studentList 
	 * @return
	 */
	public int addGrade(String gradeName, ArrayList<User> studentList) {
		// TODO implement here
		return 0;
	}

	/**
	 * @param grade 
	 * @return
	 */
	public boolean updateGrade(Grade grade) {
		// TODO implement here
		return false;
	}

	/**
	 * @param username 
	 * @param password 
	 * @return
	 */
	public boolean updateStudent(String username, String password) {
		// TODO implement here
		return false;
	}

	/**
	 * @return
	 */
	public ArrayList<Exam> querryAllExam() {
		// TODO implement here
		return null;
	}

	/**
	 * @param exam 
	 * @return
	 */
	public boolean addExam(Exam exam) {
		// TODO implement here
		return false;
	}

	/**
	 * @param examID 
	 * @return
	 */
	public boolean deleteExam(int examID) {
		// TODO implement here
		return false;
	}

}