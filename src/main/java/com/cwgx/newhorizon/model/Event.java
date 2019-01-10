package com.cwgx.newhorizon.model;


import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_event;

    private String event_name;

    private String description;

    private String venue_name;

    private String attire;

    private String event_image;

    private Integer capacity;

    private String revenue_generation;

    private String start_date;

    private String end_date;

    private Double latitude;

    private Double longitude;

    private String event_type;

    private String status;

    private boolean published;

    private Integer event_price;

    public Integer getId_event() {
        return id_event;
    }

    public void setId_event(Integer id_event) {
        this.id_event = id_event;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getAttire() {
        return attire;
    }

    public void setAttire(String attire) {
        this.attire = attire;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRevenue_generation() {
        return revenue_generation;
    }

    public void setRevenue_generation(String revenue_generation) {
        this.revenue_generation = revenue_generation;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Integer getEvent_price() {
        return event_price;
    }

    public void setEvent_price(Integer event_price) {
        this.event_price = event_price;
    }

}
