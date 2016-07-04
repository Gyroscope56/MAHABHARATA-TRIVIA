package com.triviaq.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.triviaq.client.common.QnAData;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("triviaq")
public interface GreetingService extends RemoteService {
    String greetServer(String name) throws IllegalArgumentException;
    List<QnAData> getQuestions() throws IllegalArgumentException;
    public void saveQuestions() throws IllegalArgumentException;
}
