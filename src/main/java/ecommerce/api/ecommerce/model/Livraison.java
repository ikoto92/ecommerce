package ecommerce.api.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "livraison")
public class Livraison {

    public enum Statut {
        PREPARATION, EXPEDIE, EN_TRANSIT, LIVRE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "commande_id", nullable = false, unique = true)
    private Commande commande;

    @Column(columnDefinition = "TEXT")
    private String adresse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Statut statut;

    @Column(name = "date_livraison")
    private LocalDate dateLivraison;

    public Livraison() {}

    public Livraison(Commande commande, String adresse) {
        this.commande = commande;
        this.adresse = adresse;
        this.statut = Statut.PREPARATION;
    }

    public Integer getId() { return id; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public LocalDate getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(LocalDate dateLivraison) { this.dateLivraison = dateLivraison; }
}