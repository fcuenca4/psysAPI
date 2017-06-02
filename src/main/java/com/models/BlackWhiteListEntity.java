package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "PPS_BLACK_WHITE_LIST")
public class BlackWhiteListEntity {
    private long bwlId;
    private Long bwlScbId;
    private String bwlBlackWhiteList;
    private Long bwlSvtId;
    private String bwlDn;
    private Timestamp bwlLastUpdateUtc;
    private String bwlDescription;
    @SequenceGenerator(
            allocationSize = 1,
            name="whitelist_seq",
            sequenceName="SEQ_PPS_BWL_ID"
    )
    @GeneratedValue(generator = "whitelist_seq")
    @Id
    @Column(name = "BWL_ID", nullable = false, precision = 0)
    public long getBwlId() {
        return bwlId;
    }

    public void setBwlId(long bwlId) {
        this.bwlId = bwlId;
    }

    @Basic
    @Column(name = "BWL_SCB_ID", nullable = true, precision = 0)
    public Long getBwlScbId() {
        return bwlScbId;
    }

    public void setBwlScbId(Long bwlScbId) {
        this.bwlScbId = bwlScbId;
    }

    @Basic
    @Column(name = "BWL_BLACK_WHITE_LIST", nullable = true, length = 5)
    public String getBwlBlackWhiteList() {
        return bwlBlackWhiteList;
    }

    public void setBwlBlackWhiteList(String bwlBlackWhiteList) {
        this.bwlBlackWhiteList = bwlBlackWhiteList;
    }

    @Basic
    @Column(name = "BWL_SVT_ID", nullable = true, precision = 0)
    public Long getBwlSvtId() {
        return bwlSvtId;
    }

    public void setBwlSvtId(Long bwlSvtId) {
        this.bwlSvtId = bwlSvtId;
    }

    @Basic
    @Column(name = "BWL_DESCRIPTION", nullable = true, length = 255)
    public String getBwlDescription() {
        return bwlDescription;
    }

    public void setBwlDescription(String bwlDescription) {
        this.bwlDescription = bwlDescription;
    }
    @Basic
    @Column(name = "BWL_DN", nullable = true, length = 64)
    public String getBwlDn() {
        return bwlDn;
    }

    public void setBwlDn(String bwlDn) {
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
        if (bwlScbId != null ? !bwlScbId.equals(that.bwlScbId) : that.bwlScbId != null) return false;
        if (bwlBlackWhiteList != null ? !bwlBlackWhiteList.equals(that.bwlBlackWhiteList) : that.bwlBlackWhiteList != null)
            return false;
        if (bwlSvtId != null ? !bwlSvtId.equals(that.bwlSvtId) : that.bwlSvtId != null) return false;
        if (bwlDn != null ? !bwlDn.equals(that.bwlDn) : that.bwlDn != null) return false;
        if (bwlLastUpdateUtc != null ? !bwlLastUpdateUtc.equals(that.bwlLastUpdateUtc) : that.bwlLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bwlId ^ (bwlId >>> 32));
        result = 31 * result + (bwlScbId != null ? bwlScbId.hashCode() : 0);
        result = 31 * result + (bwlBlackWhiteList != null ? bwlBlackWhiteList.hashCode() : 0);
        result = 31 * result + (bwlSvtId != null ? bwlSvtId.hashCode() : 0);
        result = 31 * result + (bwlDn != null ? bwlDn.hashCode() : 0);
        result = 31 * result + (bwlLastUpdateUtc != null ? bwlLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
