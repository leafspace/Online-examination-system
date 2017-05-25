package cn.cslg.Online_examination_system.ToolBean.Upload;

import cn.cslg.Online_examination_system.ToolBean.Question;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
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

        int sheets = this.poi.getTotalSheets();
    }

}
