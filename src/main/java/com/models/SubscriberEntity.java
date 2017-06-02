package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 6/1/17.
 */
@Entity
@Table(name = "PPS_SUBSCRIBERS")
public class SubscriberEntity {
    private long scbId;
    private String scbDn;
    private String scbLastName;
    private String scbFirstName;
    private Long scbIdentificationNumber;
    private String scbAddressStreet;
    private String scbAddressNumber;
    private String scbAddressFloor;
    private String scbAddressDepartment;
    private String scbImsi;
    private String scbModel;
    private Long scbLggId;
    private Long scbRplanId;
    private Long scbSclassId;
    private String scbPassword;
    private Long scbCommunityId;
    private String scbHomeZone;
    private Long scbHzRplanId;
    private String scbPingPokeCall;
    private Timestamp scbLastUpdateUtc;
    private String yieldZone;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subscriber_seq")
    @SequenceGenerator(
            name="subscriber_seq",
            sequenceName="SEQ_PPS_SCB_ID",
            allocationSize=1
    )

    @Column(name = "SCB_ID", nullable = false, precision = 0)

    public long getScbId() {
        return scbId;
    }

    public void setScbId(long scbId) {
        this.scbId = scbId;
    }

    @Basic
    @Column(name = "SCB_DN", nullable = true, length = 64)
    public String getScbDn() {
        return scbDn;
    }

    public void setScbDn(String scbDn) {
        this.scbDn = scbDn;
    }

    @Column(name = "SCB_Yield_Zone", nullable = true, length = 1)
    public String getYieldZone() {
        return yieldZone;
    }

    public void setYieldZone(String yieldZone) {
        this.yieldZone = yieldZone;
    }
    @Basic
    @Column(name = "SCB_LAST_NAME", nullable = true, length = 256)
    public String getScbLastName() {
        return scbLastName;
    }

    public void setScbLastName(String scbLastName) {
        this.scbLastName = scbLastName;
    }

    @Basic
    @Column(name = "SCB_FIRST_NAME", nullable = true, length = 256)
    public String getScbFirstName() {
        return scbFirstName;
    }

    public void setScbFirstName(String scbFirstName) {
        this.scbFirstName = scbFirstName;
    }

    @Basic
    @Column(name = "SCB_IDENTIFICATION_NUMBER", nullable = true, precision = 0)
    public Long getScbIdentificationNumber() {
        return scbIdentificationNumber;
    }

    public void setScbIdentificationNumber(Long scbIdentificationNumber) {
        this.scbIdentificationNumber = scbIdentificationNumber;
    }

    @Basic
    @Column(name = "SCB_ADDRESS_STREET", nullable = true, length = 1024)
    public String getScbAddressStreet() {
        return scbAddressStreet;
    }

    public void setScbAddressStreet(String scbAddressStreet) {
        this.scbAddressStreet = scbAddressStreet;
    }

    @Basic
    @Column(name = "SCB_ADDRESS_NUMBER", nullable = true, length = 128)
    public String getScbAddressNumber() {
        return scbAddressNumber;
    }

    public void setScbAddressNumber(String scbAddressNumber) {
        this.scbAddressNumber = scbAddressNumber;
    }

    @Basic
    @Column(name = "SCB_ADDRESS_FLOOR", nullable = true, length = 32)
    public String getScbAddressFloor() {
        return scbAddressFloor;
    }

    public void setScbAddressFloor(String scbAddressFloor) {
        this.scbAddressFloor = scbAddressFloor;
    }

    @Basic
    @Column(name = "SCB_ADDRESS_DEPARTMENT", nullable = true, length = 64)
    public String getScbAddressDepartment() {
        return scbAddressDepartment;
    }

    public void setScbAddressDepartment(String scbAddressDepartment) {
        this.scbAddressDepartment = scbAddressDepartment;
    }

    @Basic
    @Column(name = "SCB_IMSI", nullable = true, length = 256)
    public String getScbImsi() {
        return scbImsi;
    }

    public void setScbImsi(String scbImsi) {
        this.scbImsi = scbImsi;
    }

    @Basic
    @Column(name = "SCB_MODEL", nullable = true, length = 528)
    public String getScbModel() {
        return scbModel;
    }

    public void setScbModel(String scbModel) {
        this.scbModel = scbModel;
    }

    @Basic
    @Column(name = "SCB_LGG_ID", nullable = true, precision = 0)
    public Long getScbLggId() {
        return scbLggId;
    }

    public void setScbLggId(Long scbLggId) {
        this.scbLggId = scbLggId;
    }

    @Basic
    @Column(name = "SCB_RPLAN_ID", nullable = true, precision = 0)
    public Long getScbRplanId() {
        return scbRplanId;
    }

    public void setScbRplanId(Long scbRplanId) {
        this.scbRplanId = scbRplanId;
    }

    @Basic
    @Column(name = "SCB_SCLASS_ID", nullable = true, precision = 0)
    public Long getScbSclassId() {
        return scbSclassId;
    }

    public void setScbSclassId(Long scbSclassId) {
        this.scbSclassId = scbSclassId;
    }

    @Basic
    @Column(name = "SCB_PASSWORD", nullable = true, length = 1)
    public String getScbPassword() {
        return scbPassword;
    }

    public void setScbPassword(String scbPassword) {
        this.scbPassword = scbPassword;
    }

    @Basic
    @Column(name = "SCB_COMMUNITY_ID", nullable = true, precision = 0)
    public Long getScbCommunityId() {
        return scbCommunityId;
    }

    public void setScbCommunityId(Long scbCommunityId) {
        this.scbCommunityId = scbCommunityId;
    }

