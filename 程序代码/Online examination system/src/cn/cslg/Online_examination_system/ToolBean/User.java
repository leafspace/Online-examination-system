package cn.cslg.Online_examination_system.ToolBean;

import cn.cslg.Online_examination_system.DatabaseFactory.DatabaseProxyFactory;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public abstract class User {
	protected int userID;
	protected int gradeID;
	protected String username;
	protected String password;
	protected String identity;
    protected InterfaceDatabaseProxy interfaceDatabaseProxy = null;

    private User() {
        this.interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
    }

	public User(String username, String password, String identity) {
		this();
		this.username = username;
		this.password = password;
		this.identity = identity;
	}

	public User(int userID, int gradeID, String username, String password, String identity) {
        this();
	    this.userID = userID;
	    this.gradeID = gradeID;
	    this.username = username;
	    this.password = password;
	    this.identity = identity;
    }

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}
	
	public int getUserID() {
		return this.userID;
	}

	/**
     * @return gradeName 用户当前所属用户组的名字
     * @function
     *      1.调用数据访问层方法获取gradeID所在的班级对象
     *      2.依据班级对象返回班级名
     * */
	public String getGradeName() {
        InterfaceDatabaseProxy interfaceDatabaseProxy = new DatabaseProxyFactory().getDatabaseProxy("MySQL");
	    Grade grade = interfaceDatabaseProxy.queryGrade(this.gradeID);
		return grade.getGradeName();
	}

	public int getGradeID() {
		return this.gradeID;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getIdentity() {
		return this.identity;
	}
	
	public boolean isManager() {
		return this.identity.equals("Manager");
	}
	
	public boolean isTeacher() {
		return this.identity.equals("Teacher");
	}
	
	public boolean isStudent() {
		return this.identity.equals("Student");
	}
}