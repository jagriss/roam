package com.travelwithme.TravelLog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class WishList {

    @Id
    @GeneratedValue
    private int id;

    public String name;
    public String location;
    public String date;
    public String note;

    public WishList(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishList)) return false;
        WishList wishList = (WishList) o;
        return id == wishList.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
