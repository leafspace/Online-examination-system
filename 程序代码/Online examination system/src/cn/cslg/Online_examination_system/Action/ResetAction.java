package cn.cslg.Online_examination_system.Action;

import cn.cslg.Online_examination_system.ActionForm.ResetActionForm;
import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;
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
public class ResetAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        InterfaceDatabaseProxy interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
        ResetActionForm resetActionForm = (ResetActionForm) form;

        if(!interfaceDatabaseProxy.resetUser(resetActionForm.getUsername())) {
            request.setAttribute("error", "用户信息未成功重置！");
        }
        return mapping.findForward("loginIndex");
    }
}
