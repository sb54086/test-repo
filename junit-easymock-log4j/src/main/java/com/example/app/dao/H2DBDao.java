package com.example.app.dao;

import java.util.List;

import com.example.app.entity.Patient;

public interface H2DBDao {
  public String findNamebyId(Integer id);
  public List<String> findAllNames();
  public Patient getPatientId(Integer id);
}
