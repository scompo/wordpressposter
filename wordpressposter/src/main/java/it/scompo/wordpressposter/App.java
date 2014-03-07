/**
 * App.java
 */
package it.scompo.wordpressposter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import it.scompo.wordpressposter.mods.PageCreator;
import it.scompo.wordpressposter.mods.ProperiesReader;
import it.scompo.wordpressposter.mods.models.BlogInfo;
import it.scompo.wordpressposter.mods.models.Post;
import it.scompo.wordpressposter.mods.models.ThesisPiece;

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
	
	static String url;
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
		url = props.getValue("blog.urlxmlprc");
		String defaultFile = props.getValue("default.file");
		
		BlogInfo info = new BlogInfo(userName, pass, 1);		
		logger.debug("Created blog info: " + info);
		
		PageCreator pageCreator = new PageCreator(defaultFile);
		List<ThesisPiece> thesis = pageCreator.getThesis();
		for (ThesisPiece thesisPiece : thesis) {
			//logger.info(thesisPiece);
			Post post = createPost(thesisPiece);
			post.setInfo(info);
			String result = sendPost(post);
			logger.info("result=" +result + " posting " + thesisPiece);
		}
	}

	private static String sendPost(Post post) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL(url));
	    
	    XmlRpcClient client = new XmlRpcClient();
	    client.setConfig(config);
	    
	    String result = (String) client.execute("wp.newPost", post.getData());
		//logger.debug("result=" + result);
		return result;
		//return null;
	}

	private static Post createPost(ThesisPiece thesisPiece) {
		Post post = new Post();
		post.setPostAuthor(1);
		post.setPostStatus("draft");
		post.setPostTitle(thesisPiece.getTitle() + (thesisPiece.getSubtitle().length()!=0 ? (" - " + thesisPiece.getSubtitle()):""));
		StringBuffer totParagraphs = new StringBuffer();
		totParagraphs.append("<h1 style=\"text-align: center;\">" +thesisPiece.getTitle() + "</h1>\n");
		if (thesisPiece.getSubtitle().length()!=0) {
			totParagraphs
					.append("<h2 style=\"text-align: center;\">" + thesisPiece.getSubtitle() + "</h2><br/>\n");
		}
		for (String s : thesisPiece.getParagraphs()) {
			totParagraphs.append("<p>" + s.replace("\n", "<br/>\n")+"</p>\n");
		}
		post.setPostContent(totParagraphs.toString());
		//logger.debug("Created post: " + post);
		return post;
	}

}
