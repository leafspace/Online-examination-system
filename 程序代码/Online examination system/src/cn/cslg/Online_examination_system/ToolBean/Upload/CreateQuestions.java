package cn.cslg.Online_examination_system.ToolBean.Upload;

import cn.cslg.Online_examination_system.ToolBean.Question;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class CreateQuestions {
    private String filePath = null;
    private ImportExcel poi = new ImportExcel();
    public CreateQuestions(String filePath) {
        this.filePath = filePath;
        boolean isSuccess = poi.read(this.filePath) != null;
        if(!isSuccess) {
            this.poi = null;
        }
    }

    public ArrayList<Question> createQuestions() {
        if(this.poi == null) {
            return null;
        }

        ArrayList<Question> questions = new ArrayList<>();
        int sheets = this.poi.getTotalSheets();
        for(int i = 0; i < sheets; ++i) {
            for(int j = 1; j < this.poi.getTotalRows(i); ++j) {
                String question = null;
                String questionType = "";
                String answer = null;
                String choiceA = null;
                String choiceB = null;
                String choiceC = null;
                String choiceD = null;
                String choiceE = null;
                question = this.poi.getSheetsData(i, j, 1);
                if(this.poi.getTotalCells(i) == 7) {
                    questionType = "OneChoice";
                    choiceA = this.poi.getSheetsData(i, j, 2);
                    choiceB = this.poi.getSheetsData(i, j, 3);
                    choiceC = this.poi.getSheetsData(i, j, 4);
                    choiceD = this.poi.getSheetsData(i, j, 5);
                    answer = this.poi.getSheetsData(i, j, 6);
                } else if(this.poi.getTotalCells(i) == 8) {
                    questionType = "MoreChoice";
                    choiceA = this.poi.getSheetsData(i, j, 2);
                    choiceB = this.poi.getSheetsData(i, j, 3);
                    choiceC = this.poi.getSheetsData(i, j, 4);
                    choiceD = this.poi.getSheetsData(i, j, 5);
                    choiceE = this.poi.getSheetsData(i, j, 6);
                    answer = this.poi.getSheetsData(i, j, 7);
                } else if(this.poi.getTotalCells(i) == 3) {
                    questionType = "Judge";
                    answer = this.poi.getSheetsData(i, j, 2);
                }
                questions.add(new Question(questionType, question, choiceA, choiceB, choiceC, choiceD, choiceE, answer));
            }
        }

        return questions;
    }

}
