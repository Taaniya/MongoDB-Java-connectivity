package jdbc_app;

import com.mongodb.*;
import java.util.Set;
import java.util.Iterator;

public class RemoteMongoConnect {
    public static void main(String agrs[]){
       try {
           MongoClientURI mongoc_uri= new MongoClientURI("mongodb://commonuser:userlistdbuser@ds149998.mlab.com:49998/userlist") ;
           MongoClient mclient = new MongoClient(mongoc_uri);
           DB db = mclient.getDB("userlist");
           System.out.println("connected to the database");
                        
            DBCollection colln = db.getCollection("userlist");    
                         
            DBCursor cursor = colln.find();      
                       
            DBObject dbo;
               int i=1;
               while(cursor.hasNext())
                 {
                   dbo = cursor.next();
                    
                   System.out.println((i++)+" "+dbo.toString());                   
                                
                 }
                    
        }
       
       catch(Exception e) {
           System.out.println("\n "+e.getClass()+"\n"+e.getMessage());
             
       }
    }//main
          
    
}//class
