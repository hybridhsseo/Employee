package webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */

public class MyListener implements ServletContextListener {

	static Log log = LogFactory.getLog(MyListener.class);
	
    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	log.info("############################");
    	log.info("contextDestroyed(..)");
    	log.info("############################");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	log.info("############################");
    	log.info("contextInitialized(..)");
    	log.info("############################");
    	
    	ServletContext applicaton = sce.getServletContext();
    	
    	String className = applicaton.getInitParameter("className");
    	String url = applicaton.getInitParameter("url");
    	String user = applicaton.getInitParameter("user");
    	String password = applicaton.getInitParameter("password");
    	String location = applicaton.getInitParameter("contextConfigLocation");
    	
    	log.info("classNname=" + className);
    	log.info("url=" + url);
    	log.info("user=" + user);
    	log.info("password=" + password);
    	log.info("location=" + location);
    	
    }
	
}
