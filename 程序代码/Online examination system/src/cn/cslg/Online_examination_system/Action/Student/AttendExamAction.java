package cn.cslg.Online_examination_system.Action.Student;

import cn.cslg.Online_examination_system.ToolBean.Student;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/5/28.
 * LastEdit: 2017-5-28
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class AttendExamAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Student student = (Student) request.getSession().getAttribute("user");

        return mapping.findForward("");
    }
}
