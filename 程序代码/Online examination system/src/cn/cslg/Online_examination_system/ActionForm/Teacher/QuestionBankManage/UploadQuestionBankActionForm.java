package cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage;

import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadQuestionBankActionForm extends ActionForm {
    private FormFile uploadFile;
    private String questionBankName;
    private String courseID;

    public FormFile getUploadFile() {
        return this.uploadFile;
    }

    public String getQuestionBankName() {
        return this.questionBankName;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setUploadFile(FormFile formFile) {
        this.uploadFile = formFile;
    }

    public void setQuestionBankName(String questionBankName) {
        this.questionBankName = questionBankName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
