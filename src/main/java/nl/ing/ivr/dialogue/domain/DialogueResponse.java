package nl.ing.ivr.dialogue.domain;


public class DialogueResponse {

	private String answer;
	private String url;

	public DialogueResponse() {
		// default constructor is needed!
	}
		
	public DialogueResponse(String answer, String url) {		
		this.answer = answer;
		this.url = url;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Answer is: " + this.answer + "URL is: " + this.url; 
	}

}
