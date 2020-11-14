package cm.belrose.stockserveur.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *@author  Ngnawen Samuel
 */
@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prixAchat;
    private double prixVente;
    @OneToMany(mappedBy = "article")
    private Collection<CommandeClient> commandeClients;
    @OneToMany(mappedBy = "article")
    private Collection<ArticleCategorie> articleCategories;
    @OneToMany(mappedBy = "article")
    private Collection<ArticleVente> articleVentes;
    @OneToMany (mappedBy = "article")
    private Collection<Image> images;
    @OneToMany(mappedBy = "article")
    private Collection<LivraisonFournisseur> livraisonFournisseurs;
    @OneToMany(mappedBy = "article")
    private Collection<MouvementStock> mouvementStocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Collection<CommandeClient> getCommandeClients() {
        return commandeClients;
    }

    public void setCommandeClients(Collection<CommandeClient> commandeClients) {
        this.commandeClients = commandeClients;
    }

    public Collection<ArticleCategorie> getArticleCategories() {
        return articleCategories;
    }

    public void setArticleCategories(Collection<ArticleCategorie> articleCategories) {
        this.articleCategories = articleCategories;
    }

    public Collection<ArticleVente> getArticleVentes() {
        return articleVentes;
    }

    public void setArticleVentes(Collection<ArticleVente> articleVentes) {
        this.articleVentes = articleVentes;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Collection<LivraisonFournisseur> getLivraisonFournisseurs() {
        return livraisonFournisseurs;
    }

    public void setLivraisonFournisseurs(Collection<LivraisonFournisseur> livraisonFournisseurs) {
        this.livraisonFournisseurs = livraisonFournisseurs;
    }

    public Collection<MouvementStock> getMouvementStocks() {
        return mouvementStocks;
    }

    public void setMouvementStocks(Collection<MouvementStock> mouvementStocks) {
        this.mouvementStocks = mouvementStocks;
    }
}
