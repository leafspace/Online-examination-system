package cn.cslg.Online_examination_system.ToolBean;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ContactInformation {
    private int userID;
    private String type;
    private String information;

    public ContactInformation(int userID, String information) {
        this.userID = userID;
        this.information = information;
    }

    public ContactInformation(int userID, String type, String information) {
        this(userID, information);
        this.type = type;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getType() {
        return this.type;
    }

    public String getInformation() {
        return this.information;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
