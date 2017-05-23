package cn.cslg.Online_examination_system.ToolBean.Email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Administrator on 2017/5/23.
 * LastEdit: 2017-5-23
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class MyEmailAutherticator extends Authenticator {
    private String username;
    private String password;

    public MyEmailAutherticator() {
        super();
    }

    public MyEmailAutherticator(String username, String password) {                                //初始化邮箱和密码
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {                                    //用作登录校验，以确保对该邮箱有发送邮件的权利
        return new PasswordAuthentication(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}