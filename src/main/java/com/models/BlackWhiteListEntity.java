package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_BLACK_WHITE_LIST", schema = "PREPAID_SCH", catalog = "")
public class BlackWhiteListEntity {
    private long bwlId;
    private long bwlScbId;
    private String bwlBlackWhiteList;
    private long bwlSvtId;
    private long bwlDn;
    private Timestamp bwlLastUpdateUtc;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_BWL_ID",
            allocationSize=20
    )
    @Column(name = "BWL_ID", nullable = false, precision = 0)
    public long getBwlId() {
        return bwlId;
    }

    public void setBwlId(long bwlId) {
        this.bwlId = bwlId;
    }

    @Basic
    @Column(name = "BWL_SCB_ID", nullable = false, precision = 0)
    public long getBwlScbId() {
        return bwlScbId;
    }

    public void setBwlScbId(long bwlScbId) {
        this.bwlScbId = bwlScbId;
    }

    @Basic
    @Column(name = "BWL_BLACK_WHITE_LIST", nullable = false, length = 5)
    public String getBwlBlackWhiteList() {
        return bwlBlackWhiteList;
    }

    public void setBwlBlackWhiteList(String bwlBlackWhiteList) {
        this.bwlBlackWhiteList = bwlBlackWhiteList;
    }

    @Basic
    @Column(name = "BWL_SVT_ID", nullable = false, precision = 0)
    public long getBwlSvtId() {
        return bwlSvtId;
    }

    public void setBwlSvtId(long bwlSvtId) {
        this.bwlSvtId = bwlSvtId;
    }

    @Basic
    @Column(name = "BWL_DN", nullable = false, precision = 0)
    public long getBwlDn() {
        return bwlDn;
    }

    public void setBwlDn(long bwlDn) {
        this.bwlDn = bwlDn;
    }

    @Basic
    @Column(name = "BWL_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getBwlLastUpdateUtc() {
        return bwlLastUpdateUtc;
    }

    public void setBwlLastUpdateUtc(Timestamp bwlLastUpdateUtc) {
        this.bwlLastUpdateUtc = bwlLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackWhiteListEntity that = (BlackWhiteListEntity) o;

        if (bwlId != that.bwlId) return false;
        if (bwlScbId != that.bwlScbId) return false;
        if (bwlSvtId != that.bwlSvtId) return false;
        if (bwlDn != that.bwlDn) return false;
        if (bwlBlackWhiteList != null ? !bwlBlackWhiteList.equals(that.bwlBlackWhiteList) : that.bwlBlackWhiteList != null)
            return false;
        if (bwlLastUpdateUtc != null ? !bwlLastUpdateUtc.equals(that.bwlLastUpdateUtc) : that.bwlLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bwlId ^ (bwlId >>> 32));
        result = 31 * result + (int) (bwlScbId ^ (bwlScbId >>> 32));
        result = 31 * result + (bwlBlackWhiteList != null ? bwlBlackWhiteList.hashCode() : 0);
        result = 31 * result + (int) (bwlSvtId ^ (bwlSvtId >>> 32));
        result = 31 * result + (int) (bwlDn ^ (bwlDn >>> 32));
        result = 31 * result + (bwlLastUpdateUtc != null ? bwlLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
