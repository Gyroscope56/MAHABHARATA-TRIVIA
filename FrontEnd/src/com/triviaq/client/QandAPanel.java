package com.triviaq.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;

public class QandAPanel extends Composite {
    private static final Logger logger = Logger.getLogger(QandAPanel.class.getName());
    private static QandAPanelUiBinder uiBinder = GWT.create(QandAPanelUiBinder.class);

    interface QandAPanelUiBinder extends UiBinder<Widget, QandAPanel> {
    }

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    public static final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    @UiField
    MaterialPanel qnaWidgetHolder;

    @UiField
    MaterialButton prevButton;

    @UiField
    MaterialButton nextButton;

    @UiField
    MaterialLink addQuestions;
    
    public QandAPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        QnAWidget qnaWidget = new QnAWidget();
        qnaWidgetHolder.add(qnaWidget);
        qnaWidget.setQuestion("Who wrote the Mahabharata?");
        qnaWidget.setAnswers(0, new String[] { "Sage Vyasa", "Sage Vishwamitra", "Arjuna", "Kubera" });
    }

    @UiHandler("prevButton")
    void clickHandler(ClickEvent clickEvent) {
        greetingService.saveQuestions(new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
            }
            
            @Override
            public void onFailure(Throwable caught) {
            }
        });
    }
    
    @UiHandler("addQuestions")
    void addQuestionsHandler(ClickEvent e) {
       logger.info("Add questions"); 
    }
}
