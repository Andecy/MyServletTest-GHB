package com.andecy.bean;

import com.andecy.mail.SendMail;

public final class Constant {
	
	public static final int ACCOUNT_LENGTH = 10;
	public static final int CODE_LENGTH = 4;
	
	public static final int TEST_OK = 20;
	public static final int TEST_FAIL = 29;
	public static final int TEST_ERROR_NAMES = 21;
	public static final int TEST_ERROR_EMAILS = 22;
	public static final int TEST_ERROR_FALSE = 23;
	public static final int TEST_ERROR_TRUE = 24;
	public static final int TEST_ERROR_TIMEOUT = 25;
	public static final int TEST_NULL = 26;
	public static final int TEST_REPEAT = 27;
	
	public static int sendRegEMail(int num, String email, String name) {

		SendMail sm = new SendMail();
		sm.setHost("smtp.exmail.qq.com"); // ָ��Ҫʹ�õ��ʼ�������
		sm.setAccount("register@gtalk.xyz", "g12345"); // ָ���ʺź�����
		sm.send("register@gtalk.xyz", email, "����һ�������GTalkע�ᣡ", "�װ���" + name
				+ "����л��ע��GTalk��������֤���ǣ�" + num);
		return num;
	}
	
	public static int sendForgottenEMail(int num, String email, String name) {

		SendMail sm = new SendMail();
		sm.setHost("smtp.exmail.qq.com"); // ָ��Ҫʹ�õ��ʼ�������
		sm.setAccount("register@gtalk.xyz", "g12345"); // ָ���ʺź�����
		sm.send("register@gtalk.xyz", email, "����һ�������GTalk�������ã�", "�װ���" + name
				+ "������GTalk����������֤���ǣ�" + num);
		return num;
	}
}
