package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Sklenice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsklenice")
    private int idsklenice;
    @Basic
    @Column(name = "složení", insertable=false, updatable=false)
    private String složení;
    @Basic
    @Column(name = "množství")
    private int množství;
//    @OneToMany(mappedBy = "skleniceByIdsklenice")
//    private Collection<Komentař> komentařsByIdsklenice;
    @ManyToOne
    @JoinColumn(name = "složení", referencedColumnName = "složení", nullable = false)
    private Med medBySložení;

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

    public int getMnožství() {
        return množství;
    }

    public void setMnožství(int množství) {
        this.množství = množství;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sklenice sklenice = (Sklenice) o;

        if (idsklenice != sklenice.idsklenice) return false;
        if (množství != sklenice.množství) return false;
        if (složení != null ? !složení.equals(sklenice.složení) : sklenice.složení != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsklenice;
        result = 31 * result + (složení != null ? složení.hashCode() : 0);
        result = 31 * result + množství;
        return result;
    }
//
//    public Collection<Komentař> getKomentařsByIdsklenice() {
//        return komentařsByIdsklenice;
//    }
//
//    public void setKomentařsByIdsklenice(Collection<Komentař> komentařsByIdsklenice) {
//        this.komentařsByIdsklenice = komentařsByIdsklenice;
//    }
//
//    public Med getMedBySložení() {
//        return medBySložení;
//    }
//
//    public void setMedBySložení(Med medBySložení) {
//        this.medBySložení = medBySložení;
//    }
}
