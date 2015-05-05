package com.andecy.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String name;
	private String lastChat;
	private String time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastChat() {
		return lastChat;
	}

	public void setLastChat(String lastChat) {
		this.lastChat = lastChat;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
