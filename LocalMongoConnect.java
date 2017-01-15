import com.mongodb.*;
import java.util.Set;
import java.util.Iterator;

/*
   In case your 32-bit MongodB gives the following error in your windows command prompt for command - mongod 
   exception in initAndListen: 28663 Cannot start server. The default storage engine 'wiredTiger' is not available 
   with this build of mongod. Please specify a different storage engine explicitly, e.g. --storageEngine=mmapv1., terminating

   then , enter this command -
   C:\Program Files\MongoDB\Server\3.2\bin>mongod --storageEngine=mmapv1 --dbpath "C:\Program Files\MongoDB"
*/

public class LocalMongoConnect {
    public static void main(String agrs[]){
       try {
                /*    Create a connection    */
            MongoClient mclient = new MongoClient("localhost" , 27017);
            
                /*  Get database  */  
            DB db = mclient.getDB("student");
            System.out.println("connected to the database");
          //CommandResult cr = db.command("db.student.find({ fname : 'Taani'});");
          
               /*  Get a set of collections in the database  */  
            Set<String> dbs = db.getCollectionNames();
            Iterator it =dbs.iterator();
            String scoll = it.next().toString();     //Get the first collection's name
            
               /* Get the first collection from its string reference */
            DBCollection colln = db.getCollection(scoll);    
            
                /* a cursor which will iterate over every object  */
            DBCursor cursor = colln.find();      
            
               /* Create a document */
            DBObject document = new BasicDBObject();
            document.put("fname","Asha");
            document.put("sname","Bhosale");
            document.put("class","BE-IT");
            
              /*    Insert a document   */
            DBObject bdbo = new BasicDBObject("fname","John");
            colln.insert(bdbo);
            
               /*    remove a document   */
            colln.remove(bdbo); 
                     
               /*  Update and if not present,insert a document   */ 
            DBObject doc = new BasicDBObject();
            doc.put("fname","Asha");
            colln.update(doc, document, true, false);
          
            DBObject dbo;
                    
            /*  Print the records in the collection   */           
            int i=1;
               while(cursor.hasNext())
                 {
                   dbo = cursor.next();
                    //System.out.println((i++)+" "+dbo.get("fname"));
                   System.out.println((i++)+" "+dbo.toString());                   
                                
                 }
                    
        }
       
       catch(Exception e) {
           System.out.println("\n "+e.getClass()+"\n"+e.getMessage());
             
       }
    }
          
    
}
