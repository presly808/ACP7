package ua.artcode.week6.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by serhii on 16.08.15.
 */
public class DomEntireXmlTest {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("/home/serhii/dev/IdeaProjects/ACP7/temp/team.xml"));
        Element root = document.getDocumentElement();

        String res = DomParsingUtils.getTextXMLContent(root);
        System.out.println(res);
    }
}
