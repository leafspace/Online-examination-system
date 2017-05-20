package cn.cslg.Online_examination_system.ToolBean;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Question {
	private int questionID;
	private String questionType;
	public String question;
	public String A;
	public String B;
	public String C;
	public String D;
	public String E;
	public String answer;

	public Question(int questionID, String questionType) {
	    this.questionID = questionID;
	    this.questionType = questionType;
    }

    public Question(int questionID, String questionType, String question, String A, String B, String C, String D, String E, String answer) {
        this.questionID = questionID;
        this.questionType = questionType;
        this.question = question;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.answer = answer;
    }

    public void setParameter(int questionID, String questionType, String question, String A, String B, String C, String D, String E, String answer) {
        this.questionID = questionID;
        this.questionType = questionType;
        this.question = question;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.answer = answer;
    }

	public int getQuestionID() {
		return this.questionID;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public boolean isJudge() {
		return this.questionType.equals("Judge");
	}

	public boolean isOneChoice() {
		return this.questionType.equals("OneChoice");
	}

	public boolean isMoreChoice() {
		return this.questionType.equals("MoreChoice");
	}
}