package com.cwgx.newhorizon.model;
import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_address;

    private Integer event_id;

    private String line_address1;

    private String line_address2;

    private String city;

    private String state;

    private String zip_code;

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getLine_address1() {
        return line_address1;
    }

    public void setLine_address1(String line_address1) {
        this.line_address1 = line_address1;
    }

    public String getLine_address2() {
        return line_address2;
    }

    public void setLine_address2(String line_address2) {
        this.line_address2 = line_address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}
