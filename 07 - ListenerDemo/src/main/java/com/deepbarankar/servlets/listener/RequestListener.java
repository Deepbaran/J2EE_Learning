package com.deepbarankar.servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
// Tomcat container should create this listener. Everytime it creates a request and response object it should call these methods in this listener.
// The WebListener will be called because we have marked it with @WebListener annotation
@WebListener
public class RequestListener implements ServletRequestListener {

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)  { 
    	System.out.println("Request Destroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
    	System.out.println("Request Created");
    }
	
}
