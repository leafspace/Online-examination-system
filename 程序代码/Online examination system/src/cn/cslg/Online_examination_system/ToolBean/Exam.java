package cn.cslg.Online_examination_system.ToolBean;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Exam {
	public int examID;
	public int gradeID;
	public int questionBankID;
	public String examName;
	public String examTime;
	public int examMinutes;
	public int examStratMinutes;
	public int judgeNumber;
	public int morechoiceNumber;
	public int onechoiceNumber;
	public double judgeScore;
	public double morechoiceScore;
	public double onechoiceScore;

	public Exam(int examID, int gradeID, int questionBankID, String examName, String examTime, int examMinutes, int examStratMinutes,
				int judgeNumber, int morechoiceNumber, int onechoiceNumber, double judgeScore, double morechoiceScore, double onechoiceScore) {
		this.examID = examID;
		this.gradeID = gradeID;
		this.questionBankID = questionBankID;
		this.examName = examName;
		this.examTime = examTime;
		this.examMinutes = examMinutes;
		this.examStratMinutes = examStratMinutes;
		this.judgeNumber = judgeNumber;
		this.morechoiceNumber = morechoiceNumber;
		this.onechoiceNumber = onechoiceNumber;
		this.judgeScore = judgeScore;
		this.morechoiceScore = morechoiceScore;
		this.onechoiceScore = onechoiceScore;
	}

	public void setParameter(int examID, int gradeID, int questionBankID, String examName, String examTime, int examMinutes, int examStratMinutes,
						int judgeNumber, int morechoiceNumber, int onechoiceNumber, double judgeScore, double morechoiceScore, double onechoiceScore) {
		this.examID = examID;
		this.gradeID = gradeID;
		this.questionBankID = questionBankID;
		this.examName = examName;
		this.examTime = examTime;
		this.examMinutes = examMinutes;
		this.examStratMinutes = examStratMinutes;
		this.judgeNumber = judgeNumber;
		this.morechoiceNumber = morechoiceNumber;
		this.onechoiceNumber = onechoiceNumber;
		this.judgeScore = judgeScore;
		this.morechoiceScore = morechoiceScore;
		this.onechoiceScore = onechoiceScore;
	}
}