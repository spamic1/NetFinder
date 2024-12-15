package com.spitz.netfinder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "net", schema = "netfinder")
public class Net implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "lat", nullable = false)
    private Integer lat;

    @NotNull
    @Column(name = "lon", nullable = false)
    private Integer lon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid_person_reported")
    private Person uidPersonReported;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid_person_recover")
    private Person uidPersonRecover;

    @Column(name = "is_recovered")
    private Byte isRecovered;

    @Column(name = "is_lost")
    private Byte isLost;

    public Net() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Person getUidPersonReported() {
        return uidPersonReported;
    }

    public void setUidPersonReported(Person uidPersonReported) {
        this.uidPersonReported = uidPersonReported;
    }

    public Person getUidPersonRecover() {
        return uidPersonRecover;
    }

    public void setUidPersonRecover(Person uidPersonRecover) {
        this.uidPersonRecover = uidPersonRecover;
    }

    public Byte getIsRecovered() {
        return isRecovered;
    }

    public void setIsRecovered(Byte isRecovered) {
        this.isRecovered = isRecovered;
    }

    public Byte getIsLost() {
        return isLost;
    }

    public void setIsLost(Byte isLost) {
        this.isLost = isLost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Net net = (Net) o;
        return Objects.equals(getId(), net.getId()) && Objects.equals(getLat(), net.getLat()) && Objects.equals(getLon(), net.getLon()) && Objects.equals(getUidPersonReported(), net.getUidPersonReported()) && Objects.equals(getUidPersonRecover(), net.getUidPersonRecover()) && Objects.equals(getIsRecovered(), net.getIsRecovered()) && Objects.equals(getIsLost(), net.getIsLost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLat(), getLon(), getUidPersonReported(), getUidPersonRecover(), getIsRecovered(), getIsLost());
    }

    @Override
    public String toString() {
        return "Net{" +
                "id=" + id +
                ", lat=" + lat +
                ", lon=" + lon +
                ", uidPersonReported=" + uidPersonReported +
                ", uidPersonRecover=" + uidPersonRecover +
                ", isRecovered=" + isRecovered +
                ", isLost=" + isLost +
                '}';
    }
}