package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Zakaznik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
//    @OneToOne(mappedBy = "zakaznikByZákazník")
//    private Doporučil doporučilById;
//    @OneToMany(mappedBy = "zakaznikByDoporučený")
//    private Collection<Doporučil> doporučilsById;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Uživatel uživatelById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zakaznik zakaznik = (Zakaznik) o;

        if (id != zakaznik.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

//    public Doporučil getDoporučilById() {
//        return doporučilById;
//    }
//
//    public void setDoporučilById(Doporučil doporučilById) {
//        this.doporučilById = doporučilById;
//    }
//
//    public Collection<Doporučil> getDoporučilsById() {
//        return doporučilsById;
//    }
//
//    public void setDoporučilsById(Collection<Doporučil> doporučilsById) {
//        this.doporučilsById = doporučilsById;
//    }
//
//    public Uživatel getUživatelById() {
//        return uživatelById;
//    }
//
//    public void setUživatelById(Uživatel uživatelById) {
//        this.uživatelById = uživatelById;
//    }
}
