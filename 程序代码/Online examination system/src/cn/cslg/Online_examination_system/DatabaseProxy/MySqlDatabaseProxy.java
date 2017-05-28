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
 * LastEdit: 2017-5-27
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
        ArrayList<Course> courses = new ArrayList<>();
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
        String sqlStr = "SELECT questionBankName FROM questionbank WHERE questionBankID = " + questionBankID + ";";
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
        ArrayList<QuestionBank> questionBanks = new ArrayList<>();
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
        ArrayList<Question> questions = new ArrayList<>();
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
        String sqlStr = "SELECT gradeName FROM grade WHERE gradeID = " + gradeID + ";";
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
        ArrayList<Grade> grades = new ArrayList<>();
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
                exam.examID = Integer.parseInt(resultSet.getString(1));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    public ArrayList<Exam> queryAllExam(int gradeID) {
        ArrayList<Exam> exams = new ArrayList<>();
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
        String sqlStr = "UPDATE course SET courseName = '" + course.getCourseName() + "' , courseInformation = '"
                + course.getCourseInformation() + "' WHERE courseID = " + course.getCourseID() + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateCourse) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean updateQuestinBank(QuestionBank questionBank) {
        String sqlStr = "UPDATE questionbank SET questionBankName = '" + questionBank.getQuestionBankName()
                + "' WHERE questionBankID = " + questionBank.getQuestionBankID() + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateQuestionBank) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean updateQuestion(Question question) {
        String sqlStr = "UPDATE question SET question = '" + question.question + "', questionType='" + question.getQuestionType()
                + "',A = '" + question.A + "', B = '" + question.B + "', C = '" + question.C + "', D = '" + question.D + "', E = '"
                + question.E + "', answer = '" + question.answer + "' WHERE questionID = " + question.getQuestionID() + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateQuestion) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean updateGrade(Grade grade) {
        String sqlStr = "UPDATE grade SET gradeName = '" + grade.getGradeName() + "' WHERE gradeID = "
                + grade.getGradeID() + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateGrade) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean updateExam(Exam exam) {
        String sqlStr = "UPDATE exam SET gradeID = " + exam.gradeID + ", questionBankID = " + exam.questionBankID
                + ", examName = '" + exam.examName + "', examTime = '" + exam.examTime + "', examMinutes = " + exam.examMinutes
                + ", examStartMinutes = " + exam.examStratMinutes + ", judgeNumber = " + exam.judgeNumber
                + ", morechoiceNumber = " + exam.morechoiceNumber + ", onechoiceNumber = " + exam.onechoiceNumber
                + ", judgeScore = " + exam.judgeScore + ", morechoiceScore = " + exam.morechoiceScore
                + ", onechoiceScore = " + exam.onechoiceScore + " WHERE examID = " + exam.examID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateExam) : The effect is wrong ! ");
            return false;
        }
        return true;
    }


    public boolean addCourse(int userID, Course course) {
        String sqlStr = "INSERT INTO course(userID, courseName, courseInformation) VALUES (" + userID + ", '"
                + course.getCourseName() + "', '" + course.getCourseInformation() + "');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addCourse) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addQuestionBank(int courseID, QuestionBank questionBank) {
        String sqlStr = "INSERT INTO questionbank(courseID, questionBankName) VALUES (" + courseID + ", '"
                + questionBank.getQuestionBankName() + "');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addQuestionBank) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addQuestion(int questionBankID, Question question) {
        String sqlStr = "INSERT INTO question(questionBankID, questionType, question, A, B, C, D, E, answer) VALUES ("
                + questionBankID + ", '" + question.getQuestionType() + "', '" + question.question + "', '"
                + question.A + "', '" + question.B + "', '" + question.C + "', '" + question.D + "', '" + question.E
                + "', '" + question.answer + "');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addQuestion) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addGrade(int userID, Grade grade) {
        String sqlStr = "INSERT INTO grade(userID, gradeName) VALUES (" + userID + ", '" + grade.getGradeName() + "');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addGrade) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addExam(Exam exam) {
        String sqlStr =
                "INSERT INTO exam(gradeID, questionBankID, examName, examTime, examMinutes, examStartMinutes," +
                        " judgeNumber, morechoiceNumber, onechoiceNumber, judgeScore, morechoiceScore, onechoiceScore)" +
                        " VALUES (" + exam.gradeID + ", " + exam.questionBankID + ", '" + exam.examName + "', '"
                        + exam.examTime + "', " + exam.examMinutes + ", " + exam.examStratMinutes + ", " + exam.judgeNumber
                        + ", " + exam.morechoiceNumber + ", " + exam.onechoiceNumber + ", " + exam.judgeScore + ", "
                        + exam.morechoiceScore + ", " + exam.onechoiceScore + ");";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addExam) : The effect is wrong ! ");
            return false;
        }
        return true;
    }


    public boolean deleteCourse(int courseID) {
        String sqlStr = "DELETE FROM course WHERE courseID = " + courseID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteCourse) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean deleteQuestionBank(int questionBankID) {
        String sqlStr = "DELETE FROM questionbank WHERE questionBankID = " + questionBankID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteQuestionBank) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean deleteQuestion(int questionID) {
        String sqlStr = "DELETE FROM question WHERE questionID = " + questionID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteQuestion) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean deleteAllQuestion(int questionBankID) {
        boolean isSuccess = true;
        ArrayList<Question> questions = this.queryAllQuestion(questionBankID);
        for(Question i : questions) {
            isSuccess = isSuccess & this.deleteQuestion(i.getQuestionID());
        }
        return isSuccess;
    }

    public boolean deleteGrade(int gradeID) {
        String sqlStr = "DELETE FROM grade WHERE gradeID = " + gradeID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteGrade) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean deleteAllStudent(int gradeID) {
        boolean isSuccess = true;
        ArrayList<Student> students = this.queryAllStudent(gradeID);
        for(Student i : students) {
            isSuccess = isSuccess & this.deleteStudent(i.getUserID());
        }
        return isSuccess;
    }

    public boolean deleteExamScore(int examID) {
        String sqlStr = "DELETE FROM examscore WHERE examID = " + examID + ";";
        this.databaseConnection.update(sqlStr);
        return true;
    }

    public boolean deleteExam(int examID) {
        String sqlStr = "DELETE FROM exam WHERE examID = " + examID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteExam) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public ArrayList<Course> queryAllCourse() {
        ArrayList<Teacher> teachers = this.queryAllTeacher();
        ArrayList<Course> courses = new ArrayList<>();
        for(Teacher i : teachers) {
            courses.addAll(this.queryAllCourse(i.getUserID()));
        }
        return courses;
    }

    public ArrayList<Grade> queryAllGrade() {
        ArrayList<Teacher> teachers = this.queryAllTeacher();
        ArrayList<Grade> grades = new ArrayList<>();
        for(Teacher i : teachers) {
            grades.addAll(this.queryAllGrade(i.getUserID()));
        }
        return grades;
    }

    public ArrayList<QuestionBank> queryAllQuestionBank() {
        ArrayList<Course> courses = this.queryAllCourse();
        ArrayList<QuestionBank> questionBanks = new ArrayList<>();
        for(Course i : courses) {
            questionBanks.addAll(this.queryAllQuestionBank(i.getCourseID()));
        }
        return questionBanks;
    }

    public ArrayList<Question> queryAllQuestion() {
        ArrayList<QuestionBank> questionBanks = this.queryAllQuestionBank();
        ArrayList<Question> questions = new ArrayList<>();
        for(QuestionBank i : questionBanks) {
            questions.addAll(this.queryAllQuestion(i.getQuestionBankID()));
        }
        return questions;
    }

    public ArrayList<Exam> queryAllExam() {
        ArrayList<Grade> grades = this.queryAllGrade();
        ArrayList<Exam> exams = new ArrayList<>();
        for(Grade i : grades) {
            exams.addAll(this.queryAllExam(i.getGradeID()));
        }
        return exams;
    }

    public ArrayList<Teacher> queryAllTeacher() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        String sqlStr = "SELECT * FROM user WHERE identity = 'Teacher';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int userID = Integer.parseInt(resultSet.getString(1));
                int gradeID = Integer.parseInt(resultSet.getString(2));
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                teachers.add(new Teacher(userID, gradeID, username, password, "Teacher"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public ArrayList<Student> queryAllStudent() {
        ArrayList<Student> students = new ArrayList<>();
        String sqlStr = "SELECT * FROM user WHERE identity = 'Student';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int userID = Integer.parseInt(resultSet.getString(1));
                int gradeID = Integer.parseInt(resultSet.getString(2));
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                students.add(new Student(userID, gradeID, username, password, "Student"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Teacher queryTeacher(int userID) {
        Teacher teacher = null;
        String sqlStr = "SELECT * FROM user WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if (resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(2));
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                String identity = resultSet.getString(5);
                teacher = new Teacher(userID, gradeID, username, password, identity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public Manager queryManager(int userID) {
        Manager manager = null;
        String sqlStr = "SELECT * FROM user WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if (resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(2));
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                String identity = resultSet.getString(5);
                manager = new Manager(userID, gradeID, username, password, identity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    public Student queryStudent(int userID) {
        Student student = null;
        String sqlStr = "SELECT * FROM user WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if (resultSet.next()) {
                int gradeID = Integer.parseInt(resultSet.getString(2));
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                String identity = resultSet.getString(5);
                student = new Student(userID, gradeID, username, password, identity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public boolean addStudent(Student student) {
        String sqlStr = "INSERT INTO user(gradeID, username, password, identity) " +
                "VALUES (" + student.getGradeID() + ", '" + student.getUserName() + "', '" + student.getPassword() + "', 'Student');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addStudent) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addTeacher(Teacher teacher) {
        String sqlStr = "INSERT INTO user(gradeID, username, password, identity) " +
                "VALUES (" + teacher.getGradeID() + ", '" + teacher.getUserName() + "', '" + teacher.getPassword() + "', 'Teacher');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addTeacher) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean updateUser(int userID, String password) {
        String sqlStr = "UPDATE user SET password = '" + password + "' WHERE userID = " + userID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - updateUser) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public ArrayList<Student> queryAllStudent(int gradeID) {
        String sqlStr = "SELECT userID, username, password FROM user WHERE gradeID = " + gradeID + " AND identity = 'Student';";
        ArrayList<Student> students = new ArrayList<>();
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int userID = Integer.parseInt(resultSet.getString(1));
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                students.add(new Student(userID, gradeID, username, password, "Student"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean deleteStudent(int userID) {
        String sqlStr = "DELETE FROM user WHERE userID = " + userID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - deleteStudent) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    /**
     * Programmar leafspace
     * Edit time 2017-5-22
     * @param resultSet 结果集
     * @return isExist 是否存在结果
     * Function 用来判断结果集是否存在数据
     * */
    private boolean isExist(ResultSet resultSet) {
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Programmar leafspace
     * Edit time 2017-5-22
     * @param username 用户名
     * @return isExist 是否存在结果
     * Function 用来判断此用户名是否存在
     * */
    public boolean checkUser(String username) {
        String sqlStr = "SELECT * FROM user WHERE username = '" + username + "';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        return this.isExist(resultSet);
    }

    /**
     * Programmar leafspace
     * Edit time 2017-5-22
     * @param username 用户名
     * @param password 密码
     * @return userID 用户ID
     * Function 用来判断用户名与密码是否匹配
     *      是 - 返回用户ID
     *      否 - 返回-1
     * */
    public int checkUser(String username, String password) {
        String sqlStr = "SELECT userID FROM user WHERE username = '" + username + "' AND password = '" + password + "';";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        if(!this.isExist(resultSet)) {
            return -1;
        }

        try {
            return Integer.parseInt(resultSet.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * Programmar leafspace
     * Edit time 2017-5-22
     * @param userID 用户ID
     * @return User 用户对象
     * Function 用来获取某个用户ID所存在的用户对象(Manager,Student,Teacher)
     * */
    public User queryIdentity(int userID) {
        String sqlStr = "SELECT identity FROM user WHERE userID = " + userID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                String identity = resultSet.getString(1);
                switch (identity)
                {
                    case "Manager" : return this.queryManager(userID);
                    case "Student" : return this.queryStudent(userID);
                    case "Teacher" : return this.queryTeacher(userID);
                    default: return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean resetUser(String username) {
        String sqlStr = "UPDATE user SET password = '123456' WHERE username = '" + username + "';";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - resetUser) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    private int getResultSetID(ResultSet resultSet) {
        try {
            if(resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int queryQuestionBankCourseID(int questionBankID) {
        String sqlStr = "SELECT courseID FROM questionbank WHERE questionBankID = " + questionBankID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        return this.getResultSetID(resultSet);
    }

    public int queryQuestionQuestionBankID(int questionID) {
        String sqlStr = "SELECT questionBankID FROM question WHERE questionID = " + questionID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        return this.getResultSetID(resultSet);
    }

    public double queryStudentScore(int examID, int userID) {
        String sqlStr = "SELECT score FROM examscore WHERE userID = " + userID + " AND examID = " + examID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                return Double.parseDouble(resultSet.getString(1));
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public StudentScore queryStudentScoreObject(int examID, int userID) {
        String sqlStr = "SELECT score FROM examscore WHERE userID = " + userID + " AND examID = " + examID + ";";
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            if(resultSet.next()) {
                int score = Integer.parseInt(resultSet.getString(1));
                Student student = this.queryStudent(userID);
                Exam exam = this.queryExam(examID);
                return new StudentScore(userID, examID, student.getUserName(), exam.examName, score);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addStudentScore(int examID, int userID, double score) {
        String sqlStr = "INSERT INTO examscore VALUES (" + examID + ", " + userID + ", " + score + ");";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addStudentScore) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean clearStudentScore(int examID, int userID) {
        String sqlStr = "DELETE FROM examscore WHERE userID = " + userID + " AND examID = " + examID + ";";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - clearStudentScore) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public boolean addContactInformation(ContactInformation contactInformation) {
        String sqlStr = "INSERT INTO contact VALUES (" + contactInformation.getUserID() + ", '" + contactInformation.getInformation() + "');";
        int resultNumber = this.databaseConnection.update(sqlStr);
        if(resultNumber != 1) {
            System.out.println("Warning (MySqlDatabaseProxy - addContactInformation) : The effect is wrong ! ");
            return false;
        }
        return true;
    }

    public ArrayList<ContactInformation> queryAllContactInformation(int userID) {
        String sqlStr = "SELECT * FROM contact WHERE userID = 1 OR userID = " + userID + ";";
        ArrayList<ContactInformation> contactInformations = new ArrayList<>();
        ResultSet resultSet = this.databaseConnection.query(sqlStr);
        try {
            while(resultSet.next()) {
                int tempUserID = Integer.parseInt(resultSet.getString(1));
                String information = resultSet.getString(2);
                if(tempUserID == 1) {
                    contactInformations.add(new ContactInformation(tempUserID, "in", information));
                } else {
                    contactInformations.add(new ContactInformation(tempUserID, "out", information));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactInformations;
    }
}
