package xmltomongo;


import java.io.*;
import java.lang.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class FileParser {

    private final File folder;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private StringBuilder xmlStringBuilder = new StringBuilder();
    
    
    private void parseFolder(File folder) {
        System.out.println("began parsing");
        for(File entry: folder.listFiles()) {
            if(entry.isFile()) {
                //TODO: вызов функции для XML
                CheckIsXML(entry);
            }
        } 
        for(File entry: folder.listFiles()){
            if(entry.isDirectory()){
                parseFolder(entry);
            }
        }
        System.out.println("folder parsed");
    }
    
    private void parseFolder() {       
        parseFolder(folder);  
        System.out.println("SUCCESS");
        System.gc();
    }

    public FileParser(String in) throws ParserConfigurationException{
        //builder = factory.newDocumentBuilder();
        MongoWriter.initialise();
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        folder = new File(in);
        parseFolder();
    }
    
    // TODO: добавить метод
    private void CheckIsXML(File f){
        Document doc;
        System.out.println(f.getName());
        try{
            doc = builder.parse(f);
            sendToMongo(doc);
        } catch(Exception e) {    
        }
    }
    
    void sendToMongo(Document doc) {
        //MongoWriter.docInit();
        String nameOfCollection = doc.getElementsByTagName("note").item(0).getTextContent();
        NodeList fieldnames = doc.getElementsByTagName("mask");
        int amountOfRecords = doc.getElementsByTagName("record")
                .getLength();
        for (int j = 0; j < amountOfRecords; j++) {
            for (int i = 0; i < fieldnames.getLength(); i++) {
            
                String fieldtitle = doc.getElementsByTagName("mask").item(i)
                        .getTextContent();
                String fieldvalue = 
                        doc.getElementsByTagName("field"+Integer.toString(i))
                                .item(j).getTextContent();
                
                MongoWriter.outPut(nameOfCollection, fieldtitle, fieldvalue);
            }
            //пройдя все поля, помещаем документ в коллекцию
            MongoWriter.outPut();
        }
        
    }
}
