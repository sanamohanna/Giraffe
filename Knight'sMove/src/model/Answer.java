package model;

public class Answer {
	private Integer id;
	private String answerContext;
	private boolean isTrue;

	// constructor
	public Answer(int id, String answerContext, boolean isTrue) {
		super();
		this.id = id;
		this.answerContext = answerContext;
		this.isTrue = isTrue;
	}
	public Answer(int id, String answerContext) {
		super();
		this.id = id;
		this.answerContext = answerContext;
	}

	// getters setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerContext == null) ? 0 : answerContext.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isTrue ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerContext == null) {
			if (other.answerContext != null)
				return false;
		} else if (!answerContext.equals(other.answerContext))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isTrue != other.isTrue)
			return false;
		return true;
	}
	
	

}
