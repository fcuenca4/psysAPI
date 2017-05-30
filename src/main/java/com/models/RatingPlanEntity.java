package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "RATING_PLANS", schema = "PREPAID_SCH", catalog = "")
public class RatingPlanEntity {
    private long rplanId;
    private String rplanName;
    private String rplanDescription;
    private Timestamp rplanLastUpdateUtc;
    @SequenceGenerator(
            allocationSize = 1,
            name="course_seq",
            sequenceName="SEQ_PPS_RPLAN_ID"
    )
    @Id
    @GeneratedValue(generator = "course_seq")
    @Column(name = "RPLAN_ID", nullable = false, precision = 0)
    public long getRplanId() {
        return rplanId;
    }

    public void setRplanId(long rplanId) {
        this.rplanId = rplanId;
    }

    @Basic
    @Column(name = "RPLAN_NAME", nullable = true, length = 128)
    public String getRplanName() {
        return rplanName;
    }

    public void setRplanName(String rplanName) {
        this.rplanName = rplanName;
    }

    @Basic
    @Column(name = "RPLAN_DESCRIPTION", nullable = true, length = 1024)
    public String getRplanDescription() {
        return rplanDescription;
    }

    public void setRplanDescription(String rplanDescription) {
        this.rplanDescription = rplanDescription;
    }

    @Basic
    @Column(name = "RPLAN_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getRplanLastUpdateUtc() {
        return rplanLastUpdateUtc;
    }

    public void setRplanLastUpdateUtc(Timestamp rplanLastUpdateUtc) {
        this.rplanLastUpdateUtc = rplanLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingPlanEntity that = (RatingPlanEntity) o;

        if (rplanId != that.rplanId) return false;
        if (rplanName != null ? !rplanName.equals(that.rplanName) : that.rplanName != null) return false;
        if (rplanDescription != null ? !rplanDescription.equals(that.rplanDescription) : that.rplanDescription != null)
            return false;
        if (rplanLastUpdateUtc != null ? !rplanLastUpdateUtc.equals(that.rplanLastUpdateUtc) : that.rplanLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rplanId ^ (rplanId >>> 32));
        result = 31 * result + (rplanName != null ? rplanName.hashCode() : 0);
        result = 31 * result + (rplanDescription != null ? rplanDescription.hashCode() : 0);
        result = 31 * result + (rplanLastUpdateUtc != null ? rplanLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
