package xmltomongo;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;

import com.mongodb.MongoCredential;

import java.io.File;
import javax.xml.parsers.*;
import org.bson.Document;

//TODO: решить конфликт имен org.bson.Document и org.w3c.dom.Document
public class MongoWriter { 
    private static MongoWriter instance;    
    private static MongoDatabase database;
    //инициализация БД, установка соединения
    //вызывается однократно
    private MongoWriter(){
        System.out.println("PRIVATECONSTUCTOR CALLED");
        connect();  
    }
    
    private void connect() {        
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        MongoCredential credential;
        credential = MongoCredential.createCredential("xmlConverter", "XML_MongoUser",
        "defaultPsw".toCharArray());
        System.out.println("Connected to the database successfully");
        database = mongo.getDatabase("XMLContent");
        System.out.println("Credentials ::"+ credential);
    }
    
    public static void initialise(){
        if(instance == null){
            instance = new MongoWriter();
        }
    }
    
    private static Document document;
    private static MongoCollection collection;

    public static void docInit() {
        
    }
    public static void outPut(String collname, String title, String value){
        try {
            database.createCollection(collname);
            document = new Document();
        }
        catch(Exception e) {
            collection = database.getCollection(collname);
        }
        finally{ 
            document.append(title, value);
        }
    }
    

    
    public static void outPut(){
        collection.insertOne(document);
        document = new Document();
    }
    
    
    public static void showAllData() {
        initialise();
        for (String coll: database.listCollectionNames()){
            System.out.println(coll);
            for(Document dc: database.getCollection(coll).find()){
                System.out.println(dc.toJson());
            }
        }
    }
}
