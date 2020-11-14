package cm.belrose.stockserveur.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
/**
 *@author  Ngnawen Samuel
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "nom")})
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Code of category must not be null")
    private String code;

    @NotBlank(message = "Name of category must not be null")
    private String nom;

    @OneToMany(mappedBy = "categorie")
    private Collection<ArticleCategorie> articleCategories;

    public Categorie() {
    }

    public Categorie(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Collection<ArticleCategorie> getArticleCategories() {
        return articleCategories;
    }

    public void setArticleCategories(Collection<ArticleCategorie> articleCategories) {
        this.articleCategories = articleCategories;
    }
}
