package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "SERVICE_ITEMS")
public class ServiceItemEntity {
    private long sitemId;
    private String sitemName;
    private String sitemDescription;
    private Timestamp sitemLastUpdateUtc;

    @SequenceGenerator(
            allocationSize = 1,
            name = "course_seq",
            sequenceName = "SEQ_PPS_SITEM_ID"
    )
    @GeneratedValue(generator = "course_seq")

    @Id
    @Column(name = "SITEM_ID", nullable = false, precision = 0)
    public long getSitemId() {
        return sitemId;
    }

    public void setSitemId(long sitemId) {
        this.sitemId = sitemId;
    }

    @Basic
    @Column(name = "SITEM_NAME", nullable = true, length = 128)
    public String getSitemName() {
        return sitemName;
    }

    public void setSitemName(String sitemName) {
        this.sitemName = sitemName;
    }

    @Basic
    @Column(name = "SITEM_DESCRIPTION", nullable = true, length = 1024)
    public String getSitemDescription() {
        return sitemDescription;
    }

    public void setSitemDescription(String sitemDescription) {
        this.sitemDescription = sitemDescription;
    }

    @Basic
    @Column(name = "SITEM_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getSitemLastUpdateUtc() {
        return sitemLastUpdateUtc;
    }

    public void setSitemLastUpdateUtc(Timestamp sitemLastUpdateUtc) {
        this.sitemLastUpdateUtc = sitemLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceItemEntity that = (ServiceItemEntity) o;

        if (sitemId != that.sitemId) return false;
        if (sitemName != null ? !sitemName.equals(that.sitemName) : that.sitemName != null) return false;
        if (sitemDescription != null ? !sitemDescription.equals(that.sitemDescription) : that.sitemDescription != null)
            return false;
        return sitemLastUpdateUtc != null ? sitemLastUpdateUtc.equals(that.sitemLastUpdateUtc) : that.sitemLastUpdateUtc == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (sitemId ^ (sitemId >>> 32));
        result = 31 * result + (sitemName != null ? sitemName.hashCode() : 0);
        result = 31 * result + (sitemDescription != null ? sitemDescription.hashCode() : 0);
        result = 31 * result + (sitemLastUpdateUtc != null ? sitemLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
