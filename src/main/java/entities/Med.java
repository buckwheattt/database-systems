package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Med {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "složení")
    private String složení;
    //@OneToMany(mappedBy = "medBySložení")
    //private Collection<Komentař> komentařsBySložení;

    public String getSložení() {
        return složení;
    }

    public void setSložení(String složení) {
        this.složení = složení;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Med med = (Med) o;

        if (složení != null ? !složení.equals(med.složení) : med.složení != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return složení != null ? složení.hashCode() : 0;
    }

//    public Collection<Komentař> getKomentařsBySložení() {
//        return komentařsBySložení;
//    }
//
//    public void setKomentařsBySložení(Collection<Komentař> komentařsBySložení) {
//        this.komentařsBySložení = komentařsBySložení;
//    }
}
