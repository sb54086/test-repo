package com.example.app.messanger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Message implements Serializable {
	
	private static final long serialVersionUID = -6573403421190571152L;
	private long id;
	private String message;
	private Date createdDate;
	private String author;
	private Map<Long, Comment> comments=new HashMap<Long, Comment>();
	private List<Link> links=new ArrayList<Link>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient //Dont wann to show in Message
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public Message(long id, String message, Date createdDate, String author, Map<Long, Comment> comments) {
		super();
		this.id = id;
		this.message = message;
		this.createdDate = createdDate;
		this.author = author;
		this.comments = comments;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", createdDate=" + createdDate + ", author=" + author
				+ ", comments=" + comments + "]";
	}
	public Message(long id, String message, Date createdDate, String author) {
		super();
		this.id = id;
		this.message = message;
		this.createdDate = createdDate;
		this.author = author;
	}
	public void addLink(String url,String rel) {
		Link link=new Link(url,rel);
		links.add(link);
	}
	
	
	

}
