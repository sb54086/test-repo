package com.example.app.messanger.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.app.messanger.model.Comment;
import com.example.app.messanger.model.Message;
import com.example.app.messanger.model.Profile;

public class TempDB {
	private static Map<String, Profile> profiles = new HashMap();
	private static Map<Long, Message> messages = new ConcurrentHashMap<>();
	private static Map<Long, Comment> comments=new HashMap<Long, Comment>();

	static {
		Map<Long, Comment> petterComments=new HashMap<Long, Comment>();
		petterComments.put(1L, new Comment(1, "Peter First Comment",new Date(), "Peter"));
		Message peeterMessage= new Message(1, "Hello Peter", new Date(), "Peter",comments);
		peeterMessage.setComments(petterComments);
		messages.put(1l,peeterMessage);
		
		messages.put(2l, new Message(2, "Hello John", new Date(), "Koushik"));
		profiles.put("Peter", new Profile(1, "Peter Profile", "Peter", "jacob", new Date()));

	}

	public synchronized Map<String, Profile> getProfiles() {
		return profiles;
	}

	public synchronized static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Comment> getComments() {
		return comments;
	}
	

}
