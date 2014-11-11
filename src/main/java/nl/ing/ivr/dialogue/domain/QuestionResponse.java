package nl.ing.ivr.dialogue.domain;

public class QuestionResponse {

    private final String answer;
    private String url;
    
    public QuestionResponse(final String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
}
