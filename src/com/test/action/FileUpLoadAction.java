package com.test.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpLoadAction extends ActionSupport{
	   private static final long serialVersionUID = 1L;
	  
	    private File                 uploadFile;      
	   
	    private String              uploadFileFileName;  
	 
	    private String              uploadFileContentType;                     
	  
		public File getUploadFile() {
			return uploadFile;
		}
		
		public void setUploadFile(File uploadFile) {
			this.uploadFile = uploadFile;
		}
	
		public String getUploadFileFileName() {
			return uploadFileFileName;
		}
	
		public void setUploadFileFileName(String uploadFileFileName) {
			this.uploadFileFileName = uploadFileFileName;
		}
	
		public String getUploadFileContentType() {
			return uploadFileContentType;
		}
		
		public void setUploadFileContentType(String uploadFileContentType) {
			this.uploadFileContentType = uploadFileContentType;
		}
		
		public String execute() throws Exception
	    {		
	        if (uploadFile!= null)
	        {      	  
	        	
	            String dataDir = "d:\\upload\\";
	          
	            File savedFile = new File(dataDir, uploadFileFileName);
	          
	            uploadFile.renameTo(savedFile);
	        }
	        else
	        {
	            return INPUT;
	        }

	        return SUCCESS;
	    }
}
