package com.example.app.service;

import java.util.List;

import com.example.app.dao.H2DBDao;
import com.example.app.entity.Patient;

public interface MyService {
   public String getNameWithUpperById(Integer id);
   public List<String> getAllContactNames();
   public Patient getPatientById(Integer id);
}
