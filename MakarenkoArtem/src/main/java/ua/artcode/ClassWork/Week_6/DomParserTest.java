package ua.artcode.ClassWork.Week_6;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by serhii on 16.08.15.
 */
public class DomParserTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("C:\\my_local_disk\\Java\\ACP7\\src\\ua\\artcode\\ClassWork\\temp\\team.xml"));
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


    public static void showAll(Node el){

        // if no children

        // iterate over children if text -> just show
        // if element show tag name, then go forward(recursion)
    }

}



