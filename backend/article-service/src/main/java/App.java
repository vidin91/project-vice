import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.*;

public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MongoClient client = new MongoClient("localhost", 27017);
    MongoDatabase db = client.getDatabase("testing");
    MongoCollection<Document> usersCol =  db.getCollection("users");
    Document search_criteria = new Document("name", "Milos")
                                   .append("age", new Document("$gt", 20));
    //MongoCursor<Document> userCur = usersCol.find(search_criteria).iterator();
    MongoCursor<Document> userCur = usersCol.find(eq("_id", new ObjectId("5a898d2ff467989b3ad84d17"))).iterator();
    while (userCur.hasNext()) {
      System.out.println(userCur.next().toJson());
    }
    client.close();
  }

}
