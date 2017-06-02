package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "COMMUNITIES")
public class CommunityEntity {
    private long communityId;
    private String communityName;
    private String communityDescription;
    private Timestamp communityLastUpdateUtc;
    @Id
    @Column(name = "COMMUNITY_ID", nullable = false, precision = 0)
    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    @Basic
    @Column(name = "COMMUNITY_NAME", nullable = true, length = 128)
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Basic
    @Column(name = "COMMUNITY_DESCRIPTION", nullable = true, length = 1024)
    public String getCommunityDescription() {
        return communityDescription;
    }

    public void setCommunityDescription(String communityDescription) {
        this.communityDescription = communityDescription;
    }

    @Basic
    @Column(name = "COMMUNITY_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getCommunityLastUpdateUtc() {
        return communityLastUpdateUtc;
    }

    public void setCommunityLastUpdateUtc(Timestamp communityLastUpdateUtc) {
        this.communityLastUpdateUtc = communityLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunityEntity that = (CommunityEntity) o;

        if (communityId != that.communityId) return false;
        if (communityName != null ? !communityName.equals(that.communityName) : that.communityName != null)
            return false;
        if (communityDescription != null ? !communityDescription.equals(that.communityDescription) : that.communityDescription != null)
            return false;
        if (communityLastUpdateUtc != null ? !communityLastUpdateUtc.equals(that.communityLastUpdateUtc) : that.communityLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (communityId ^ (communityId >>> 32));
        result = 31 * result + (communityName != null ? communityName.hashCode() : 0);
        result = 31 * result + (communityDescription != null ? communityDescription.hashCode() : 0);
        result = 31 * result + (communityLastUpdateUtc != null ? communityLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
