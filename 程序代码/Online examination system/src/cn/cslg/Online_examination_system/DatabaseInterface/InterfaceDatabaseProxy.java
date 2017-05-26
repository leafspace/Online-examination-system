package cn.cslg.Online_examination_system.DatabaseInterface;

import cn.cslg.Online_examination_system.ToolBean.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */

public interface InterfaceDatabaseProxy {
    Course queryCourse(int courseID);                                                              //依据某个课程ID获取课程对象
    Course queryCourse(int userID, String courseName, String courseInformation);                   //依据某个课程的各项信息查询出此课程对象
    ArrayList<Course> queryAllCourse(int userID);                                                  //获取某个教师所拥有的所有课程
    QuestionBank queryQuestionBank(int questionBankID);                                            //依据某个题库ID获取题库对象
    QuestionBank queryQuestionBank(int courseID, String questionBankName);                         //依据某个题库的题库名查询出此题库对象
    ArrayList<QuestionBank> queryAllQuestionBank(int courseID);                                    //获取某个课程下的所有题库
    Question queryQuestion(int questionID);                                                        //依据某个问题ID获取问题对象
    ArrayList<Question> queryAllQuestion(int questionBankID);                                      //获取某个题库下的所有问题
    Grade queryGrade(int gradeID);                                                                 //依据某个班级ID获取班级对象
    Grade queryGrade(int userID, String gradeName);                                                //依据某个班级的班级名查询出此班级对象
    ArrayList<Grade> queryAllGrade(int userID);                                                    //获取某个用户所拥有的所有班级
    Exam queryExam(int examID);                                                                    //依据某个测试ID获取测试对象
    Exam queryExam(Exam exam);                                                                     //依据某个测试信息查询出此测试对象
    ArrayList<Exam> queryAllExam(int gradeID);                                                     //获取某个班级关联的所有测试

    boolean updateCourse(Course course);                                                           //更新某个课程
    boolean updateQuestinBank(QuestionBank questionBank);                                          //更新某个题库
    boolean updateQuestion(Question question);                                                     //更新某个问题
    boolean updateGrade(Grade grade);                                                              //更新某个班级
    boolean updateExam(Exam exam);                                                                 //更新某个测试

    boolean addCourse(int userID, Course course);                                                  //添加一个课程
    boolean addQuestionBank(int courseID, QuestionBank questionBank);                              //添加一个题库
    boolean addQuestion(int questionBankID, Question question);                                    //添加一个问题
    boolean addGrade(int userID, Grade grade);                                                     //添加一个班级
    boolean addExam(Exam exam);                                                                    //添加一个测试

    boolean deleteCourse(int courseID);                                                            //依据课程ID删除一个课程
    boolean deleteQuestionBank(int questionBankID);                                                //依据题库ID删除一个题库
    boolean deleteQuestion(int questionID);                                                        //依据问题ID删除一个问题
    boolean deleteAllQuestion(int questionBankID);                                                 //依据题库ID删除所有问题
    boolean deleteGrade(int gradeID);                                                              //依据班级ID删除一个班级
    boolean deleteAllStudent(int gradeID);                                                         //依据班级ID删除所有学生
    boolean deleteExam(int examID);                                                                //依据测试ID删除一个测试


    ArrayList<Course> queryAllCourse();                                                            //查询系统中所有的课程
    ArrayList<Grade> queryAllGrade();                                                              //查询系统中所有的班级
    ArrayList<QuestionBank> queryAllQuestionBank();                                                //查询系统中所有的题库
    ArrayList<Question> queryAllQuestion();                                                        //查询系统中所有的题目
    ArrayList<Exam> queryAllExam();                                                                //查询所有的测试
    ArrayList<Teacher> queryAllTeacher();                                                          //获取所有教师对象
    ArrayList<Student> queryAllStudent();                                                          //获取所有学生对象
    Teacher queryTeacher(int userID);                                                              //查询某个教师对象
    Manager queryManager(int userID);                                                              //查询某个管理员对象
    Student queryStudent(int userID);                                                              //查询某个学生对象

    boolean addStudent(Student student);                                                           //添加一个学生
    boolean addTeacher(Teacher teacher);                                                           //添加一个教师

    boolean updateUser(int userID, String password);                                               //更新用户信息

    ArrayList<Student> queryAllStudent(int gradeID);                                               //获取所有学生对象
    boolean deleteStudent(int userID);                                                             //依据用户ID删除一个用户

    boolean checkUser(String username);                                                            //检查系统中是否存在username的用户
    int checkUser(String username, String password);                                               //检查系统中username用户的密码是否正确
    User queryIdentity(int userID);                                                                //依据用户ID查询用户对象

    boolean resetUser(String username);                                                            //只知道用户名的情况下重置用户

    int queryQuestionBankCourseID(int questionBankID);                                             //通过题库ID查找对应课程ID
    int queryQuestionQuestionBankID(int questionID);                                               //通过题目ID查找对应题库ID
}