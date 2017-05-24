package cn.cslg.Online_examination_system.Action;

import cn.cslg.Online_examination_system.ActionForm.LoginActionForm;

import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;
import cn.cslg.Online_examination_system.ToolBean.User;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-22
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        InterfaceDatabaseProxy interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
        LoginActionForm loginActionForm = (LoginActionForm) form;

        if(loginActionForm.getRemember() != null) {
            request.setAttribute("username", loginActionForm.getUsername());                       //如果用户点击了记住我，则保存用户名
        }

        if(interfaceDatabaseProxy.checkUser(loginActionForm.getUsername())) {                      //检查此用户是否存在
            int userID;
            if((userID = interfaceDatabaseProxy.checkUser(loginActionForm.getUsername(), loginActionForm.getPassword())) != -1) {//检查用户名密码是否正确
                User user = interfaceDatabaseProxy.queryIdentity(userID);
                request.getSession().setAttribute("user", user);                                   //保存到作用域内，提供后面的页面使用
                if(user.isManager()) {
                    return mapping.findForward("managerIndex");
                } else if(user.isStudent()) {
                    return mapping.findForward("studentIndex");
                } else if(user.isTeacher()) {
                    return mapping.findForward("teacherIndex");
                }
            } else {
                request.setAttribute("error", "用户名密码不匹配！");
            }
        } else {
            request.setAttribute("error", "不存在此用户");
        }
        return mapping.findForward("error");
    }
}
