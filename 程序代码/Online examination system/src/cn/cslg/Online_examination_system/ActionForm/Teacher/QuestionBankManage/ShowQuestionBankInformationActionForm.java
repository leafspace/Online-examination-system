package cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/24.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowQuestionBankInformationActionForm extends ActionForm {
    private String questionBankID;
    private String type;
    private String courseID;

    public String getQuestionBankID() {
        return this.questionBankID;
    }

    public String getType() {
        return this.type;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setQuestionBankID(String questionBankID) {
        this.questionBankID = questionBankID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCourseID(String courseID) {
        this.courseID  = courseID;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
