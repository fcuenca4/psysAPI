package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "ZONE_CELLS")
public class ZoneCellEntity {
    private long zcId;
    private Long zcZoneId;
    private Long zcCellId;
    private Timestamp zcLastUpdateUtc;

    @SequenceGenerator(
            allocationSize = 1,
            name = "course_seq",
            sequenceName = "SEQ_PPS_ZC_ID"
    )
    @Id
    @GeneratedValue(generator = "course_seq")

    @Column(name = "ZC_ID", nullable = false, precision = 0)
    public long getZcId() {
        return zcId;
    }

    public void setZcId(long zcId) {
        this.zcId = zcId;
    }

    @Basic
    @Column(name = "ZC_ZONE_ID", nullable = true, precision = 0)
    public Long getZcZoneId() {
        return zcZoneId;
    }

    public void setZcZoneId(Long zcZoneId) {
        this.zcZoneId = zcZoneId;
    }

    @Basic
    @Column(name = "ZC_CELL_ID", nullable = true, precision = 0)
    public Long getZcCellId() {
        return zcCellId;
    }

    public void setZcCellId(Long zcCellId) {
        this.zcCellId = zcCellId;
    }

    @Basic
    @Column(name = "ZC_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getZcLastUpdateUtc() {
        return zcLastUpdateUtc;
    }

    public void setZcLastUpdateUtc(Timestamp zcLastUpdateUtc) {
        this.zcLastUpdateUtc = zcLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneCellEntity that = (ZoneCellEntity) o;

        if (zcId != that.zcId) return false;
        if (zcZoneId != null ? !zcZoneId.equals(that.zcZoneId) : that.zcZoneId != null) return false;
        if (zcCellId != null ? !zcCellId.equals(that.zcCellId) : that.zcCellId != null) return false;
        return zcLastUpdateUtc != null ? zcLastUpdateUtc.equals(that.zcLastUpdateUtc) : that.zcLastUpdateUtc == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (zcId ^ (zcId >>> 32));
        result = 31 * result + (zcZoneId != null ? zcZoneId.hashCode() : 0);
        result = 31 * result + (zcCellId != null ? zcCellId.hashCode() : 0);
        result = 31 * result + (zcLastUpdateUtc != null ? zcLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
