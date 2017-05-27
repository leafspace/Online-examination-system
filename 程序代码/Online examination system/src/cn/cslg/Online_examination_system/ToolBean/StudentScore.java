package cn.cslg.Online_examination_system.ToolBean;

/**
 * Created by Administrator on 2017/5/27.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class StudentScore {
    private int userID;
    private int examID;
    private String userName;
    private String examName;
    private int score;

    public StudentScore(int userID, int examID, String userName, String examName) {
        this.userID = userID;
        this.examID = examID;
        this.userName = userName;
        this.examName = examName;
    }

    public StudentScore(int userID, int examID, String userName, String examName, int score) {
        this.userID = userID;
        this.examID = examID;
        this.userName = userName;
        this.examName = examName;
        this.score = score;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getExamID() {
        return this.examID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getExamName() {
        return this.examName;
    }

    public int getScore() {
        return this.score;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
