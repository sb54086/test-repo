package com.example.app.messanger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.example.app.messanger.bean.FilteredMessageBean;
import com.example.app.messanger.model.Message;
import com.example.app.messanger.service.MessageService;

@Path("messages")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MessageResource {
	MessageService service;

	public MessageResource() {

		this.service = new MessageService();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Message> getMessage(@BeanParam FilteredMessageBean bean) {
		System.out.println("JSOn Method called");
		if (bean.getYear() > 0) {
			return service.getAllMessagesForYear(bean.getYear());
		}
		if (bean.getStart() >= 0 && bean.getSize() >= 0) { // bcz we are storing as 0 based starting index
			return service.getAllMessagesInPaginated(bean.getStart(), bean.getSize());
		}
		// @Context used to inject
		// Request,ServletConfig, Application,HttpHeaders,UriInfo
		return service.getAllMessages();
	}
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<Message> getMessageXML(@BeanParam FilteredMessageBean bean) {
		System.out.println("XML Method called");
		if (bean.getYear() > 0) {
			return service.getAllMessagesForYear(bean.getYear());
		}
		if (bean.getStart() >= 0 && bean.getSize() >= 0) { // bcz we are storing as 0 based starting index
			return service.getAllMessagesInPaginated(bean.getStart(), bean.getSize());
		}
		// @Context used to inject
		// Request,ServletConfig, Application,HttpHeaders,UriInfo
		return service.getAllMessages();
	}

	@GET
	@Path("{id}")
	public Response getMessageById(@PathParam("id") Long id, @Context UriInfo info) {
		ResponseBuilder builder = Response.status(Status.NOT_FOUND);
		Message message = service.getMessage(id);
		if (message == null) {
			builder = Response.status(Status.NOT_FOUND).entity(null);
			return builder.build();
		}

		message.addLink(getUriForSelf(info, message), "rel");
		message.addLink(getUriForProfilesSelf(info, message), "profile");
		message.addLink(getUriForCommentSelf(info, message), "comments");

		return builder.entity(message).status(Status.FOUND).build();
	}

	private String getUriForCommentSelf(UriInfo info, Message message) {
		String link = info.getBaseUriBuilder() // http://localhost:8084/jaxrs-citius/api
				.path(MessageResource.class) // /messages
				.path(MessageResource.class,"getComments")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build().toString();
		return link;
	}

	public String getUriForSelf(UriInfo info, Message message) {
		String link = info.getBaseUriBuilder() // http://localhost:8084/jaxrs-citius/api
				.path(MessageResource.class) // /messages
				.path(Long.toString(message.getId())).build().toString();
		return link;
	}

	@POST
	public Response addMessage(Message message) {
		Message newMessage = service.addMessage(message);
		return Response.status(Status.CREATED).entity(newMessage).build();
	}

	@PUT
	@Path("{id}")
	public Message updateMessage(@PathParam("id") Long id, Message message) {
		message.setId(id);
		System.out.println("Updating Message of ID " + id);
		return service.updateMessage(message);
	}

	@DELETE
	@Path("{id}")
	public void updateMessage(@PathParam("id") Long id) {
		service.deleteMessage(id);
	}

	@Path("{messageId}/comments") // This subresource method handover to CommentResource
	public CommentResource getComments() {
		return new CommentResource();
	}

	public String getUriForProfilesSelf(UriInfo info, Message message) {
		URI uri = info.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build();
		return uri.toString();
	}

}
