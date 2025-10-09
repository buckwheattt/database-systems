package entities;

import jakarta.persistence.*;

@Entity
public class Doporučil {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "zákazník")
    private int zákazník;
    @Basic
    @Column(name = "doporučený")
    private Integer doporučený;

    public int getZákazník() {
        return zákazník;
    }

    public void setZákazník(int zákazník) {
        this.zákazník = zákazník;
    }

    public Integer getDoporučený() {
        return doporučený;
    }

    public void setDoporučený(Integer doporučený) {
        this.doporučený = doporučený;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doporučil doporučil = (Doporučil) o;

        if (zákazník != doporučil.zákazník) return false;
        if (doporučený != null ? !doporučený.equals(doporučil.doporučený) : doporučil.doporučený != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zákazník;
        result = 31 * result + (doporučený != null ? doporučený.hashCode() : 0);
        return result;
    }
}
