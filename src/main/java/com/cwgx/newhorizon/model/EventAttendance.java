package com.cwgx.newhorizon.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "event_attendance")
public class EventAttendance {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_event_attendance;

    private Integer event_id;

    private Integer customer_id;

    private String customer_name;

    private String last_modified;

    private String created_at;

    private String status;

    public Integer getId_event_attendance() {
        return id_event_attendance;
    }

    public void setId_event_attendance(Integer id_event_attendance) {
        this.id_event_attendance = id_event_attendance;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
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
