package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_HOME_ZONES", schema = "PREPAID_SCH", catalog = "")
public class HomeZoneEntity {
    private long hzsId;
    private String hzsHomeZone;
    private Timestamp hzsLastUpdateUtc;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_HZS_ID",
            allocationSize=20
    )
    @Column(name = "HZS_ID", nullable = false, precision = 0)
    public long getHzsId() {
        return hzsId;
    }

    public void setHzsId(long hzsId) {
        this.hzsId = hzsId;
    }

    @Basic
    @Column(name = "HZS_HOME_ZONE", nullable = false, length = 256)
    public String getHzsHomeZone() {
        return hzsHomeZone;
    }

    public void setHzsHomeZone(String hzsHomeZone) {
        this.hzsHomeZone = hzsHomeZone;
    }

    @Basic
    @Column(name = "HZS_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getHzsLastUpdateUtc() {
        return hzsLastUpdateUtc;
    }

    public void setHzsLastUpdateUtc(Timestamp hzsLastUpdateUtc) {
        this.hzsLastUpdateUtc = hzsLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeZoneEntity that = (HomeZoneEntity) o;

        if (hzsId != that.hzsId) return false;
        if (hzsHomeZone != null ? !hzsHomeZone.equals(that.hzsHomeZone) : that.hzsHomeZone != null) return false;
        if (hzsLastUpdateUtc != null ? !hzsLastUpdateUtc.equals(that.hzsLastUpdateUtc) : that.hzsLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (hzsId ^ (hzsId >>> 32));
        result = 31 * result + (hzsHomeZone != null ? hzsHomeZone.hashCode() : 0);
        result = 31 * result + (hzsLastUpdateUtc != null ? hzsLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
