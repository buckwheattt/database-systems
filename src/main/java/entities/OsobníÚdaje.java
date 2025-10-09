package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "osobní_údaje", schema = "public", catalog = "grechsof")
public class OsobníÚdaje {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "jméno")
    private String jméno;
    @Basic
    @Column(name = "příjmení")
    private String příjmení;
    @Basic
    @Column(name = "narozen")
    private Date narozen;
    @Basic
    @Column(name = "obec")
    private String obec;
    @Basic
    @Column(name = "č_p")
    private int čP;
    @Basic
    @Column(name = "ulice")
    private String ulice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJméno() {
        return jméno;
    }

    public void setJméno(String jméno) {
        this.jméno = jméno;
    }

    public String getPříjmení() {
        return příjmení;
    }

    public void setPříjmení(String příjmení) {
        this.příjmení = příjmení;
    }

    public Date getNarozen() {
        return narozen;
    }

    public void setNarozen(Date narozen) {
        this.narozen = narozen;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public int getčP() {
        return čP;
    }

    public void setčP(int čP) {
        this.čP = čP;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OsobníÚdaje that = (OsobníÚdaje) o;

        if (id != that.id) return false;
        if (čP != that.čP) return false;
        if (jméno != null ? !jméno.equals(that.jméno) : that.jméno != null) return false;
        if (příjmení != null ? !příjmení.equals(that.příjmení) : that.příjmení != null) return false;
        if (narozen != null ? !narozen.equals(that.narozen) : that.narozen != null) return false;
        if (obec != null ? !obec.equals(that.obec) : that.obec != null) return false;
        if (ulice != null ? !ulice.equals(that.ulice) : that.ulice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jméno != null ? jméno.hashCode() : 0);
        result = 31 * result + (příjmení != null ? příjmení.hashCode() : 0);
        result = 31 * result + (narozen != null ? narozen.hashCode() : 0);
        result = 31 * result + (obec != null ? obec.hashCode() : 0);
        result = 31 * result + čP;
        result = 31 * result + (ulice != null ? ulice.hashCode() : 0);
        return result;
    }
}
