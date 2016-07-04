package com.triviaq.server;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.triviaq.client.common.QnAData;

public class OfyHelper implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ObjectifyService.register(QnAData.class);
    }
}
