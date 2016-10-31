package com.phd.quesans.model;

public class Question {
private String ques;

public String getQues() {
	return ques;
}
public void setQues(String ques) {
	this.ques = ques;
}
@Override
public String toString() {
	return "Question [ques=" + ques + "]";
}
}
