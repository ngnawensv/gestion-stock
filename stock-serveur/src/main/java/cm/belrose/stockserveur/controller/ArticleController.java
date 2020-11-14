package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le 10/11/2020
 *
 * @author Ngnawen Samuel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> findAll() throws Exception{
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> findById(@PathVariable("id") Long id) throws Exception{
        return new ResponseEntity<>(articleService.findById(id).get(),HttpStatus.FOUND);
    }

    @PostMapping("/article")
    public ResponseEntity<Article> save(@RequestBody Article article) throws Exception{
        return new ResponseEntity<>(articleService.save(article),HttpStatus.CREATED);
    }

    @PutMapping("/update/article/{id}")
    public ResponseEntity<Article>  update(@PathVariable("id") Long id, @RequestBody Article article) throws Exception{
        article.setId(id);
        return new ResponseEntity<>(articleService.save(article),HttpStatus.OK);
    }

    @DeleteMapping("/delete/article/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception{
        Article article=articleService.findById(id).get();
        if(article!=null){
            articleService.delete(article);
        }
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
