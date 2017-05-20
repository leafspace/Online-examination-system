package cn.cslg.Online_examination_system.DatabaseProxy;

import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;
import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseConnectionFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseConnection;
import cn.cslg.Online_examination_system.ToolBean.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/18.
 * Programmar:leafspace
 * Phone:18852923073
 * E-mail:18852923073@163.com
 * Last edit time:2017.4.22
 * Function:
 *
 * */
public class MySqlDatabaseProxy implements InterfaceDatabaseProxy {
    private InterfaceDatabaseConnection databaseConnection = null;

    public MySqlDatabaseProxy() {
        this.databaseConnection = new DatabaseConnectionFactory().getDatabaseConnection("MySQL");
    }

    public Course queryCourse(int courseID){}
    public ArrayList<Course> queryAllCourse(int userID){}
    public QuestionBank queryQuestionBank(int questionBankID){}
    public ArrayList<QuestionBank> queryAllQuestionBank(int courseID){}
    public Question queryQuestion(int questionID){}
    public ArrayList<Question> queryAllQuestion(int questionBankID){}
    public Grade queryGrade(int gradeID){}
    public ArrayList<Grade> queryAllGrade(int userID){}
    public Exam querrExam(int examID){}
    public ArrayList<Exam> queryAllExam(int userID){}

    public boolean updateCourse(Course course){}
    public boolean updateQuestinBank(QuestionBank questionBank){}
    public boolean updateQuestion(Question question){}
    public boolean updateGrade(Grade grade){}
    public boolean updateExam(Exam exam){}

    public boolean addCourse(Course course){}
    public boolean addQuestionBank(QuestionBank questionBank){}
    public boolean addQuestion(QuestionBank questionBank){}
    public boolean addGrade(Grade grade){}
    public boolean addExam(Exam exam){}

    public boolean deleteCourse(int courseID){}
    public boolean deleteQuestionBank(int questionBankID){}
    public boolean deleteQuestion(int questionID){}
    public boolean deleteGrade(int gradeID){}
    public boolean deleteExam(int examID)


    public ArrayList<Teacher> queryAllTeacher(){}
    public ArrayList<Student> queryAllStudent(){}

    public boolean addStudent(Student student){}
    public boolean addTeacher(Teacher teacher){}
}
