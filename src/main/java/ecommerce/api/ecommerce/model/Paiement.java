package ecommerce.api.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paiement")
public class Paiement {

    public enum Methode {
        CARTE_BANCAIRE, PAYPAL, VIREMENT, CRYPTO
    }

    public enum Statut {
        SUCCES, ECHEC, REMBOURSE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "commande_id", nullable = false, unique = true)
    private Commande commande;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Methode methode;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Statut statut;

    @Column(name = "date_paiement")
    private LocalDateTime datePaiement;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal montant;

    public Paiement() {}

    public Paiement(Commande commande, Methode methode, BigDecimal montant) {
        this.commande = commande;
        this.methode = methode;
        this.montant = montant;
        this.datePaiement = LocalDateTime.now();
    }

    public Integer getId() { return id; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public Methode getMethode() { return methode; }
    public void setMethode(Methode methode) { this.methode = methode; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) { this.datePaiement = datePaiement; }

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
}