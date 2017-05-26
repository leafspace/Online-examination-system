package cn.cslg.Online_examination_system.ToolBean.Upload;

import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Student;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class CreateStudents {
    private String filePath = null;
    private ImportExcel poi = new ImportExcel();
    public CreateStudents(String filePath) {
        this.filePath = filePath;
        boolean isSuccess = poi.read(this.filePath) != null;
        if(!isSuccess) {
            this.poi = null;
        }
    }

    public ArrayList<Student> createStudents() {
        if(this.poi == null) {
            return null;
        }

        ArrayList<Student> students = new ArrayList<>();
        int sheets = this.poi.getTotalSheets();
        for(int i = 0; i < sheets; ++i) {
            for(int j = 1; j < this.poi.getTotalRows(i); ++j) {
                if(this.poi.getTotalCells(i) == 3) {
                    String username = this.poi.getSheetsData(i, j, 1);
                    String password = this.poi.getSheetsData(i, j, 2);
                    Student student = new Student(username, password, "Student");
                    students.add(student);
                }
            }
        }

        return students;
    }

}
