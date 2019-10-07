package edu.ssafy;

public class User {
private String id;
private String passwd;

public User() {
	// TODO Auto-generated constructor stub
}
public User(String id,String passwd) {
	// TODO Auto-generated constructor stub
	this.id=id;
	this.passwd=passwd;
	
}

@Override
public String toString() {
	return "User [id=" + id + ", passwd=" + passwd + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}

}
