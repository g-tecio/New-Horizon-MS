package com.cwgx.newhorizon.model;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "social_link")
public class SocialLink {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_social_link;
    private Integer event_id;
    @Length(min=5, max=45)
    private String social_network;
    @Length(min=5, max=45)
    private String source;
    @Length(min=5, max=45)
    private String status;

    public Integer getId_social_link() {
        return id_social_link;
    }

    public void setId_social_link(Integer id_social_link) {
        this.id_social_link = id_social_link;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getSocial_network() {
        return social_network;
    }

    public void setSocial_network(String social_network) {
        this.social_network = social_network;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
