package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "v_statistique_categorie")
public class StatistiqueCategorie {
    @Id
    @Column(name = "id_categorie")
    private short idCategorie;

    @Column(name = "libelle_categorie", length = 50)
    private String libelleCategorie;

    @Column(name = "nombre_enchere", nullable = false)
    private int nombreEnchere;

    @Column(name = "revenu", nullable = false)
    private double revenu;

    @Column(name = "enchere_gagnee", nullable = false)
    private int enchereGagnee;

    @Column(name = "enchere_perdue", nullable = false)
    private int encherePerdue;

    @Column(name = "win_rate")
    private float winRate;

    @Column(name = "loss_rate")
    private float lossRate;

    public short getIdCategorie() {
        return idCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public int getNombreEnchere() {
        return nombreEnchere;
    }

    public double getRevenu() {
        return revenu;
    }

    public int getEnchereGagnee() {
        return enchereGagnee;
    }

    public int getEncherePerdue() {
        return encherePerdue;
    }

    public float getWinRate() {
        return winRate;
    }

    public float getLossRate() {
        return lossRate;
    }

}