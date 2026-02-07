package Beans;

import java.io.Serializable;

public class insertAuto implements Serializable {
	
	private String TaskId;
	private String Deadline;
	private String Class;
	private String Category;
	private String Contents;
	private String Other;
	private String Deadprocess;
	private String UserId;

	public insertAuto() {
	}
	
	public insertAuto(String TaskId, String Deadline, String Class, String Category, String Contents, String Other, String Deadprocess, String UserId) {
		this.TaskId = TaskId;
		this.Deadline = Deadline;
		this.Class = Class;
		this.Category = Category;
		this.Contents = Contents;
		this.Other = Other;
		this.Deadprocess = Deadprocess;
		this.UserId = UserId;
	}
	
	
	public String getTaskId() {
	    return TaskId;
	}
	
	public void setTaskId(String TaskId) {
	    this.TaskId = TaskId;
	}

	public String getDeadline() {
	    return Deadline;
	}
	
	public void setDeadline(String Deadline) {
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

	public String getDeadprocess() {
	    return Deadprocess;
	}
	
	public void setDeadprocess(String Deadprocess) {
	    this.Deadprocess = Deadprocess;
	}

	public String getUserId() {
	    return UserId;
	}
	
	public void setUserId(String UserId) {
	    this.UserId = UserId;
	}

	

}