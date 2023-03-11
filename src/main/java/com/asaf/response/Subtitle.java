package com.asaf.response;

public class Subtitle extends Data{

    private SubtitleAttributes attributes;
    private QueryType queryType;
    private int totalResults;


    public SubtitleAttributes getAttributes() {
        return attributes;
    }

    public <T extends Subtitle> T setAttributes(SubtitleAttributes attributes) {
        this.attributes = attributes;
        return (T) this;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public <T extends Subtitle> T setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return (T) this;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public <T extends Subtitle> T setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        return (T) this;
    }
}
