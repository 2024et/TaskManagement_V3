package Beans;

import java.io.Serializable;
import java.util.Date;


public class insertBeans implements Serializable {
	
	private String TaskId;
	private Date Deadline;
	private String Class;
	private String Category;
	private String Contents;
	private String Other;
	private String Process;
	private String Attend;
	private String UserId;

	public insertBeans() {
	}
	
	public insertBeans(String TaskId, Date Deadline, String Class, String Category, String Contents, String Other, String Process, String Attend, String UserId) {
		this.TaskId = TaskId;
		this.Deadline = Deadline;
		this.Class = Class;
		this.Category = Category;
		this.Contents = Contents;
		this.Other = Other;
		this.Process = Process;
		this.Attend = Attend;
		this.UserId = UserId;
	}
	
	public String getTaskId() {
	    return TaskId;
	}
	
	public void setTaskId(String TaskId) {
	    this.TaskId = TaskId;
	}

	public Date getDeadline() {
	    return Deadline;
	}
	
	public void setDeadline(Date Deadline) {
	    this.Deadline = Deadline;
	}

	public String getClasss() {
	    return Class;
	}
	
	public void setClasss(String Class) {
	    this.Class = Class;
	}

	public String getCategory() {
	    return Category;
	}
	
	public void setCategory(String Category) {
	    this.Category = Category;
	}

	public String getContents() {
	    return Contents;
	}
	
	public void setContents(String Contents) {
	    this.Contents = Contents;
	}

	public String getOther() {
	    return Other;
	}
	
	public void setOther(String Other) {
	    this.Other = Other;
	}

	public String getProcess() {
	    return Process;
	}
	
	public void setProcess(String Process) {
	    this.Process = Process;
	}

	public String getAttend() {
	    return Attend;
	}
	
	public void setAttend(String Attend) {
	    this.Attend = Attend;
	}

	public String getUserId() {
	    return UserId;
	}
	
	public void setUserId(String UserId) {
	    this.UserId = UserId;
	}

	

}