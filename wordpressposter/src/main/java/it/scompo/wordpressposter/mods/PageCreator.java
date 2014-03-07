/**
 * PageCreator.java
 */
package it.scompo.wordpressposter.mods;

import it.scompo.wordpressposter.mods.models.ThesisPiece;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Page creator.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class PageCreator {
	
	private static final Logger logger = LogManager
			.getLogger(PageCreator.class);
	
	private File file;
	private Document doc;
	private List<ThesisPiece> thesis;
	
	/**
	 * Constructor.
	 */
	public PageCreator(String path) {
		try {
			file = new File(path);
			doc = Jsoup.parse(file,"UTF-8");
			thesis = new ArrayList<ThesisPiece>();
			parse(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the thesis.
	 *
	 * @return the thesis.
	 */
	public List<ThesisPiece> getThesis() {
		return thesis;
	}

	private void parse(Document doc2) {
		Elements els = doc.select("p");
		ThesisPiece piece = null;
		for (Element element : els) {
			//Titles.
			if(element.hasAttr("align") && element.attr("align").equalsIgnoreCase("CENTER")){
				if(element.select("b").first()!=null){
					//title
					thesis.add(piece);
					piece = new ThesisPiece();
					piece.setTitle(element.select("b").first().text());
				}
				Elements el2Elements = element.select("font");
				for (Element e : el2Elements) {
					if(e.hasAttr("size") && e.attr("size").equals("4")){
						//subtitle
						piece.setSubtitle(e.text());
					}
				}
			}			
			Elements e3 = element.select("font");
			for (Element ex : e3) {
				if(ex.hasAttr("size") && ex.attr("size").equals("2")){
					//paragraph
					piece.addParagraph(ex.text());
				}
			}

		}
		thesis.remove(0);
	}

}
