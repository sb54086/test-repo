package com.example.app.messanger.resources;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.example.app.messanger.model.Message;
import com.example.app.messanger.model.Profile;
import com.example.app.messanger.service.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService service=new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return service.getAllProfiles();
	}
	@GET
	@Path("{profileName}")
	public Profile getProfileById(@PathParam("profileName")String profileName){
		return service.getProfileByName(profileName);
	}
	@POST
	public Profile addProfile(Profile profile) {
		return service.addNewProfile(profile);
	}
	@PUT
	@Path("{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return service.updateProfile(profile);
	}
	@DELETE
	@Path("{profileName}")
	public void addProfile(@PathParam("profileName")String profileName) {
		service.removeProfile(profileName);
	}
	
	

}
