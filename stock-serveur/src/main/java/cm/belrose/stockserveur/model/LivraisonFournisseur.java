package cm.belrose.stockserveur.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *@author  Ngnawen Samuel
 */

@Entity
public class  LivraisonFournisseur extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    @ManyToOne
    private Article article;
    @ManyToOne
    private Personne personne;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
