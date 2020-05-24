package com.pramod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pramod.dao.ManuDao;
import com.pramod.entity.Manu;
import com.pramod.response.Request;
import com.pramod.response.Response;
import com.pramod.util.ApplicationUtils;
@Component
public class ManuService {
    
	@Autowired
	private ManuDao manuDao;
    
    public List<Response> getAllManuDetail() {
    	Iterable<Manu> list = manuDao.findAll();
    	List<Response> response = ApplicationUtils.prepareResponse((List<Manu>) list);
    	return response;
    }
    
    public List<Response> saveDummyManu() {
    	Manu manu = manuDao.save(ApplicationUtils.prepareDataForManuItem());
    	List<Manu> manuList = new ArrayList<Manu>();
    	  if(manu!=null) {
    		  manuList.add(manu);
    		  return ApplicationUtils.prepareResponse(manuList);
    	  }
		return null;
    }
    
    public List<Response> saveManu(Request request) {
    	Manu manu = manuDao.save(ApplicationUtils.prepareRequestForEntity(request));
    	List<Manu> manuList = new ArrayList<Manu>();
    	  if(manu!=null) {
    		  manuList.add(manu);
    		  return ApplicationUtils.prepareResponse(manuList);
    	  }
		return null;
    }
    
    public List<Response> getManuDetailById(String id) {
    	
    	Optional<Manu> list = manuDao.findById(Integer.parseInt(id));
    	 if(list!=null && list.isPresent()) {
    		 Manu manu = list.get();
    		 List<Manu> manuList = new ArrayList<Manu>();
    		 manuList.add(manu);
    		 List<Response> response =	 ApplicationUtils.prepareResponse(manuList);
    		 return response;
    	 }
		return null;
         
    	
    
    }
    
    public void deleteManuItem(String id) {
    	 manuDao.deleteById(Integer.parseInt(id));
    	
    }
    
    public void deleteAllManuItem() {
   	 manuDao.deleteAll();
   	
   }
}
