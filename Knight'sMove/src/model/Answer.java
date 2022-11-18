package model;

public class Answer {
	private int id;
	private String answerContext;
	private boolean isTrue;
	public Answer(int id, String answerContext, boolean isTrue) {
		super();
		this.id = id;
		this.answerContext = answerContext;
		this.isTrue = isTrue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswerContext() {
		return answerContext;
	}
	public void setAnswerContext(String answerContext) {
		this.answerContext = answerContext;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
	
	
}
