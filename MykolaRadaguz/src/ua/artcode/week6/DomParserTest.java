package ua.artcode.week6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
        Document document = documentBuilder.parse("file://home/pikolo/IdeaProjects/ACP7/MykolaRadaguz/src/ua/artcode/temp/team.xml");
        Element root = document.getDocumentElement();
//        System.out.println("root tag name %s\n", root.getTagName());
    }
}
