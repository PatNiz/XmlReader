package services;

import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.io.File;

public class XmlManager {
    public Element readXmlFile(String fileName){
        Element root = null;
        try {
            root = readFile(fileName).getRootElement();
            printEntity(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
    public void printEntity(Element element){

        System.out.println("Element: "+getRootName(element));
        printRecursive(element);

    }
    public String getRootName(Element element){
        return element.getName();
    }

    public void printRecursiveChild(Element element) {
        for(int i = 0, size = element.nodeCount(); i < size; i++) {

            Node node = element.node(i);
            if(node instanceof Element) {
                Element currentNode = (Element) node;
                System.out.println("getChildName: " + currentNode.getName());
                List<Attribute> l_attrbs = currentNode.attributes();
                for (Attribute l_att : l_attrbs) {
                    System.out.println("Name = " + l_att.getName() + " | value = " + l_att.getValue());
                }
                printRecursiveChild(currentNode);
            }
        }
    }


    public void printRecursive(Element element) {

        for(int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if(node instanceof Element) {
                Element currentNode = (Element) node;

                System.out.println("GetParentName: " +currentNode.getName());
                printRecursiveChild(currentNode);
            }
        }
    }


    public Document readFile(String filename) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filename));
        return document;
    }
}
