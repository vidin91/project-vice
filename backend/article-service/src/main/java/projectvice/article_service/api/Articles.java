package projectvice.article_service.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.bson.Document;

import projectvice.article_service.service.impl.ArticleServiceImpl;

@Path("/article")
public class Articles {
  static int MAX_LIMIT = 1000;

  @Path("/{id}")
  @GET
  public String getById(@PathParam("id") String id, @QueryParam("limit") int limit) {
    Document ret = ArticleServiceImpl.getInstance().getArticle(id);
    return ret != null ? ret.toJson() : null;
  }
  
  @Path("/test")
  @POST
  @Consumes("application/json")
  public String tt(String test) {
    return "MILENI" + test;
  }
}