    @Basic
    @Column(name = "SCB_HOME_ZONE", nullable = true, length = 1)
    public String getScbHomeZone() {
        return scbHomeZone;
    }

    public void setScbHomeZone(String scbHomeZone) {
        this.scbHomeZone = scbHomeZone;
    }

    @Basic
    @Column(name = "SCB_HZ_RPLAN_ID", nullable = true, precision = 0)
    public Long getScbHzRplanId() {
        return scbHzRplanId;
    }

    public void setScbHzRplanId(Long scbHzRplanId) {
        this.scbHzRplanId = scbHzRplanId;
    }

    @Basic
    @Column(name = "SCB_PING_POKE_CALL", nullable = true, length = 1)
    public String getScbPingPokeCall() {
        return scbPingPokeCall;
    }

    public void setScbPingPokeCall(String scbPingPokeCall) {
        this.scbPingPokeCall = scbPingPokeCall;
    }

    @Basic
    @Column(name = "SCB_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getScbLastUpdateUtc() {
        return scbLastUpdateUtc;
    }

    public void setScbLastUpdateUtc(Timestamp scbLastUpdateUtc) {
        this.scbLastUpdateUtc = scbLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriberEntity that = (SubscriberEntity) o;

        if (scbId != that.scbId) return false;
        if (scbDn != null ? !scbDn.equals(that.scbDn) : that.scbDn != null) return false;
        if (scbLastName != null ? !scbLastName.equals(that.scbLastName) : that.scbLastName != null) return false;
        if (scbFirstName != null ? !scbFirstName.equals(that.scbFirstName) : that.scbFirstName != null) return false;
        if (scbIdentificationNumber != null ? !scbIdentificationNumber.equals(that.scbIdentificationNumber) : that.scbIdentificationNumber != null)
            return false;
        if (scbAddressStreet != null ? !scbAddressStreet.equals(that.scbAddressStreet) : that.scbAddressStreet != null)
            return false;
        if (scbAddressNumber != null ? !scbAddressNumber.equals(that.scbAddressNumber) : that.scbAddressNumber != null)
            return false;
        if (scbAddressFloor != null ? !scbAddressFloor.equals(that.scbAddressFloor) : that.scbAddressFloor != null)
            return false;
        if (scbAddressDepartment != null ? !scbAddressDepartment.equals(that.scbAddressDepartment) : that.scbAddressDepartment != null)
            return false;
        if (scbImsi != null ? !scbImsi.equals(that.scbImsi) : that.scbImsi != null) return false;
        if (scbModel != null ? !scbModel.equals(that.scbModel) : that.scbModel != null) return false;
        if (scbLggId != null ? !scbLggId.equals(that.scbLggId) : that.scbLggId != null) return false;
        if (scbRplanId != null ? !scbRplanId.equals(that.scbRplanId) : that.scbRplanId != null) return false;
        if (scbSclassId != null ? !scbSclassId.equals(that.scbSclassId) : that.scbSclassId != null) return false;
        if (scbPassword != null ? !scbPassword.equals(that.scbPassword) : that.scbPassword != null) return false;
        if (scbCommunityId != null ? !scbCommunityId.equals(that.scbCommunityId) : that.scbCommunityId != null)
            return false;
        if (scbHomeZone != null ? !scbHomeZone.equals(that.scbHomeZone) : that.scbHomeZone != null) return false;
        if (scbHzRplanId != null ? !scbHzRplanId.equals(that.scbHzRplanId) : that.scbHzRplanId != null) return false;
        if (scbPingPokeCall != null ? !scbPingPokeCall.equals(that.scbPingPokeCall) : that.scbPingPokeCall != null)
            return false;
        if (scbLastUpdateUtc != null ? !scbLastUpdateUtc.equals(that.scbLastUpdateUtc) : that.scbLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (scbId ^ (scbId >>> 32));
        result = 31 * result + (scbDn != null ? scbDn.hashCode() : 0);
        result = 31 * result + (scbLastName != null ? scbLastName.hashCode() : 0);
        result = 31 * result + (scbFirstName != null ? scbFirstName.hashCode() : 0);
        result = 31 * result + (scbIdentificationNumber != null ? scbIdentificationNumber.hashCode() : 0);
        result = 31 * result + (scbAddressStreet != null ? scbAddressStreet.hashCode() : 0);
        result = 31 * result + (scbAddressNumber != null ? scbAddressNumber.hashCode() : 0);
        result = 31 * result + (scbAddressFloor != null ? scbAddressFloor.hashCode() : 0);
        result = 31 * result + (scbAddressDepartment != null ? scbAddressDepartment.hashCode() : 0);
        result = 31 * result + (scbImsi != null ? scbImsi.hashCode() : 0);
        result = 31 * result + (scbModel != null ? scbModel.hashCode() : 0);
        result = 31 * result + (scbLggId != null ? scbLggId.hashCode() : 0);
        result = 31 * result + (scbRplanId != null ? scbRplanId.hashCode() : 0);
        result = 31 * result + (scbSclassId != null ? scbSclassId.hashCode() : 0);
        result = 31 * result + (scbPassword != null ? scbPassword.hashCode() : 0);
        result = 31 * result + (scbCommunityId != null ? scbCommunityId.hashCode() : 0);
        result = 31 * result + (scbHomeZone != null ? scbHomeZone.hashCode() : 0);
        result = 31 * result + (scbHzRplanId != null ? scbHzRplanId.hashCode() : 0);
        result = 31 * result + (scbPingPokeCall != null ? scbPingPokeCall.hashCode() : 0);
        result = 31 * result + (scbLastUpdateUtc != null ? scbLastUpdateUtc.hashCode() : 0);
        return result;
    }


}
