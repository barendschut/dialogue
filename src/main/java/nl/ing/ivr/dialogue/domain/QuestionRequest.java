package nl.ing.ivr.dialogue.domain;

public class QuestionRequest {

    private final String query;
    private final Channel channel;

    public QuestionRequest(final String query, final Channel channel) {
        this.query = query;
        this.channel = channel;
    }

    public String getQuery() {

        return query;
    }

    public Channel getChannel() {
        return channel;
    }

}