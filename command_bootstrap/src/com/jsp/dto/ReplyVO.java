package com.jsp.dto;

import java.util.Date;

public class ReplyVO {

private int rno; //고유번호
private int bno; //게시글번호
private String replytext; //댓글내용
private String replyer; //댓글작성자
private Date regdate;
private Date updatedate;

private String picture; //작성자 사진


public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getReplytext() {
	return replytext;
}
public void setReplytext(String replytext) {
	this.replytext = replytext;
}
public String getReplyer() {
	return replyer;
}
public void setReplyer(String replyer) {
	this.replyer = replyer;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public Date getUpdatedate() {
	return updatedate;
}
public void setUpdatedate(Date updatedate) {
	this.updatedate = updatedate;
}


}
