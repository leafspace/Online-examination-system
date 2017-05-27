package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.UploadQuestionBankActionForm;
import cn.cslg.Online_examination_system.ToolBean.Upload.CreateQuestions;
import cn.cslg.Online_examination_system.ToolBean.QuestionBank;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.Date;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadQuestionBankAction extends Action {
    private String getNoRepeat(int userID) {
        String filePath = "F:\\StudentClass\\J2EE\\Curriculum Design\\程序代码\\Online examination system\\web\\WEB-INF\\upload\\";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return filePath + userID + dateFormat.format(new Date()) + this.getRandomString(15);
    }

    private String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";             //含有字符和数字的字符串
        Random random = new Random();                                                              //随机类初始化
        StringBuffer stringBuffer = new StringBuffer();                                            //StringBuffer类生成，为了拼接字符串

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }
        return stringBuffer.toString();
    }

    private boolean isRepeatName(String questionBankName, ArrayList<QuestionBank> questionBanks) {
        for(QuestionBank i : questionBanks) {
            if(i.getQuestionBankName() == questionBankName) {
                return true;
            }
        }
        return false;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UploadQuestionBankActionForm uploadQuestionBankActionForm = (UploadQuestionBankActionForm) form;

        FormFile formFile = uploadQuestionBankActionForm.getUploadFile();
        String filePath = this.getNoRepeat(teacher.getUserID()) + formFile.getFileName();
        File exl = new File(filePath);
        FileOutputStream fout = new FileOutputStream(exl);
        fout.write(formFile.getFileData());
        fout.flush();
        fout.close();

        ArrayList<Question> questions = new CreateQuestions(filePath).createQuestions();
        String questionBankName = uploadQuestionBankActionForm.getQuestionBankName();
        ArrayList<QuestionBank> questionBanks = teacher.queryAllQuestionBank();

        if(questionBankName == null | questionBankName.length() == 0) {
            questionBankName = this.getRandomString(15);
        }

        if(this.isRepeatName(questionBankName, questionBanks)) {
            request.setAttribute("type", "add");
            request.setAttribute("error", "您已有相同的题库名");
            return mapping.findForward("error");
        }

        int questionBankID = teacher.addQuestionBank(Integer.parseInt(uploadQuestionBankActionForm.getCourseID()), questionBankName, questions);
        QuestionBank questionBank = teacher.queryQuestionBank(questionBankID);
        questions = teacher.queryAllQuestion(questionBankID);
        request.setAttribute("questionBank", questionBank);
        request.setAttribute("questions", questions);
        return mapping.findForward("questionBankInformation");
    }
}
