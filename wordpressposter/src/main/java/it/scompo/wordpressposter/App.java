/**
 * App.java
 */
package it.scompo.wordpressposter;

import java.net.URL;

import it.scompo.wordpressposter.models.BlogInfo;
import it.scompo.wordpressposter.models.Post;
import it.scompo.wordpressposter.mods.ProperiesReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * Main application.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class App {

	private static final Logger logger = LogManager.getLogger(App.class);
	
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ProperiesReader props = new ProperiesReader("config");
		
		String userName = props.getValue("blog.username");
		String pass = props.getValue("blog.password");
		String url = props.getValue("blog.urlxmlprc");
		
		BlogInfo info = new BlogInfo(userName, pass, 1);		
		logger.debug("Created blog info: " + info);
		
		Post post = new Post();
		post.setInfo(info);
		post.setPostAuthor(1);
		post.setPostStatus("publish");
		post.setPostTitle("Title");
		post.setPostContent("Test from java.");
		logger.debug("Created post: " + post);
		
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL(url));
	    
	    XmlRpcClient client = new XmlRpcClient();
	    client.setConfig(config);
	    
	    String result = (String) client.execute("wp.newPost", post.getData());
		logger.debug("Result from server: "+ result);
	}

}
