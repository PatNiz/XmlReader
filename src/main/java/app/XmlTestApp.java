package app;

import org.dom4j.Element;
import services.XmlManager;

public class XmlTestApp {
    public static void main(String[] args) {
        XmlManager manager = new XmlManager();
        Element element = manager.readXmlFile("Thingworx.xml");
        manager.printRecursive(element);
    }
}
