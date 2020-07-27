package com.example.app.messanger.service;

import java.util.ArrayList;
import java.util.List;

import com.example.app.messanger.dao.TempDB;
import com.example.app.messanger.model.Profile;

public class ProfileService {
	TempDB db = new TempDB();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(db.getProfiles().values());
		
	}
	public Profile getProfileByName(String profileName){
		return db.getProfiles().get(profileName);
	}
	public Profile addNewProfile(Profile profile){
		profile.setId(db.getProfiles().size()+1);
		db.getProfiles().put(profile.getProfileName(), profile);
		return profile;
		
	}
	public Profile updateProfile(Profile profile) {
		return db.getProfiles().put(profile.getProfileName(), profile);
	}
	public Profile removeProfile(Profile profile){
		return db.getProfiles().replace(profile.getProfileName(), profile);
		
	}
	public Profile removeProfile(String profileName){
		return db.getProfiles().remove(profileName);
		
	}

}
