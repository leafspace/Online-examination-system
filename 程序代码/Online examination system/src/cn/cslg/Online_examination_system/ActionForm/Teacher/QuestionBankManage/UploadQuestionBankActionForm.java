package cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadQuestionBankActionForm extends ActionForm {
    private FormFile uploadFile;
    public FormFile getUploadFile() {
        return this.uploadFile;
    }

    public void setUploadFile(FormFile formFile) {
        this.uploadFile = formFile;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
