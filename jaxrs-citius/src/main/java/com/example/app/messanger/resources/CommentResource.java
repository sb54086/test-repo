package com.example.app.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.app.messanger.model.Comment;
import com.example.app.messanger.service.CommentService;

@Path("/") //@Path annotation is Optional for SubResource
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService service=new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return service.getAllComments(messageId);
	}
	
	@POST
	public Comment addCommentToAMessage(@PathParam("messageId") long messageId,Comment comment) {
		return service.addComment(messageId, comment);
	}
	@PUT
	@Path("{commentId}")
	public Comment updateCommentToAMessage(@PathParam("messageId") long messageId,@PathParam("commentId")long commentId,Comment comment) {
		comment.setId(commentId);
		return service.updateComment(messageId, comment);
	}
	@GET
	@Path("{commentId}")
	public Comment getCommentForAnMessage(@PathParam("commentId") Long commentId,@PathParam("messageId")long messageId) {
		return service.getComment(commentId, messageId);
	}
	@DELETE
	@Path("{commentId}")
	public void deleteCommentForAnMessage(@PathParam("commentId") Long commentId,@PathParam("messageId")long messageId) {
		service.removeComment(messageId, commentId);
	}

}
