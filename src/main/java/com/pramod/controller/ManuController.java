package com.pramod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramod.response.Request;
import com.pramod.response.Response;
import com.pramod.service.ManuService;

@RestController
public class ManuController {
	@Autowired
	private ManuService manuService;

   @RequestMapping(value="/displayAllmenu", method=RequestMethod.GET)
	public ResponseEntity<List<Response>> displayAllManu() {

		List<Response> list = manuService.getAllManuDetail();
		return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
	}
    
   @RequestMapping(value="/displaymenubyId/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Response>> displayManuById(@PathVariable String id) {
        
		List<Response> list = manuService.getManuDetailById(id);
		return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
	}
   
   @RequestMapping(value="/savemenu",method=RequestMethod.POST)
  	public ResponseEntity<List<Response>> saveAllManu(@RequestBody Request request) {
  	  List<Response> response = manuService.saveManu(request);
  	 
  	   return  new ResponseEntity<List<Response>>(response, HttpStatus.OK);
  	}
   
   @RequestMapping(value="/saveDummyData" , method=RequestMethod.GET)
	public ResponseEntity<List<Response>> saveDummyManu() {
		List<Response> response = manuService.saveDummyManu();

		return new ResponseEntity<List<Response>>(response, HttpStatus.OK);
	}
   
   @RequestMapping(value="/deleteManuitem/{id}" , method=RequestMethod.DELETE)
  	public ResponseEntity<Object> deleteManu(@PathVariable String id) {
  		manuService.deleteManuItem(id);

  		return new ResponseEntity<>(HttpStatus.OK);
  	}
   
   @RequestMapping(value="/deleteManuitem/" , method=RequestMethod.DELETE)
 	public ResponseEntity<Object> deleteAllManu() {
 		manuService.deleteAllManuItem();

 		return new ResponseEntity<>(HttpStatus.OK);
 	}
}
