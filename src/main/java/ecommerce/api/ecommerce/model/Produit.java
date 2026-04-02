package ecommerce.api.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> lignesCommande;

    @OneToMany(mappedBy = "produit")
    private List<Avis> avis;

    public Produit() {}

    public Produit(String nom, BigDecimal prix, Integer stock, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
    }

    public Integer getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public List<LigneCommande> getLignesCommande() { return lignesCommande; }
    public void setLignesCommande(List<LigneCommande> lignesCommande) { this.lignesCommande = lignesCommande; }

    public List<Avis> getAvis() { return avis; }
    public void setAvis(List<Avis> avis) { this.avis = avis; }
}