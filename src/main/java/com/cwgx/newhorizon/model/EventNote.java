package com.cwgx.newhorizon.model;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "event_note")
public class EventNote {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_event_note;
    private Integer event_id;
    @Length(min=5, max=45)
    private String text;
    @Length(min=5, max=45)
    private String status;
    private String time_stamp;

    public Integer getId_event_note() {
        return id_event_note;
    }
    public void setId_event_note(Integer id_event_note) {
        this.id_event_note = id_event_note;
    }
    public Integer getEvent_id() {
        return event_id;
    }
    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTime_stamp() {
        return time_stamp;
    }
    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
}
