package ua.artcode.week6;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by pikolo on 16.08.15.
 */
public class DomParserTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse("file:///home/pikolo/IdeaProjects/ACP7/MykolaRadaguz/src/ua/artcode/temp/team.xml");
        Element root = document.getDocumentElement();
        System.out.printf("<%s>", root.getTagName());

        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if(child.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) child;
                System.out.println("<" + element.getTagName()+ ">");
            } else if(child.getNodeType() == Node.TEXT_NODE){
                Text textNode = (Text) child;
                System.out.println(textNode.getTextContent());
            }

        }
    }


    public static void showAll(Node el) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse("file:///home/pikolo/IdeaProjects/ACP7/MykolaRadaguz/src/ua/artcode/temp/team.xml");
        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();
        if (children == null){ // if no children

            for (int i = 0; i < children.getLength(); i++) {         // iterate over children if text -> just show
//                if ()
            }

        }



        // if element show tag name, then go forward(recursion)
    }

}
