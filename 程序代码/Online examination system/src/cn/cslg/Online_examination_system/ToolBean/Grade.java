package cn.cslg.Online_examination_system.ToolBean;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-21
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Grade {
	private int gradeID;
	private String gradeName;

    /**
     * @param gradeName 班级名
     * @function 非全参构造方法
     * 		用于在用户添加班级时构造一个班级对象
     * */
	public Grade(String gradeName) {
	    this.gradeID = -1;
	    this.gradeName = gradeName;
    }

	public Grade(int gradeID, String gradeName) {
		this.gradeID = gradeID;
		this.gradeName = gradeName;
	}

	public int getGradeID() {
		return this.gradeID;
	}

	public String getGradeName() {
		return this.gradeName;
	}

}