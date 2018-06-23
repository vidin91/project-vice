package projectvice.article_service.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import projectvice.article_service.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
  private static ArticleService service;
  public static ArticleService getInstance() {
    if (service == null) {
      service = new ArticleServiceImpl();
    }
    return service;
  }
  
  private MongoClient client;
  private MongoDatabase db;
  
  private ArticleServiceImpl() {
    this.client = new MongoClient("localhost", 27017);
    this.db = client.getDatabase("projectvice");
  }

  @Override
  public List<Document> getArticles() {
    MongoCollection<Document> c = db.getCollection("articles");
    FindIterable<Document> fi = c.find().limit(1000);
    MongoCursor<Document> iterator = fi.iterator();
    List<Document> result = new LinkedList<Document>();
    while (iterator.hasNext()) {
      result.add(iterator.next());
    }
    return result;
  }

  @Override
  public Document getArticle(String id) {
    MongoCollection<Document> c = db.getCollection("articles");
    FindIterable<Document> fi = c.find(eq("_id", new ObjectId(id)));
    MongoCursor<Document> iterator = fi.iterator();
    if (iterator.hasNext()) {
      return iterator.next();
    }
    return null;
  }

  @Override
  public Document createArticle(Document doc) {
    // TODO Auto-generated method stub
    return null;
  }
  
  protected void finalize() {
    this.client.close();
  }

}
