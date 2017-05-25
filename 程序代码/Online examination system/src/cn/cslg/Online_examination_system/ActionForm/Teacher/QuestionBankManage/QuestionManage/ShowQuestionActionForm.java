package cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.QuestionManage;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowQuestionActionForm extends ActionForm {
    private String questionID;

    public String getQuestionID() {
        return this.questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
