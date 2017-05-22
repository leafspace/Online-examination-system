package cn.cslg.Online_examination_system.DatabaseProxy;

import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;
import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseConnectionFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseConnection;
import cn.cslg.Online_examination_system.ToolBean.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/4/18.
 * LastEdit: 2017-5-21
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class MySqlDatabaseProxy implements InterfaceDatabaseProxy {
    private InterfaceDatabaseConnection databaseConnection = null;

    public MySqlDatabaseProxy() {
        this.databaseConnection = new DatabaseConnectionFactory().getDatabaseConnection("MySQL");
    }

    public Course queryCourse(int courseID) {
        Course course = null;
        String sqlStr = "SELECT courseName, courseInformation FROM course WHERE courseID = " + courseID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                course = new Course(courseID, resultSet.getString(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public Course queryCourse(int userID, String courseName, String courseInformation) {
        Course course = null;
        String sqlStr = "SELECT courseID FROM course WHERE userID = " + userID + " AND courseName = '" +
                courseName + "' AND courseInformation = '" + courseInformation + "';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int courseID = Integer.parseInt(resultSet.getString(1));
                course = new Course(courseID, courseName, courseInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public ArrayList<Course> queryAllCourse(int userID) {
        ArrayList<Course> courses = new ArrayList<Course>();
        String sqlStr = "SELECT courseID, courseName, courseInformation FROM course WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int courseID = Integer.parseInt(resultSet.getString(1));
                String courseName = resultSet.getString(2);
                String courseInformation = resultSet.getString(3);
                courses.add(new Course(courseID, courseName, courseInformation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public QuestionBank queryQuestionBank(int questionBankID) {
        QuestionBank questionBank = null;
        String sqlStr = "SELECT questionBankName FROM questionbank WHERE questionBankID = 1;";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                questionBank = new QuestionBank(questionBankID, resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionBank;
    }

    public QuestionBank queryQuestionBank(int courseID, String questionBankName) {
        QuestionBank questionBank = null;
        String sqlStr = "SELECT questionBankID FROM questionbank WHERE courseID = " + courseID +
                " AND questionBankName = '" + questionBankName + "';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int questionBankID = Integer.parseInt(resultSet.getString(1));
                questionBank = new QuestionBank(questionBankID, questionBankName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionBank;
    }

    public ArrayList<QuestionBank> queryAllQuestionBank(int courseID) {
        ArrayList<QuestionBank> questionBanks = new ArrayList<QuestionBank>();
        String sqlStr = "SELECT questionBankID, questionBankName FROM questionbank WHERE courseID = " + courseID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int questionBankID = Integer.parseInt(resultSet.getString(1));
                String questionBankName = resultSet.getString(2);
                questionBanks.add(new QuestionBank(questionBankID, questionBankName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionBanks;
    }

    public Question queryQuestion(int questionID) {
        Question question = null;
        String sqlStr = "SELECT questionType, question, A, B, C, D, E, answer FROM question WHERE questionID = "
                + questionID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                String questionType = resultSet.getString(1);
                String questionString = resultSet.getString(2);
                String A = resultSet.getString(3);
                String B = resultSet.getString(4);
                String C = resultSet.getString(5);
                String D = resultSet.getString(6);
                String E = resultSet.getString(7);
                String answer = resultSet.getString(8);
                question = new Question(questionID, questionType, questionString, A, B, C, D, E, answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public ArrayList<Question> queryAllQuestion(int questionBankID) {
        ArrayList<Question> questions = new ArrayList<Question>();
        String sqlStr =
                "SELECT questionID, questionType, question, A, B, C, D, E, answer FROM question WHERE questionBankID = "
                + questionBankID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int questionID = Integer.parseInt(resultSet.getString(1));
                String questionType = resultSet.getString(2);
                String questionString = resultSet.getString(3);
                String A = resultSet.getString(4);
                String B = resultSet.getString(5);
                String C = resultSet.getString(6);
                String D = resultSet.getString(7);
                String E = resultSet.getString(8);
                String answer = resultSet.getString(9);
                questions.add(new Question(questionID, questionType, questionString, A, B, C, D, E, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Grade queryGrade(int gradeID) {
        Grade grade = null;
        String sqlStr = "SELECT gradeName FROM grade WHERE gradeID = 1;";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                grade = new Grade(gradeID, resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    public Grade queryGrade(int userID, String gradeName) {
        Grade grade = null;
        String sqlStr = "SELECT gradeID FROM grade WHERE userID = " + userID + " AND gradeName = '" + gradeName + "';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(1));
                grade = new Grade(gradeID, gradeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    public ArrayList<Grade> queryAllGrade(int userID) {
        ArrayList<Grade> grades = new ArrayList<Grade>();
        String sqlStr = "SELECT gradeID, gradeName FROM grade WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(1));
                String gradeName = resultSet.getString(2);
                grades.add(new Grade(gradeID, gradeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public Exam queryExam(int examID) {
        Exam exam = null;
        String sqlStr = "SELECT * FROM exam WHERE examID = " + examID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(2));
                int questionBankID = Integer.parseInt(resultSet.getString(3));
                String examName = resultSet.getString(4);
                String examTime = resultSet.getString(5);
                int examMinutes = Integer.parseInt(resultSet.getString(6));
                int examStartMinutes = Integer.parseInt(resultSet.getString(7));
                int judgeNumber = Integer.parseInt(resultSet.getString(8));
                int morechoiceNumber = Integer.parseInt(resultSet.getString(9));
                int onechoiceNumber = Integer.parseInt(resultSet.getString(10));
                double judgeScore = Double.parseDouble(resultSet.getString(11));
                double morechoiceScore = Double.parseDouble(resultSet.getString(12));
                double onechoiceScore = Double.parseDouble(resultSet.getString(13));
                exam = new Exam(examID, gradeID, questionBankID, examName, examTime, examMinutes, examStartMinutes,
                        judgeNumber, morechoiceNumber, onechoiceNumber, judgeScore, morechoiceScore, onechoiceScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    public Exam queryExam(Exam exam) {
        String sqlStr = "SELECT examID FROM exam WHERE gradeID = " + exam.gradeID + " AND questionBankID = " +
                exam.questionBankID + " AND examName = '" + exam.examName + "' AND examTime = '" + exam.examTime +
                "' AND examMinutes = " + exam.examMinutes + " AND examStartMinutes = " + exam.examStratMinutes +
                " AND judgeNumber = " + exam.judgeNumber + " AND morechoiceNumber = " + exam.morechoiceNumber +
                " AND onechoiceNumber = " + exam.onechoiceNumber + " AND judgeScore = " + exam.judgeScore +
                " AND morechoiceScore = " + exam.morechoiceScore + " AND onechoiceScore = " + exam.onechoiceScore + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int examID = Integer.parseInt(resultSet.getString(1));
                exam.examID = examID;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    public ArrayList<Exam> queryAllExam(int gradeID) {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        String sqlStr = "SELECT * FROM exam WHERE gradeID = " + gradeID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while (resultSet.next()) {
                int examID = Integer.parseInt(resultSet.getString(1));
                int questionBankID = Integer.parseInt(resultSet.getString(3));
                String examName = resultSet.getString(4);
                String examTime = resultSet.getString(5);
                int examMinutes = Integer.parseInt(resultSet.getString(6));
                int examStartMinutes = Integer.parseInt(resultSet.getString(7));
                int judgeNumber = Integer.parseInt(resultSet.getString(8));
                int morechoiceNumber = Integer.parseInt(resultSet.getString(9));
                int onechoiceNumber = Integer.parseInt(resultSet.getString(10));
                double judgeScore = Double.parseDouble(resultSet.getString(11));
                double morechoiceScore = Double.parseDouble(resultSet.getString(12));
                double onechoiceScore = Double.parseDouble(resultSet.getString(13));
                exams.add(new Exam(examID, gradeID, questionBankID, examName, examTime, examMinutes, examStartMinutes,
                        judgeNumber, morechoiceNumber, onechoiceNumber, judgeScore, morechoiceScore, onechoiceScore));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }


    public boolean updateCourse(Course course) {

    }

    public boolean updateQuestinBank(QuestionBank questionBank) {

    }

    public boolean updateQuestion(Question question) {

    }

    public boolean updateGrade(Grade grade) {

    }

    public boolean updateExam(Exam exam) {

    }


    public boolean addCourse(Course course) {

    }

    public boolean addQuestionBank(int courseID, QuestionBank questionBank) {

    }

    public boolean addQuestion(int questionBankID, Question question) {

    }

    public boolean addGrade(int userID, Grade grade) {

    }

    public boolean addExam(Exam exam) {

    }


    public boolean deleteCourse(int courseID) {

    }

    public boolean deleteQuestionBank(int questionBankID) {

    }

    public boolean deleteQuestion(int questionID) {

    }

    public boolean deleteGrade(int gradeID) {

    }

    public boolean deleteExam(int examID) {

    }

    public boolean deleteStudent(int userID) {

    }


    public ArrayList<Course> queryAllCourse() {

    }

    public ArrayList<Grade> queryAllGrade() {

    }

    public ArrayList<QuestionBank> queryAllQuestionBank() {

    }

    public ArrayList<Question> queryAllQuestion() {

    }

    public ArrayList<Exam> queryAllExam() {

    }

    public ArrayList<Teacher> queryAllTeacher() {

    }
    public ArrayList<Student> queryAllStudent() {

    }


    public boolean addStudent(int gradeID, Student student) {

    }

    public boolean addTeacher(int gradeID, Teacher teacher) {

    }

    public boolean updateUser(int userID, String password) {

    }
}
