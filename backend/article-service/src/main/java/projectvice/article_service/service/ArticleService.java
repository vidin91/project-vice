package projectvice.article_service.service;

import java.util.List;

import org.bson.Document;

public interface ArticleService {
  List<Document> getArticles();
  Document getArticle(String id);
  Document createArticle(Document doc);
}
