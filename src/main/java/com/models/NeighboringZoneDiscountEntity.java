package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "HZ_NEIGHBORING_ZONE_DISCOUNTS", schema = "PREPAID_SCH", catalog = "")
public class NeighboringZoneDiscountEntity {
    private long hznzdId;
    private Long hznzdLacCellId;
    private String hznzdNeighborLacCellId;
    private Long hznzdDiscountPercentage;
    private Timestamp hznzdLastUpdateUtc;

    @Id
    @Column(name = "HZNZD_ID", nullable = false, precision = 0)
    public long getHznzdId() {
        return hznzdId;
    }

    public void setHznzdId(long hznzdId) {
        this.hznzdId = hznzdId;
    }

    @Basic
    @Column(name = "HZNZD_LAC_CELL_ID", nullable = true, precision = 0)
    public Long getHznzdLacCellId() {
        return hznzdLacCellId;
    }

    public void setHznzdLacCellId(Long hznzdLacCellId) {
        this.hznzdLacCellId = hznzdLacCellId;
    }

    @Basic
    @Column(name = "HZNZD_NEIGHBOR_LAC_CELL_ID", nullable = true, length = 2048)
    public String getHznzdNeighborLacCellId() {
        return hznzdNeighborLacCellId;
    }

    public void setHznzdNeighborLacCellId(String hznzdNeighborLacCellId) {
        this.hznzdNeighborLacCellId = hznzdNeighborLacCellId;
    }

    @Basic
    @Column(name = "HZNZD_DISCOUNT_PERCENTAGE", nullable = true, precision = 0)
    public Long getHznzdDiscountPercentage() {
        return hznzdDiscountPercentage;
    }

    public void setHznzdDiscountPercentage(Long hznzdDiscountPercentage) {
        this.hznzdDiscountPercentage = hznzdDiscountPercentage;
    }

    @Basic
    @Column(name = "HZNZD_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getHznzdLastUpdateUtc() {
        return hznzdLastUpdateUtc;
    }

    public void setHznzdLastUpdateUtc(Timestamp hznzdLastUpdateUtc) {
        this.hznzdLastUpdateUtc = hznzdLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NeighboringZoneDiscountEntity that = (NeighboringZoneDiscountEntity) o;

        if (hznzdId != that.hznzdId) return false;
        if (hznzdLacCellId != null ? !hznzdLacCellId.equals(that.hznzdLacCellId) : that.hznzdLacCellId != null)
            return false;
        if (hznzdNeighborLacCellId != null ? !hznzdNeighborLacCellId.equals(that.hznzdNeighborLacCellId) : that.hznzdNeighborLacCellId != null)
            return false;
        if (hznzdDiscountPercentage != null ? !hznzdDiscountPercentage.equals(that.hznzdDiscountPercentage) : that.hznzdDiscountPercentage != null)
            return false;
        if (hznzdLastUpdateUtc != null ? !hznzdLastUpdateUtc.equals(that.hznzdLastUpdateUtc) : that.hznzdLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hznzdId ^ (hznzdId >>> 32));
        result = 31 * result + (hznzdLacCellId != null ? hznzdLacCellId.hashCode() : 0);
        result = 31 * result + (hznzdNeighborLacCellId != null ? hznzdNeighborLacCellId.hashCode() : 0);
        result = 31 * result + (hznzdDiscountPercentage != null ? hznzdDiscountPercentage.hashCode() : 0);
        result = 31 * result + (hznzdLastUpdateUtc != null ? hznzdLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
