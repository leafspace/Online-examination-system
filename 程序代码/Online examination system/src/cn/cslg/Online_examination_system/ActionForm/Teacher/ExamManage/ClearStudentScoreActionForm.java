package cn.cslg.Online_examination_system.ActionForm.Teacher.ExamManage;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ClearStudentScoreActionForm extends ActionForm {
    private String userID;
    private String examID;

    public String getUserID() {
        return this.userID;
    }

    public String getExamID() {
        return this.examID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
