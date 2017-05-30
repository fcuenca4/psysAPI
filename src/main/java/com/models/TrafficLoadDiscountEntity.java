package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "HZ_TRAFFIC_LOAD_DISCOUNTS", schema = "PREPAID_SCH", catalog = "")
public class TrafficLoadDiscountEntity {
    private long hztldId;
    private Long hztldOrder;
    private String hztldLac;
    private String hztldCellId;
    private String hztldOcupationDiscountPlan;
    private Timestamp hztldLastUpdateUtc;

    @Id
    @Column(name = "HZTLD_ID", nullable = false, precision = 0)
    public long getHztldId() {
        return hztldId;
    }

    public void setHztldId(long hztldId) {
        this.hztldId = hztldId;
    }

    @Basic
    @Column(name = "HZTLD_ORDER", nullable = true, precision = 0)
    public Long getHztldOrder() {
        return hztldOrder;
    }

    public void setHztldOrder(Long hztldOrder) {
        this.hztldOrder = hztldOrder;
    }

    @Basic
    @Column(name = "HZTLD_LAC", nullable = true, length = 512)
    public String getHztldLac() {
        return hztldLac;
    }

    public void setHztldLac(String hztldLac) {
        this.hztldLac = hztldLac;
    }

    @Basic
    @Column(name = "HZTLD_CELL_ID", nullable = true, length = 512)
    public String getHztldCellId() {
        return hztldCellId;
    }

    public void setHztldCellId(String hztldCellId) {
        this.hztldCellId = hztldCellId;
    }

    @Basic
    @Column(name = "HZTLD_OCUPATION_DISCOUNT_PLAN", nullable = true, length = 512)
    public String getHztldOcupationDiscountPlan() {
        return hztldOcupationDiscountPlan;
    }

    public void setHztldOcupationDiscountPlan(String hztldOcupationDiscountPlan) {
        this.hztldOcupationDiscountPlan = hztldOcupationDiscountPlan;
    }

    @Basic
    @Column(name = "HZTLD_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getHztldLastUpdateUtc() {
        return hztldLastUpdateUtc;
    }

    public void setHztldLastUpdateUtc(Timestamp hztldLastUpdateUtc) {
        this.hztldLastUpdateUtc = hztldLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficLoadDiscountEntity that = (TrafficLoadDiscountEntity) o;

        if (hztldId != that.hztldId) return false;
        if (hztldOrder != null ? !hztldOrder.equals(that.hztldOrder) : that.hztldOrder != null) return false;
        if (hztldLac != null ? !hztldLac.equals(that.hztldLac) : that.hztldLac != null) return false;
        if (hztldCellId != null ? !hztldCellId.equals(that.hztldCellId) : that.hztldCellId != null) return false;
        if (hztldOcupationDiscountPlan != null ? !hztldOcupationDiscountPlan.equals(that.hztldOcupationDiscountPlan) : that.hztldOcupationDiscountPlan != null)
            return false;
        if (hztldLastUpdateUtc != null ? !hztldLastUpdateUtc.equals(that.hztldLastUpdateUtc) : that.hztldLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hztldId ^ (hztldId >>> 32));
        result = 31 * result + (hztldOrder != null ? hztldOrder.hashCode() : 0);
        result = 31 * result + (hztldLac != null ? hztldLac.hashCode() : 0);
        result = 31 * result + (hztldCellId != null ? hztldCellId.hashCode() : 0);
        result = 31 * result + (hztldOcupationDiscountPlan != null ? hztldOcupationDiscountPlan.hashCode() : 0);
        result = 31 * result + (hztldLastUpdateUtc != null ? hztldLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
