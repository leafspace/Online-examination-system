package cn.cslg.Online_examination_system.ActionForm;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/23.
 * LastEdit: 2017-5-23
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class SendEmailActionForm extends ActionForm {
    private String eMail;

    public String geteMail() {
        return this.eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        if(this.eMail == null) {
            this.eMail = "";
        }

        this.eMail.trim();
        return null;
    }
}
