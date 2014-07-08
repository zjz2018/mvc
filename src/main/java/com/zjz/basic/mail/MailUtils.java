package com.zjz.basic.mail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class MailUtils {
	private static final String hostName = "smtp.163.com";
	private static final String userName ="你的邮箱账号";
	private static final String password ="你的密码";
	private static final String from = "你的邮箱账号";
	private static final String to = "接收邮件的账号";
	private static final String charset = "utf-8";
	
	//simple
	public static void sendSimple(String subject,String msg){
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName(hostName);
			email.setFrom(from);
			email.addTo(to);
			email.setAuthentication(userName, password);
			email.setCharset(charset);
			email.setSubject(subject);
			email.setMsg(msg);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	//html
	public static  void sendHTML(String subject,String msg){
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(hostName);
			email.setFrom(from);
			email.addTo(to);
			email.setAuthentication(userName, password);
			email.setCharset(charset);
			email.setSubject(subject);
			email.setMsg(msg);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	//attach
	public static void sendAttach(String subject,String msg){
		try {
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName(hostName);
			email.setFrom(from);
			email.addTo(to);
			email.setAuthentication(userName, password);
			email.setCharset(charset);
			email.setSubject(subject);
			email.setMsg(msg);
			
			
			EmailAttachment attach = new EmailAttachment();
			attach.setPath("");
			attach.setDisposition(EmailAttachment.ATTACHMENT);
			attach.setName("a");
			email.attach(attach);
			
			
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		MailUtils mail = new MailUtils();
		String site = "http://searchex.yixun.com/html?path=706019t706023&attr=55e3506&area=1&sort=0&show=0&size=40&pf=0&as=0&charset=utf-8&YTAG=3.706023241101&sf=1#list";
		mail.sendHTML("测试", "<p><a href='"+site+"'>易迅抢购</a></p>");
		System.out.println("over");
	}
}