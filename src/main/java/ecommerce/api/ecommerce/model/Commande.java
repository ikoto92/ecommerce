package ecommerce.api.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    public enum Statut {
        EN_ATTENTE, PAYEE, EN_COURS_DE_LIVRAISON, LIVREE, ANNULEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_commande", nullable = false)
    private LocalDateTime dateCommande;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Statut statut;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesCommande;

    @OneToOne(mappedBy = "commande")
    private Paiement paiement;

    @OneToOne(mappedBy = "commande")
    private Livraison livraison;

    public Commande() {}

    public Commande(Utilisateur utilisateur, BigDecimal total) {
        this.utilisateur = utilisateur;
        this.total = total;
        this.statut = Statut.EN_ATTENTE;
        this.dateCommande = LocalDateTime.now();
    }

    public Integer getId() { return id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public LocalDateTime getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDateTime dateCommande) { this.dateCommande = dateCommande; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public List<LigneCommande> getLignesCommande() { return lignesCommande; }
    public void setLignesCommande(List<LigneCommande> lignesCommande) { this.lignesCommande = lignesCommande; }

    public Paiement getPaiement() { return paiement; }
    public void setPaiement(Paiement paiement) { this.paiement = paiement; }

    public Livraison getLivraison() { return livraison; }
    public void setLivraison(Livraison livraison) { this.livraison = livraison; }
}