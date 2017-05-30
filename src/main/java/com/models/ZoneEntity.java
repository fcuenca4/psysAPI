package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "ZONES", schema = "PREPAID_SCH", catalog = "")
public class ZoneEntity {
    private long zoneId;
    private String zoneName;
    private String zoneDescription;
    private Timestamp zoneLastUpdateUtc;

    @Id
    @Column(name = "ZONE_ID", nullable = false, precision = 0)
    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "ZONE_NAME", nullable = true, length = 128)
    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Basic
    @Column(name = "ZONE_DESCRIPTION", nullable = true, length = 1024)
    public String getZoneDescription() {
        return zoneDescription;
    }

    public void setZoneDescription(String zoneDescription) {
        this.zoneDescription = zoneDescription;
    }

    @Basic
    @Column(name = "ZONE_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getZoneLastUpdateUtc() {
        return zoneLastUpdateUtc;
    }

    public void setZoneLastUpdateUtc(Timestamp zoneLastUpdateUtc) {
        this.zoneLastUpdateUtc = zoneLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneEntity that = (ZoneEntity) o;

        if (zoneId != that.zoneId) return false;
        if (zoneName != null ? !zoneName.equals(that.zoneName) : that.zoneName != null) return false;
        if (zoneDescription != null ? !zoneDescription.equals(that.zoneDescription) : that.zoneDescription != null)
            return false;
        if (zoneLastUpdateUtc != null ? !zoneLastUpdateUtc.equals(that.zoneLastUpdateUtc) : that.zoneLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (zoneId ^ (zoneId >>> 32));
        result = 31 * result + (zoneName != null ? zoneName.hashCode() : 0);
        result = 31 * result + (zoneDescription != null ? zoneDescription.hashCode() : 0);
        result = 31 * result + (zoneLastUpdateUtc != null ? zoneLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
