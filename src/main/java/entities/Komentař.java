package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Komentař {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idkomentaře")
    private int idkomentaře;
    @Basic
    @Column(name = "název")
    private String název;
    @Basic
    @Column(name = "výdan")
    private Date výdan;
    @Basic
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idsklenice")
    private int idsklenice;
    @Basic
    @Column(name = "složení")
    private String složení;
    @Basic
    @Column(name = "obsah")
    private String obsah;

    public int getIdkomentaře() {
        return idkomentaře;
    }

    public void setIdkomentaře(int idkomentaře) {
        this.idkomentaře = idkomentaře;
    }

    public String getNázev() {
        return název;
    }

    public void setNázev(String název) {
        this.název = název;
    }

    public Date getVýdan() {
        return výdan;
    }

    public void setVýdan(Date výdan) {
        this.výdan = výdan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsklenice() {
        return idsklenice;
    }

    public void setIdsklenice(int idsklenice) {
        this.idsklenice = idsklenice;
    }

    public String getSložení() {
        return složení;
    }

    public void setSložení(String složení) {
        this.složení = složení;
    }

    public String getObsah() {
        return obsah;
    }

    public void setObsah(String obsah) {
        this.obsah = obsah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Komentař komentař = (Komentař) o;

        if (idkomentaře != komentař.idkomentaře) return false;
        if (id != komentař.id) return false;
        if (idsklenice != komentař.idsklenice) return false;
        if (název != null ? !název.equals(komentař.název) : komentař.název != null) return false;
        if (výdan != null ? !výdan.equals(komentař.výdan) : komentař.výdan != null) return false;
        if (složení != null ? !složení.equals(komentař.složení) : komentař.složení != null) return false;
        if (obsah != null ? !obsah.equals(komentař.obsah) : komentař.obsah != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idkomentaře;
        result = 31 * result + (název != null ? název.hashCode() : 0);
        result = 31 * result + (výdan != null ? výdan.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + idsklenice;
        result = 31 * result + (složení != null ? složení.hashCode() : 0);
        result = 31 * result + (obsah != null ? obsah.hashCode() : 0);
        return result;
    }
}
