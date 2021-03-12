package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.ArticleDto;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.payload.response.MessageResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.belrose.stockserveur.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value=APP_ROOT+"/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto) ;

    @GetMapping(value=APP_ROOT+"/articles/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("id") Long id);

    @GetMapping(value=APP_ROOT+"/articles/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(@PathVariable("code") String code);

    @GetMapping(value=APP_ROOT+"/articles",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value=APP_ROOT+"/articles/{id}")
    void delete(@PathVariable("id") Long id) ;


}
