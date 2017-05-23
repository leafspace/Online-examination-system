package cn.cslg.Online_examination_system.ToolBean.Email;

import java.util.Date;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * Created by Administrator on 2017/5/23.
 * LastEdit: 2017-5-23
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class Mail {
    private String username="18852923073@163.com";                                                   //发送邮件的帐号和密码
    private String password="m967812";
    private String host = "smtp.163.com";
    private String mail_head_name = "在线考试系统 | 重置密码服务";
    private String mail_head_value = "在线考试系统 | 重置密码服务";
    private String mail_to = "18852923073@163.com";
    private String mail_from = "18852923073@163.com";
    private String mail_subject = "在线考试系统 | 重置密码服务";
    private String mail_body = "本邮件用于在线考试系统重置密码用，如果不是本人操作，请忽略本邮件！";
    private String personalName = "在线考试系统";

    public void setTarget(String email) {
        this.mail_to = email;
    }

    public void setMail(String mail) {
        this.mail_body += "\n";
        this.mail_body += mail;
    }

    public void sendMail() throws SendFailedException{
        try {
            Properties props = new Properties();                                                   //发送邮件的props文件
            props.put("mail.smtp.host", this.host);
            props.put("mail.smtp.auth", "true");
            System.out.println(props);

            Authenticator auth = new MyEmailAutherticator(this.username, this.password);           //进行邮件服务用户认证
            Session session = Session.getDefaultInstance(props, auth);                             //创建session,和邮件服务器进行通讯
            MimeMessage message = new MimeMessage(session);                                        //创建mime类型邮件
            message.setContent("Hello","text/html;charset=utf-8");                        //设置邮件格式
            message.setSubject(this.mail_subject);                                                 //设置主题
            message.setText(this.mail_body);                                                       //设置邮件内容
            message.setHeader(this.mail_head_name, this.mail_head_value);                          //设置邮件标题
            message.setSentDate(new Date());                                                       //设置邮件发送时期
            Address address = new InternetAddress(this.mail_from, this.personalName);
            message.setFrom(address);                                                              //设置邮件发送者的地址

            Address toaddress = new InternetAddress(this.mail_to);                                 //设置邮件接收者的地址
            message.addRecipient(Message.RecipientType.TO, toaddress);                             //设置收件人
            System.out.println(message);
            Transport.send(message);                                                               //发送邮件
            System.out.println("Send Mail Ok!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}