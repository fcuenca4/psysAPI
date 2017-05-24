package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_RATING_PLANS", schema = "PREPAID_SCH", catalog = "")
public class RatingPlanEntity {
    private long rplId;
    private String rplRatingPlan;
    private Timestamp rplLastUpdateUtc;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_RPL_ID",
            allocationSize=20
    )
    @Column(name = "RPL_ID", nullable = false, precision = 0)
    public long getRplId() {
        return rplId;
    }

    public void setRplId(long rplId) {
        this.rplId = rplId;
    }

    @Basic
    @Column(name = "RPL_RATING_PLAN", nullable = false, length = 256)
    public String getRplRatingPlan() {
        return rplRatingPlan;
    }

    public void setRplRatingPlan(String rplRatingPlan) {
        this.rplRatingPlan = rplRatingPlan;
    }

    @Basic
    @Column(name = "RPL_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getRplLastUpdateUtc() {
        return rplLastUpdateUtc;
    }

    public void setRplLastUpdateUtc(Timestamp rplLastUpdateUtc) {
        this.rplLastUpdateUtc = rplLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingPlanEntity that = (RatingPlanEntity) o;

        if (rplId != that.rplId) return false;
        if (rplRatingPlan != null ? !rplRatingPlan.equals(that.rplRatingPlan) : that.rplRatingPlan != null)
            return false;
        if (rplLastUpdateUtc != null ? !rplLastUpdateUtc.equals(that.rplLastUpdateUtc) : that.rplLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rplId ^ (rplId >>> 32));
        result = 31 * result + (rplRatingPlan != null ? rplRatingPlan.hashCode() : 0);
        result = 31 * result + (rplLastUpdateUtc != null ? rplLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
