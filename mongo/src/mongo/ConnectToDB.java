package mongo;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import java.util.logging.Logger;

import org.bson.Document;

import java.util.Iterator;
import java.util.logging.Level;
public class ConnectToDB 
{

	public static void main(String args[])
	{
		/*String username="shivam";
		String useremail="shivam@gmail.com";
		String password="123456";*/
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); // e.g. or Log.WARNING, etc.
		
		
		
		
		try 
		{
			
	
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			MongoDatabase database = mongo.getDatabase("myDb");
		
			
			MongoCollection<Document> collection = database.getCollection("userdata");
			
			
			
			/*Document obj = new Document();
			obj.put("username", username);
			obj.put("useremail",useremail);
			obj.put("password", password);
			insert data;;
			collection.insertOne(obj);*/
			
			
			FindIterable<Document> finditerable = collection.find();
			Iterator<Document> it = finditerable.iterator(); 
			while(it.hasNext())
			{
				System.out.println(it.next().get("username"));
			}
			 
			mongo.close();
			
			//database.createCollection("userdata");
			//userdata.insert(obj);
			
			
			
			
			
			//System.out.println("done\n"+database.toString());
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		
		}
		
		
	}
	
	
	
	
	
}
