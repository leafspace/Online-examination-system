package cn.cslg.Online_examination_system.Action.Teacher.GradeManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.UpdateGradeActionForm;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import cn.cslg.Online_examination_system.ToolBean.Grade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UpdateGradeAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UpdateGradeActionForm updateGradeActionForm = (UpdateGradeActionForm) form;

        int gradeID = Integer.parseInt(updateGradeActionForm.getGradeID());
        String gradeName = updateGradeActionForm.getGradeName();

        teacher.updateGrade(new Grade(gradeID, gradeName));
        return mapping.findForward("gradeIndex");
    }
}
