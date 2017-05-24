package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_COMMUNITIES", schema = "PREPAID_SCH", catalog = "")
public class CommunityEntity {
    private long cmmId;
    private String cmmCommunity;
    private Timestamp cmmLastUpdateUtc;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_CMM_ID",
            allocationSize=20
    )
    @Column(name = "CMM_ID", nullable = false, precision = 0)
    public long getCmmId() {
        return cmmId;
    }

    public void setCmmId(long cmmId) {
        this.cmmId = cmmId;
    }

    @Basic
    @Column(name = "CMM_COMMUNITY", nullable = false, length = 256)
    public String getCmmCommunity() {
        return cmmCommunity;
    }

    public void setCmmCommunity(String cmmCommunity) {
        this.cmmCommunity = cmmCommunity;
    }

    @Basic
    @Column(name = "CMM_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getCmmLastUpdateUtc() {
        return cmmLastUpdateUtc;
    }

    public void setCmmLastUpdateUtc(Timestamp cmmLastUpdateUtc) {
        this.cmmLastUpdateUtc = cmmLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunityEntity that = (CommunityEntity) o;

        if (cmmId != that.cmmId) return false;
        if (cmmCommunity != null ? !cmmCommunity.equals(that.cmmCommunity) : that.cmmCommunity != null) return false;
        if (cmmLastUpdateUtc != null ? !cmmLastUpdateUtc.equals(that.cmmLastUpdateUtc) : that.cmmLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cmmId ^ (cmmId >>> 32));
        result = 31 * result + (cmmCommunity != null ? cmmCommunity.hashCode() : 0);
        result = 31 * result + (cmmLastUpdateUtc != null ? cmmLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
