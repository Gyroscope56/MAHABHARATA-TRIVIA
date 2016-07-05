package com.triviaq.client.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class QnAData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id public Long id;
    public String question = "";
    public List<String> choices = new ArrayList<String>();
    public List<Integer> correctChoices = new ArrayList<Integer>();

    public QnAData() {
    }

    public QnAData(String question, List<String> choices, List<Integer> correctChoices) {
        this.question = question;
        this.choices = choices;
        this.correctChoices = correctChoices;
    }
}
