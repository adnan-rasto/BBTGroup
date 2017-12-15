package com.ara.bbtgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "geolocation")
public class Geolocation {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @Column(name = "geolocation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer geolocationId;

    private Float latitude;
    private Float longitude;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Geolocation() {
        super();
    }

    public Geolocation(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Integer getGeolocationId() {
        return geolocationId;
    }

    public void setGeolocationId(Integer geolocationId) {
        this.geolocationId = geolocationId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
