package cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage;

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
public class UpdateGradeActionForm extends ActionForm {
    private String gradeID;
    private String gradeName;

    public String getGradeID() {
        return this.gradeID;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
