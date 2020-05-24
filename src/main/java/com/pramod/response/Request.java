package com.pramod.response;

import java.util.List;

public class Request {
	 
	    private Integer manuId;
	    
	    private String manuName;
	   
	    private List<SubManuDto> submanuList;

		public Integer getManuId() {
			return manuId;
		}

		public void setManuId(Integer manuId) {
			this.manuId = manuId;
		}

		public String getManuName() {
			return manuName;
		}

		public void setManuName(String manuName) {
			this.manuName = manuName;
		}

		public List<SubManuDto> getSubmanuList() {
			return submanuList;
		}

		public void setSubmanuList(List<SubManuDto> submanuList) {
			this.submanuList = submanuList;
		}

	    
}
