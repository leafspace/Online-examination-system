package cn.cslg.Online_examination_system.Action;

import cn.cslg.Online_examination_system.ActionForm.SendEmailActionForm;
import cn.cslg.Online_examination_system.ToolBean.Email.Mail;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/23.
 * LastEdit: 2017-5-23
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class SendEmailAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SendEmailActionForm sendEmailActionForm = (SendEmailActionForm) form;
        try {
            String mailAddress = sendEmailActionForm.geteMail();
            if(mailAddress.length() == 0) {
                request.setAttribute("error", "请输入正确的E-mial地址！");
            } else {
                Mail mail = new Mail();
                String eMailBody = "http://localhost:8080/reset.do?username=" + mailAddress.substring(0, mailAddress.indexOf('@'));
                mail.setTarget(mailAddress);
                mail.setMail("请点击下方链接重置您的密码（新密码为123456）：\n" + eMailBody + "\n注：完成后自动为您跳转到登陆界面");
                mail.sendMail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward("loginIndex");
    }
}
