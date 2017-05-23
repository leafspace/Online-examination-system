package cn.cslg.Online_examination_system.ActionForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-22
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ResetActionForm extends ActionForm {
    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        if(this.username == null) {
            this.username = "";
        }
        this.username.trim();
        return null;
    }
}
