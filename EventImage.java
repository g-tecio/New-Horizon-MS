package com.cwgx.newhorizon.model;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "event_image")
public class EventImage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id_event_image;
    private Integer event_id;
    @Length(min=5, max=45)
    private String source;
    private String created_at;
    @Length(min=5, max=45)
    private String status;

    public Integer getId_event_image() {
        return id_event_image;
    }

    public void setId_event_image(Integer id_event_image) {
        this.id_event_image = id_event_image;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
