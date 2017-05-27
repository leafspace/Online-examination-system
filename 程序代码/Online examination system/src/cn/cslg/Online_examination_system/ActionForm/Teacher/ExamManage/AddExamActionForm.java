package cn.cslg.Online_examination_system.ActionForm.Teacher.ExamManage;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class AddExamActionForm extends ActionForm {
    private String examName;
    private String questionBankID;
    private String[] gradeIDs;
    private String examDate;
    private String examTime;
    private String examMinutes;
    private String examStratMinutes;
    private String oneChoiceNumber;
    private String oneChoiceScore;
    private String judgeNumber;
    private String judgeScore;
    private String moreChoiceNumber;
    private String moreChoiceScore;

    public String getExamName(){
        return this.examName;
    }

    public String getQuestionBankID(){
        return this.questionBankID;
    }

    public String[] getGradeIDs(){
        return this.gradeIDs;
    }
    
    public String getExamDate(){
        return this.examDate;
    }
    
    public String getExamTime(){
        return this.examTime;
    }
    
    public String getExamMinutes(){
        return this.examMinutes;
    }
    
    public String getExamStratMinutes(){
        return this.examStratMinutes;
    }
    
    public String getOneChoiceNumber(){
        return this.oneChoiceNumber;
    }
    
    public String getOneChoiceScore(){
        return this.oneChoiceScore;
    }
    
    public String getJudgeNumber(){
        return this.judgeNumber;
    }
    
    public String getJudgeScore(){
        return this.judgeScore;
    }
    
    public String getMoreChoiceNumber(){
        return this.moreChoiceNumber;
    }
    
    public String getMoreChoiceScore(){
        return this.moreChoiceScore;
    }

    public void setExamName(String examName){
        this.examName = examName;
    }

    public void setQuestionBankID(String questionBankID){
        this.questionBankID = questionBankID;
    }

    public void setGradeIDs(String[] gradeIDs){
        this.gradeIDs = gradeIDs;
    }

    public void setExamDate(String examDate){
        this.examDate = examDate;
    }

    public void setExamTime(String examTime){
        this.examTime = examTime;
    }

    public void setExamMinutes(String examMinutes){
        this.examMinutes = examMinutes;
    }

    public void setExamStratMinutes(String examStratMinutes){
        this.examStratMinutes = examStratMinutes;
    }

    public void setOneChoiceNumber(String oneChoiceNumber){
        this.oneChoiceNumber = oneChoiceNumber;
    }

    public void setOneChoiceScore(String oneChoiceScore){
        this.oneChoiceScore = oneChoiceScore;
    }

    public void setJudgeNumber(String judgeNumber){
        this.judgeNumber = judgeNumber;
    }

    public void setJudgeScore(String judgeScore){
        this.judgeScore = judgeScore;
    }

    public void setMoreChoiceNumber(String moreChoiceNumber){
        this.moreChoiceNumber = moreChoiceNumber;
    }

    public void setMoreChoiceScore(String moreChoiceScore){
        this.moreChoiceScore = moreChoiceScore;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
