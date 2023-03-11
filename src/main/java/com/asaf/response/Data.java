package com.asaf.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;

public class Data {

    private String id;

    public String getId() {
        return id;
    }

    public <T extends Data> T setId(String id) {
        this.id = id;
        return (T) this;
    }
}
