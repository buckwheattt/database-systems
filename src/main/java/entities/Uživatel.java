package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Uživatel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "heslo")
    private String heslo;
//    @OneToMany(mappedBy = "uživatelById")
//    private Collection<Komentař> komentařsById;
//    @OneToOne(mappedBy = "uživatelById")
//    private OsobníÚdaje osobníÚdajeById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getLogin() {
//        return login;
//    }

    public void setLogin(String login) {
        this.login = login;
    }

//    public String getHeslo() {
//        return heslo;
//    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uživatel uživatel = (Uživatel) o;

        if (id != uživatel.id) return false;
        if (login != null ? !login.equals(uživatel.login) : uživatel.login != null) return false;
        if (heslo != null ? !heslo.equals(uživatel.heslo) : uživatel.heslo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (heslo != null ? heslo.hashCode() : 0);
        return result;
    }
//
//    public Collection<Komentař> getKomentařsById() {
//        return komentařsById;
//    }
//
//    public void setKomentařsById(Collection<Komentař> komentařsById) {
//        this.komentařsById = komentařsById;
//    }
//
//    public OsobníÚdaje getOsobníÚdajeById() {
//        return osobníÚdajeById;
//    }
//
//    public void setOsobníÚdajeById(OsobníÚdaje osobníÚdajeById) {
//        this.osobníÚdajeById = osobníÚdajeById;
//    }
}
