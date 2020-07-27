package com.example.app.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.app.messanger.dao.TempDB;
import com.example.app.messanger.model.Comment;
import com.example.app.messanger.model.ErrorModel;
import com.example.app.messanger.model.Message;

public class CommentService {
	private Map<Long, Message> messages = TempDB.getMessages();

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> tempMap = messages.get(messageId).getComments();
		if (tempMap == null) {
			return null;
		}
		return new ArrayList<Comment>(tempMap.values());
	}

	public Comment getComment(long commentId, long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comments == null) {
			ErrorModel model=new ErrorModel("Resource Not FOund", 404, "No Lonk");
			Response response= Response.status(Status.NOT_FOUND).entity(model).build();
		
			throw new WebApplicationException(response);
		}
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}

		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		return comments.remove(commentId);
	}

}
