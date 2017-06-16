package com.test.action;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DownloadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String path;	 
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public java.io.InputStream getDownloadFile()throws Exception {
	 InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());
	 return in;
	}
	public String execute() throws Exception {
	return SUCCESS;
}

}
