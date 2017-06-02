package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "PPS_LANGUAGES")
public class LanguageEntity {
    private long lggId;
    private String lggLanguage;
    private Timestamp lggLastUpdateUtc;

    @Id
    @Column(name = "LGG_ID", nullable = false, precision = 0)
    public long getLggId() {
        return lggId;
    }

    public void setLggId(long lggId) {
        this.lggId = lggId;
    }

    @Basic
    @Column(name = "LGG_LANGUAGE", nullable = true, length = 256)
    public String getLggLanguage() {
        return lggLanguage;
    }

    public void setLggLanguage(String lggLanguage) {
        this.lggLanguage = lggLanguage;
    }

    @Basic
    @Column(name = "LGG_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getLggLastUpdateUtc() {
        return lggLastUpdateUtc;
    }

    public void setLggLastUpdateUtc(Timestamp lggLastUpdateUtc) {
        this.lggLastUpdateUtc = lggLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageEntity that = (LanguageEntity) o;

        if (lggId != that.lggId) return false;
        if (lggLanguage != null ? !lggLanguage.equals(that.lggLanguage) : that.lggLanguage != null) return false;
        if (lggLastUpdateUtc != null ? !lggLastUpdateUtc.equals(that.lggLastUpdateUtc) : that.lggLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lggId ^ (lggId >>> 32));
        result = 31 * result + (lggLanguage != null ? lggLanguage.hashCode() : 0);
        result = 31 * result + (lggLastUpdateUtc != null ? lggLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
