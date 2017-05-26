package cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage;

import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadGradeActionForm extends ActionForm {
    private String gradeName;
    private FormFile uploadFile;

    public String getGradeName() {
        return this.gradeName;
    }

    public FormFile getUploadFile() {
        return this.uploadFile;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public void setUploadFile(FormFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
