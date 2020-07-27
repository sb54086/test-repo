package com.example.app.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.app.exception.DataNotFoundException;
import com.example.app.messanger.dao.TempDB;
import com.example.app.messanger.model.Message;

public class MessageService {
	private  Map<Long, Message> messages=TempDB.getMessages();

	

	public List<Message> getAllMessages() {
		
		return new ArrayList<Message>(messages.values());
	}
	public List<Message> getAllMessagesForYear(final int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
		messages.values().stream()
		  .filter((m)->{
			  cal.setTime(m.getCreatedDate());
			  if(cal.get(Calendar.YEAR)==year) {
				  return true;
			  }return false;
		  })
		  .forEach(messagesForYear::add);
		
		return messagesForYear;
	}
	public List<Message> getAllMessagesInPaginated(int startIndex,int size) {
		List<Message> tempList=new ArrayList<Message>(messages.values());
		if(startIndex+size>tempList.size()) {return new ArrayList<Message>();}
		return tempList.subList(startIndex, startIndex+size);
	}

	public Message getMessage(long id) {
		Message message=messages.get(id);
		
		if(message==null) {throw new DataNotFoundException("Id Not Exist");}
		return message;
	}

	public Message addMessage(Message message) {
		
		long currentKeyIndex = messages.size();
		currentKeyIndex = currentKeyIndex + 1;
		messages.put(currentKeyIndex, message);
		return message;
	}

	public Message updateMessage(Message message) {
		
		if (message.getId() <= 0 || message == null) {
			return null;
		}
		messages.put(message.getId(), message);
		return messages.get(message.getId());

	}

	public Message deleteMessage(Message message) {
		
		return messages.remove(message.getId());
	}

	public Message deleteMessage(long id) {
		
		return messages.remove(id);
	}
	private void printMapToCOnsole(Map<Long, Message> messages) {
		messages.forEach((k,v)->{
			System.out.println("Key: "+k+"\t Value: "+v);
		});
		
	}
}
