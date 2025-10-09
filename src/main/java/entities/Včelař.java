package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Včelař {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "ma_spolupracující")
    private Integer maSpolupracující;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Uživatel uživatelById;
    @ManyToOne
    @JoinColumn(name = "ma_spolupracující", referencedColumnName = "id", insertable=false, updatable=false)
    private Včelař včelařByMaSpolupracující;
//    @OneToMany(mappedBy = "včelařByMaSpolupracující")
//    private Collection<Včelař> včelařsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMaSpolupracující() {
        return maSpolupracující;
    }

    public void setMaSpolupracující(Integer maSpolupracující) {
        this.maSpolupracující = maSpolupracující;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Včelař včelař = (Včelař) o;

        if (id != včelař.id) return false;
        if (url != null ? !url.equals(včelař.url) : včelař.url != null) return false;
        if (maSpolupracující != null ? !maSpolupracující.equals(včelař.maSpolupracující) : včelař.maSpolupracující != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (maSpolupracující != null ? maSpolupracující.hashCode() : 0);
        return result;
    }
//
//    public Uživatel getUživatelById() {
//        return uživatelById;
//    }
//
//    public void setUživatelById(Uživatel uživatelById) {
//        this.uživatelById = uživatelById;
//    }
//
//    public Včelař getVčelařByMaSpolupracující() {
//        return včelařByMaSpolupracující;
//    }
//
//    public void setVčelařByMaSpolupracující(Včelař včelařByMaSpolupracující) {
//        this.včelařByMaSpolupracující = včelařByMaSpolupracující;
//    }
//
//    public Collection<Včelař> getVčelařsById() {
//        return včelařsById;
//    }
//
//    public void setVčelařsById(Collection<Včelař> včelařsById) {
//        this.včelařsById = včelařsById;
//    }
}
