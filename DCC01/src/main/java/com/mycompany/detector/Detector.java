package com.mycompany.detector;

import javax.persistence.*;


@Entity
@Table(name = "dcc01devices")
public class Detector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 9, name="Device_Charset")
    private String detCharset;

    @Column(length = 45, nullable = false, name="Device_Type")
    private String detType;

    @Column(length = 45, nullable = false, name="Device_Name")
    private String detName;

    @Column(length = 45, nullable = false, name="Device_SerialNumber")
    private String detSerial;

    @Column(length = 10, nullable = false, name="Room_Index")
    private String roomIndex;

    @Column(length = 45, nullable = false, name="Room_Name")
    private String roomName;

    @Column(nullable = false, name="Enabled")
    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetCharset() {
        return detCharset;
    }

    public void setDetCharset(String detCharset) {
        this.detCharset = detCharset;
    }

    public String getDetType() {
        return detType;
    }

    public void setDetType(String detType) {
        this.detType = detType;
    }

    public String getDetName() {
        return detName;
    }

    public void setDetName(String detName) {
        this.detName = detName;
    }

    public String getDetSerial() {
        return detSerial;
    }

    public void setDetSerial(String detSerial) {
        this.detSerial = detSerial;
    }

    public String getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(String roomIndex) {
        this.roomIndex = roomIndex;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

        @Override
    public String toString() {
        return "Detector{" +
                "id=" + id +
                ", detCharset='" + detCharset + '\'' +
                ", detType='" + detType + '\'' +
                ", detName='" + detName + '\'' +
                ", detSerial='" + detSerial + '\'' +
                ", roomIndex='" + roomIndex + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
