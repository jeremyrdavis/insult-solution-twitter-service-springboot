package com.redhat.summit2019.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Insult {


    String insult;

    @JsonCreator
    public Insult(@JsonProperty("id") String insult) {
        this.insult = insult;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"insult\":\"");
        builder.append(getInsult());
        builder.append("\"");
        builder.append("}");
        return builder.toString();

    }

    public String getInsult() {
        return insult;
    }

    public void setInsult(String insult) {
        this.insult = insult;
    }
}

