package cn.cslg.Online_examination_system.Action.Teacher.GradeManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.UploadGradeActionForm;
import cn.cslg.Online_examination_system.ToolBean.Upload.CreateStudents;
import cn.cslg.Online_examination_system.ToolBean.Grade;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.io.File;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UploadGradeAction extends Action {
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

    private boolean isRepeatName(String gradeName, ArrayList<Grade> grades) {
        for(Grade i : grades) {
            if(i.getGradeName() == gradeName) {
                return true;
            }
        }
        return false;
    }
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UploadGradeActionForm uploadGradeActionForm = (UploadGradeActionForm) form;

        FormFile formFile = uploadGradeActionForm.getUploadFile();
        String filePath = this.getNoRepeat(teacher.getUserID()) + formFile.getFileName();
        File exl = new File(filePath);
        FileOutputStream fout = new FileOutputStream(exl);
        fout.write(formFile.getFileData());
        fout.flush();
        fout.close();

        ArrayList<Student> students = new CreateStudents(filePath).createStudents();
        String gradeName = uploadGradeActionForm.getGradeName();
        ArrayList<Grade> grades = teacher.queryAllGrade();

        if(gradeName == null | gradeName.length() == 0) {
            gradeName = this.getRandomString(15);
        }

        if(this.isRepeatName(gradeName, grades)) {
            request.setAttribute("error", "您已有相同的班级名");
            return mapping.findForward("error");
        }

        int gradeID = teacher.addGrade(gradeName, students);
        return mapping.findForward("gradeIndex");
    }
}
