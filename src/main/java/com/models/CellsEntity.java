package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "CELLS", schema = "PREPAID_SCH", catalog = "")
public class CellsEntity {
    private long cellId;
    private String cellName;
    private Long cellCgi;
    private Long cellLatitude;
    private Long cellLongitude;
    private Long cellRadius;
    private Timestamp cellLastUpdateUtc;

    @SequenceGenerator(
            allocationSize = 1,
            name = "course_seq",
            sequenceName = "SEQ_PPS_CELL_ID"
    )
    @GeneratedValue(generator = "course_seq")
    @Id
    @Column(name = "CELL_ID", nullable = false, precision = 0)
    public long getCellId() {
        return cellId;
    }

    public void setCellId(long cellId) {
        this.cellId = cellId;
    }

    @Basic
    @Column(name = "CELL_NAME", nullable = true, length = 128)
    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    @Basic
    @Column(name = "CELL_CGI", nullable = true, precision = 0)
    public Long getCellCgi() {
        return cellCgi;
    }

    public void setCellCgi(Long cellCgi) {
        this.cellCgi = cellCgi;
    }

    @Basic
    @Column(name = "CELL_LATITUDE", nullable = true, precision = 0)
    public Long getCellLatitude() {
        return cellLatitude;
    }

    public void setCellLatitude(Long cellLatitude) {
        this.cellLatitude = cellLatitude;
    }

    @Basic
    @Column(name = "CELL_LONGITUDE", nullable = true, precision = 0)
    public Long getCellLongitude() {
        return cellLongitude;
    }

    public void setCellLongitude(Long cellLongitude) {
        this.cellLongitude = cellLongitude;
    }

    @Basic
    @Column(name = "CELL_RADIUS", nullable = true, precision = 0)
    public Long getCellRadius() {
        return cellRadius;
    }

    public void setCellRadius(Long cellRadius) {
        this.cellRadius = cellRadius;
    }

    @Basic
    @Column(name = "CELL_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getCellLastUpdateUtc() {
        return cellLastUpdateUtc;
    }

    public void setCellLastUpdateUtc(Timestamp cellLastUpdateUtc) {
        this.cellLastUpdateUtc = cellLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellsEntity that = (CellsEntity) o;

        if (cellId != that.cellId) return false;
        if (cellName != null ? !cellName.equals(that.cellName) : that.cellName != null) return false;
        if (cellCgi != null ? !cellCgi.equals(that.cellCgi) : that.cellCgi != null) return false;
        if (cellLatitude != null ? !cellLatitude.equals(that.cellLatitude) : that.cellLatitude != null) return false;
        if (cellLongitude != null ? !cellLongitude.equals(that.cellLongitude) : that.cellLongitude != null)
            return false;
        if (cellRadius != null ? !cellRadius.equals(that.cellRadius) : that.cellRadius != null) return false;
        return cellLastUpdateUtc != null ? cellLastUpdateUtc.equals(that.cellLastUpdateUtc) : that.cellLastUpdateUtc == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (cellId ^ (cellId >>> 32));
        result = 31 * result + (cellName != null ? cellName.hashCode() : 0);
        result = 31 * result + (cellCgi != null ? cellCgi.hashCode() : 0);
        result = 31 * result + (cellLatitude != null ? cellLatitude.hashCode() : 0);
        result = 31 * result + (cellLongitude != null ? cellLongitude.hashCode() : 0);
        result = 31 * result + (cellRadius != null ? cellRadius.hashCode() : 0);
        result = 31 * result + (cellLastUpdateUtc != null ? cellLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
