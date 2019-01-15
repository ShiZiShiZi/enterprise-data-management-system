package org.hfut.tool.global;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * AddProjectPeopleTool
 *
 * @author WeiXin
 * @date 2019/1/14
 **/
public class AddProjectPeopleTool {

    private static final String EMAIL_SMTP_HOST = "smtp.qq.com";
    private static final String EMAIL_ACCOUNT = "1056114084@qq.com";
    private static final String STMP_AUTHORIZATION_CODE = "oqjajtmdcyqdbgac";
    private static final String REGISTER_URL = "http://localhost:8081/register/";


    public static void sendEmail(String targetAddress, String targetName, String inviterName, String position,
                                 Integer waitingRegisterPeopleId,
                                 Byte permission) throws GeneralSecurityException, MessagingException, UnsupportedEncodingException {
        MailSSLSocketFactory factory = new MailSSLSocketFactory();
        Properties properties = new Properties();
        StringBuilder content = new StringBuilder();
        Transport transport;
        Session session;
        Message message;

        factory.setTrustAllHosts(true);

        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", 465);
        properties.setProperty("mail.smtp.host", EMAIL_SMTP_HOST);
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", factory);

        session = Session.getInstance(properties);
        message = new MimeMessage(session);

        message.setSubject("【企业数据管理系统】");
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(EMAIL_ACCOUNT, "企业数据管理系统", "UTF-8"));
        content.append("\n尊敬的").append(targetName).append(":");
        content.append("\n    经由").append(inviterName).append("的推荐，");
        content.append("\n您被邀请至我司任").append(position).append("一职。");
        content.append("\n请点击下方链接进行注册，注册有效期为7天。");
        content.append("\n\n").append(REGISTER_URL).append(Token.getToken(waitingRegisterPeopleId, permission, 7 * 24));
        message.setText(content.toString());

        transport = session.getTransport();
        transport.connect(EMAIL_SMTP_HOST, EMAIL_ACCOUNT, STMP_AUTHORIZATION_CODE);
        transport.sendMessage(message, new Address[]{new InternetAddress(targetAddress)});
        transport.close();
    }
}
