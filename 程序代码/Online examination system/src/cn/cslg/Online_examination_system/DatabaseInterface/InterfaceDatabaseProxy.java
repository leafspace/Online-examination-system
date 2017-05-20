package cn.cslg.Online_examination_system.DatabaseInterface;

import cn.cslg.Online_examination_system.ToolBean.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */

public interface InterfaceDatabaseProxy {
    Course queryCourse(int courseID);                                                              //依据某个课程ID获取课程对象
    ArrayList<Course> queryAllCourse(int userID);                                                  //获取某个教师所拥有的所有课程
    QuestionBank queryQuestionBank(int questionBankID);                                            //依据某个题库ID获取题库对象
    ArrayList<QuestionBank> queryAllQuestionBank(int courseID);                                    //获取某个课程下的所有题库
    Question queryQuestion(int questionID);                                                        //依据某个问题ID获取问题对象
    ArrayList<Question> queryAllQuestion(int questionBankID);                                      //获取某个题库下的所有问题
    Grade queryGrade(int gradeID);                                                                 //依据某个班级ID获取班级对象
    ArrayList<Grade> queryAllGrade(int userID);                                                    //获取某个用户所拥有的所有班级
    Exam querrExam(int examID);                                                                    //依据某个测试ID获取测试对象
    ArrayList<Exam> queryAllExam(int userID);                                                      //获取某个用户所创建的所有测试

    boolean updateCourse(Course course);                                                           //更新某个课程
    boolean updateQuestinBank(QuestionBank questionBank);                                          //更新某个题库
    boolean updateQuestion(Question question);                                                     //更新某个问题
    boolean updateGrade(Grade grade);                                                              //更新某个班级
    boolean updateExam(Exam exam);                                                                 //更新某个测试

    boolean addCourse(Course course);                                                              //添加一个课程
    boolean addQuestionBank(QuestionBank questionBank);                                            //添加一个题库
    boolean addQuestion(QuestionBank questionBank);                                                //添加一个问题
    boolean addGrade(Grade grade);                                                                 //添加一个班级
    boolean addExam(Exam exam);                                                                    //添加一个测试

    boolean deleteCourse(int courseID);                                                            //依据课程ID删除一个课程
    boolean deleteQuestionBank(int questionBankID);                                                //依据题库ID删除一个题库
    boolean deleteQuestion(int questionID);                                                        //依据问题ID删除一个问题
    boolean deleteGrade(int gradeID);                                                              //依据班级ID删除一个班级
    boolean deleteExam(int examID);                                                                //依据测试ID删除一个测试


    ArrayList<Teacher> queryAllTeacher();                                                          //获取所有教师对象
    ArrayList<Student> queryAllStudent();                                                          //获取所有学生对象

    boolean addStudent(Student student);                                                           //添加一个学生
    boolean addTeacher(Teacher teacher);                                                           //添加一个教师
}