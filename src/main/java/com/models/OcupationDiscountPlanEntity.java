package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "HZ_OCUPATION_DISCOUNT_PLANS", schema = "PREPAID_SCH", catalog = "")
public class OcupationDiscountPlanEntity {
    private long hzodpId;
    private String hzodpPlan;
    private String hzodpProduct;
    private String hzodpCallType;
    private Long hzodpMinOcup;
    private Long hzodpMaxOcup;
    private Long hzodpDiscountPercentage;
    private Timestamp hzodpLastUpdateUtc;

    @Id
    @Column(name = "HZODP_ID", nullable = false, precision = 0)
    public long getHzodpId() {
        return hzodpId;
    }

    public void setHzodpId(long hzodpId) {
        this.hzodpId = hzodpId;
    }

    @Basic
    @Column(name = "HZODP_PLAN", nullable = true, length = 512)
    public String getHzodpPlan() {
        return hzodpPlan;
    }

    public void setHzodpPlan(String hzodpPlan) {
        this.hzodpPlan = hzodpPlan;
    }

    @Basic
    @Column(name = "HZODP_PRODUCT", nullable = true, length = 512)
    public String getHzodpProduct() {
        return hzodpProduct;
    }

    public void setHzodpProduct(String hzodpProduct) {
        this.hzodpProduct = hzodpProduct;
    }

    @Basic
    @Column(name = "HZODP_CALL_TYPE", nullable = true, length = 512)
    public String getHzodpCallType() {
        return hzodpCallType;
    }

    public void setHzodpCallType(String hzodpCallType) {
        this.hzodpCallType = hzodpCallType;
    }

    @Basic
    @Column(name = "HZODP_MIN_OCUP", nullable = true, precision = 0)
    public Long getHzodpMinOcup() {
        return hzodpMinOcup;
    }

    public void setHzodpMinOcup(Long hzodpMinOcup) {
        this.hzodpMinOcup = hzodpMinOcup;
    }

    @Basic
    @Column(name = "HZODP_MAX_OCUP", nullable = true, precision = 0)
    public Long getHzodpMaxOcup() {
        return hzodpMaxOcup;
    }

    public void setHzodpMaxOcup(Long hzodpMaxOcup) {
        this.hzodpMaxOcup = hzodpMaxOcup;
    }

    @Basic
    @Column(name = "HZODP_DISCOUNT_PERCENTAGE", nullable = true, precision = 0)
    public Long getHzodpDiscountPercentage() {
        return hzodpDiscountPercentage;
    }

    public void setHzodpDiscountPercentage(Long hzodpDiscountPercentage) {
        this.hzodpDiscountPercentage = hzodpDiscountPercentage;
    }

    @Basic
    @Column(name = "HZODP_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getHzodpLastUpdateUtc() {
        return hzodpLastUpdateUtc;
    }

    public void setHzodpLastUpdateUtc(Timestamp hzodpLastUpdateUtc) {
        this.hzodpLastUpdateUtc = hzodpLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OcupationDiscountPlanEntity that = (OcupationDiscountPlanEntity) o;

        if (hzodpId != that.hzodpId) return false;
        if (hzodpPlan != null ? !hzodpPlan.equals(that.hzodpPlan) : that.hzodpPlan != null) return false;
        if (hzodpProduct != null ? !hzodpProduct.equals(that.hzodpProduct) : that.hzodpProduct != null) return false;
        if (hzodpCallType != null ? !hzodpCallType.equals(that.hzodpCallType) : that.hzodpCallType != null)
            return false;
        if (hzodpMinOcup != null ? !hzodpMinOcup.equals(that.hzodpMinOcup) : that.hzodpMinOcup != null) return false;
        if (hzodpMaxOcup != null ? !hzodpMaxOcup.equals(that.hzodpMaxOcup) : that.hzodpMaxOcup != null) return false;
        if (hzodpDiscountPercentage != null ? !hzodpDiscountPercentage.equals(that.hzodpDiscountPercentage) : that.hzodpDiscountPercentage != null)
            return false;
        if (hzodpLastUpdateUtc != null ? !hzodpLastUpdateUtc.equals(that.hzodpLastUpdateUtc) : that.hzodpLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hzodpId ^ (hzodpId >>> 32));
        result = 31 * result + (hzodpPlan != null ? hzodpPlan.hashCode() : 0);
        result = 31 * result + (hzodpProduct != null ? hzodpProduct.hashCode() : 0);
        result = 31 * result + (hzodpCallType != null ? hzodpCallType.hashCode() : 0);
        result = 31 * result + (hzodpMinOcup != null ? hzodpMinOcup.hashCode() : 0);
        result = 31 * result + (hzodpMaxOcup != null ? hzodpMaxOcup.hashCode() : 0);
        result = 31 * result + (hzodpDiscountPercentage != null ? hzodpDiscountPercentage.hashCode() : 0);
        result = 31 * result + (hzodpLastUpdateUtc != null ? hzodpLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
