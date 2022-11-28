package model;

public class Answer {
	private int id;
	private String answerContext;
	private boolean isTrue;
	//costructor
	public Answer(int id, String answerContext, boolean isTrue) {
		super();
		this.id = id;
		this.answerContext = answerContext;
		this.isTrue = isTrue;
	}
	//getters setters
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

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerContext=" + answerContext + ", isTrue=" + isTrue + "]";
	}

}
