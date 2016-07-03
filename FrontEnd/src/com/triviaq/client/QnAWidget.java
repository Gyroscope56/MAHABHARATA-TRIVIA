package com.triviaq.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialRadioButton;

public class QnAWidget extends Composite {

    private static QnAWidgetUiBinder uiBinder = GWT.create(QnAWidgetUiBinder.class);

    @UiField
    Label answerLabel;

    @UiField
    MaterialCardTitle question;

    @UiField
    VerticalPanel answerChoicesPanel;

    private boolean answerClicked = false;
    
    interface QnAWidgetUiBinder extends UiBinder<Widget, QnAWidget> {
    }

    public QnAWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setQuestion(String questionText) {
        question.setText("Q) " + questionText);
    }

    public void setAnswers(int correctAnswer, String[] answers) {
        answerChoicesPanel.clear();
        for (int i = 0; i < answers.length; ++i) {
            MaterialRadioButton button = new MaterialRadioButton("choices");
            button.setText(answers[i]);
            if (i == correctAnswer) {
                button.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        if (answerClicked == true) {
                            answerLabel.setText("You only get 1 chance");
                        } else {
                            answerLabel.setText("Good job. Correct Answer!!!");
                        }
                    }
                });

            } else {
                button.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        if (answerClicked == true) {
                            answerLabel.setText("You only get 1 chance");
                        } else {
                            answerLabel.setText("Wrong answer.");
                        }
                    }
                });
            }
            answerChoicesPanel.add(button);
        }
    }
}
