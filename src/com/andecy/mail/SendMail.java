package com.andecy.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
    String host = "";
    String user = "";
    String password = "";
    public void setHost(String host) {
        this.host = host;
    }
    public void setAccount(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public void send(String from, String to, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // ָ��SMTP������
        props.put("mail.smtp.auth", "true"); // ָ���Ƿ���ҪSMTP��֤
        try {
            Session mailSession = Session.getDefaultInstance(props);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from)); // ������
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // �ռ���
            message.setSubject(subject); // �ʼ�����
            message.setText(content); // �ʼ�����
            message.saveChanges();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
