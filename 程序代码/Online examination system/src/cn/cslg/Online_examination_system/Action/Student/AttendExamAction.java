package cn.cslg.Online_examination_system.Action.Student;

import cn.cslg.Online_examination_system.ActionForm.Student.AttendExamActionForm;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Exam;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


/**
 * Created by Administrator on 2017/5/28.
 * LastEdit: 2017-5-28
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class AttendExamAction extends Action {
    private int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    private ArrayList<Question> getExamPapar(ArrayList<Question> questions, int number) {
        ArrayList<Question> typeQuestions = new ArrayList<>();

        while(typeQuestions.size() != number) {
            int randomNumber = this.randomNumber(0, questions.size() - 1);
            int i;
            for(i = 0; i < typeQuestions.size(); ++i) {
                if(typeQuestions.get(i).getQuestionID() == questions.get(randomNumber).getQuestionID()) {
                    break;
                }
            }
            if(i >= typeQuestions.size()) {
                typeQuestions.add(questions.get(randomNumber));
            }
        }

        return typeQuestions;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if(request.getSession().getAttribute("attendToken") != null) {
            return mapping.findForward("attendExam");
        }

        Student student = (Student) request.getSession().getAttribute("user");
        AttendExamActionForm attendExamActionForm = (AttendExamActionForm) form;
        int examID = Integer.parseInt(attendExamActionForm.getExamID());
        Exam exam = student.queryExam(examID);

        String examTime = exam.examTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = dateFormat.format(new Date());

        if(this.compareDate(nowTime, examTime) < 0) {
            request.setAttribute("error", "现在还不是考试时间！");
            return mapping.findForward("error");
        }

        int questionBankID = exam.questionBankID;
        ArrayList<Question> questions = student.queryAllQuestion(questionBankID);
        ArrayList<Question> oneChoiceQuestion = new ArrayList<>();
        ArrayList<Question> moreChoiceQuestion = new ArrayList<>();
        ArrayList<Question> judgeQuestion = new ArrayList<>();
        for(Question question : questions) {
            switch (question.getQuestionType())
            {
                case "OneChoice": oneChoiceQuestion.add(question); break;
                case "MoreChoice" : moreChoiceQuestion.add(question); break;
                case "Judge" : judgeQuestion.add(question); break;
                default: break;
            }
        }

        ArrayList<Question> oneChoicePapar = this.getExamPapar(oneChoiceQuestion, exam.onechoiceNumber);
        ArrayList<Question> moreChoicePapar = this.getExamPapar(moreChoiceQuestion, exam.morechoiceNumber);
        ArrayList<Question> judgePapar = this.getExamPapar(judgeQuestion, exam.judgeNumber);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String finishTime = simpleDateFormat.format(new Date(date.getTime() + exam.examMinutes * 60 * 1000));
        Date finishDate = simpleDateFormat.parse(finishTime);

        request.getSession().setAttribute("exam", exam);
        request.getSession().setAttribute("finishDate", finishDate);
        request.getSession().setAttribute("oneChoicePapar", oneChoicePapar);
        request.getSession().setAttribute("moreChoicePapar", moreChoicePapar);
        request.getSession().setAttribute("judgePapar", judgePapar);
        request.getSession().setAttribute("attendToken", true);

        return mapping.findForward("attendExam");
    }
}
