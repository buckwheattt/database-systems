package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "včelí_ul", schema = "public", catalog = "grechsof")
public class VčelíUl {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "úl_id")
    private int úlId;
    @Basic
    @Column(name = "počet_rámečků")
    private int početRámečků;
    @Basic
    @Column(name = "složení", insertable=false, updatable=false)
    private String složení;
    @Basic
    @Column(name = "včelař", insertable=false, updatable=false)
    private int včelař;
    @ManyToOne
    @JoinColumn(name = "složení", referencedColumnName = "složení", nullable = false)
    private Med medBySložení;
    @ManyToOne
    @JoinColumn(name = "včelař", referencedColumnName = "id", nullable = false)
    private Včelař včelařByVčelař;

    public int getÚlId() {
        return úlId;
    }

    public void setÚlId(int úlId) {
        this.úlId = úlId;
    }

    public int getPočetRámečků() {
        return početRámečků;
    }

    public void setPočetRámečků(int početRámečků) {
        this.početRámečků = početRámečků;
    }

    public String getSložení() {
        return složení;
    }

    public void setSložení(String složení) {
        this.složení = složení;
    }

    public int getVčelař() {
        return včelař;
    }

    public void setVčelař(int včelař) {
        this.včelař = včelař;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VčelíUl včelíUl = (VčelíUl) o;

        if (úlId != včelíUl.úlId) return false;
        if (početRámečků != včelíUl.početRámečků) return false;
        if (včelař != včelíUl.včelař) return false;
        if (složení != null ? !složení.equals(včelíUl.složení) : včelíUl.složení != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = úlId;
        result = 31 * result + početRámečků;
        result = 31 * result + (složení != null ? složení.hashCode() : 0);
        result = 31 * result + včelař;
        return result;
    }

    public Med getMedBySložení() {
        return medBySložení;
    }

    public void setMedBySložení(Med medBySložení) {
        this.medBySložení = medBySložení;
    }

    public Včelař getVčelařByVčelař() {
        return včelařByVčelař;
    }

    public void setVčelařByVčelař(Včelař včelařByVčelař) {
        this.včelařByVčelař = včelařByVčelař;
    }
}
