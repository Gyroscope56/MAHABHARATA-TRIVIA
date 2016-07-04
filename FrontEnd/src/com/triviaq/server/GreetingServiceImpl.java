package com.triviaq.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.google.common.collect.ImmutableList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import com.triviaq.client.GreetingService;
import com.triviaq.client.common.QnAData;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

    @Override
    public void init() throws ServletException {
        super.init();
        ObjectifyService.register(QnAData.class);
    }
    
    public String greetServer(String input) throws IllegalArgumentException {
        return "Hello Back";
    }

    @Override
    public List<QnAData> getQuestions() throws IllegalArgumentException {
        List<QnAData> run = ObjectifyService.run(new Work<List<QnAData>>() {
            @Override
            public List<QnAData> run() {
                List<QnAData> list = ObjectifyService.ofy().load().type(QnAData.class).list();
                return list;
            }
        });
        return run;
    }

    public void saveQuestions() throws IllegalArgumentException {
        List<QnAData> data = new ArrayList<QnAData>();
        data.add(new QnAData("Some question", ImmutableList.of("Choice 1"),
                ImmutableList.of(1)));
        ObjectifyService.ofy().save().entities(data).now();
    }
}
