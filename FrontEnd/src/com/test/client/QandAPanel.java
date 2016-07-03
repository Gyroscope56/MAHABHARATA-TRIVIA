package com.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialPanel;

public class QandAPanel extends Composite {

    private static QandAPanelUiBinder uiBinder = GWT.create(QandAPanelUiBinder.class);

    interface QandAPanelUiBinder extends UiBinder<Widget, QandAPanel> {
    }

    @UiField
    MaterialPanel qnaWidgetHolder;

    public QandAPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        QnAWidget qnaWidget = new QnAWidget();
        qnaWidgetHolder.add(qnaWidget);
        qnaWidget.setQuestion("Who wrote the Mahabharata?");
        qnaWidget.setAnswers(0, new String[] { "Sage Vyasa", "Sage Vishwamitra", "Arjuna", "Kubera" });
    }

}
