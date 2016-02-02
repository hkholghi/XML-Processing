import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
/**
 * This program employees DOM to parse an xml file.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuakeParser {

    public void parseXmlFile(){
        System.out.println("Hello World");
        String fileName = "oneEarthQuake.xml";
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            //using dbf to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder(); // this throws ParserConfigurationException exception
            
            //parse using builder "db" to get DOM representation of the XML file.
            Document dom = db.parse(fileName);
            
            //get the root element
//             Element docEle = dom.getDocumentElement();
            System.out.println("Start");
            
            //get a nodelist of elements
            NodeList nList = dom.getElementsByTagName("entry");
            System.out.println(nList.getLength());
                for(int i=0; i<nList.getLength(); i++){
                    Node nNode = nList.item(i);
                    if(nNode.getNodeType() == Node.ELEMENT_NODE){
                        Element elem = (Element)nNode;
                        NodeList t1 = elem.getElementsByTagName("title");
                        String s1 = t1.item(0).getTextContent();
                        NodeList t2 = elem.getElementsByTagName("georss:point");
                        String s2 = t2.item(0).getChildNodes().item(0).getNodeValue();
                        NodeList t3 = elem.getElementsByTagName("categor");
                        t3.item(0).getChildNodes().item(0).getAttributes().getNamedItem("label");
                        System.out.println(t3.item(0));
                        String s3 = t3.item(0).getTextContent();

                        System.out.print(s1 + "\n" + s2 +"\n" + s3);
                    }
                    System.out.println();
                }
            
            
        }
        catch(ParserConfigurationException pce){
        }
        catch(SAXException se){
        }
        catch(IOException ioe){
        }
    }
}
