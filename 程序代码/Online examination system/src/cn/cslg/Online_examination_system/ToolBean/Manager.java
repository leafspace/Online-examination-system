package cn.cslg.Online_examination_system.ToolBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Manager extends User {
	public Manager(int userID, int gradeID, String username, String password, String identity) {
		super(userID, gradeID, username, password, identity);
	}

	public Teacher queryTeacher(int userID) {
	    return this.interfaceDatabaseProxy.queryTeacher(userID);
    }

	public ArrayList<Teacher> queryAllTeacher() {
	    return this.interfaceDatabaseProxy.queryAllTeacher();
    }

	public boolean addTeacher(Teacher teacher) {
		return this.interfaceDatabaseProxy.addTeacher(teacher);
	}
}