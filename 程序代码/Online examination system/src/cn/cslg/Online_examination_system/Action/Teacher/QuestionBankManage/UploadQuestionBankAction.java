package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.UploadQuestionBankActionForm;

import org.apache.struts.action.Action;
import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadQuestionBankAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {
        UploadQuestionBankActionForm uploadQuestionBankActionForm = (UploadQuestionBankActionForm) form;
        FormFile formFile = uploadQuestionBankActionForm.getUploadFile();
        String filePath = "F:\\StudentClass\\J2EE\\Curriculum Design\\程序代码\\Online examination system\\web\\WEB-INF\\upload\\";
        File exl = new File(filePath + formFile.getFileName());
        FileOutputStream fout = new FileOutputStream(exl);
        fout.write(formFile.getFileData());
        fout.flush();
        fout.close();
        return mapping.findForward("success");
    }
}
