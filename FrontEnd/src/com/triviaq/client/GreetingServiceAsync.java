package com.triviaq.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.triviaq.client.common.QnAData;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
    void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

    void getQuestions(AsyncCallback<List<QnAData>> callback);

    void saveQuestions(AsyncCallback<Void> callback);
}
