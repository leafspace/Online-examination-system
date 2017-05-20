package cn.cslg.Online_examination_system.ActionForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class LoginActionForm extends ActionForm {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * @return 错误信息列表
    * @function 在此actionForm中不对数据进行验证，而做数据正确化处理，确保数据传递下去能够正常使用
    **/
    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        if(this.username == null) {
            this.username = "";
        }

        if(this.password == null) {
            this.password = "";
        }

        this.username.trim();
        this.password.trim();

        return null;
    }
}
