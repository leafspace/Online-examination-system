package cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.QuestionManage;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UpdateQuestionActionForm extends ActionForm {
    private String questionID;
    private String question;
    private String questionType;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String choiceE;
    private String answer;
    
    public String getQuestionID() {
        return this.questionID;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public String getA() {
        return this.choiceA;
    }

    public String getB() {
        return this.choiceB;
    }

    public String getC() {
        return this.choiceC;
    }

    public String getD() {
        return this.choiceD;
    }

    public String getE() {
        return this.choiceE;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setA(String A) {
        this.choiceA = A;
    }

    public void setB(String B) {
        this.choiceB = B;
    }

    public void setC(String C) {
        this.choiceC = C;
    }

    public void setD(String D) {
        this.choiceD = D;
    }

    public void setE(String E) {
        this.choiceE = E;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
