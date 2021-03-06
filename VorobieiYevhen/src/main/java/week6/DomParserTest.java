package week6;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class DomParserTest {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\src\\week6\\team.xml"));
        Element root = document.getDocumentElement();

        showAll(root);


        /*System.out.printf("<%s>", root.getTagName());

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

        }*/
    }


    public static void showAll(Node el){
        // if no children
        if (!el.hasChildNodes()) return;
        System.out.print("<" + el.getNodeName() + ">");
            NodeList children = el.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.TEXT_NODE) {
                    Text textNode = (Text) child;
                    if (!textNode.equals(" "))
                    System.out.print(textNode.getTextContent());
                } else if (child.getNodeType() == Node.ELEMENT_NODE) {
                    //Element element = (Element) child;
                    //System.out.print("<" + element.getTagName() + ">");
                    showAll(child);
                    //System.out.print("</" + element.getTagName()+ ">");
                }
            }
        System.out.print("</" + el.getNodeName() + ">");
        // iterate over children if text -> just show
        // if element show tag name, then go forward(recursion)
    }
}



