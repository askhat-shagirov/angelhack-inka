package com.angelhack.inka.dto;

import se.walkercrou.places.Place;
import se.walkercrou.places.Scope;
import se.walkercrou.places.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
public class PlaceWrapperDto {

    private List<String> types = new ArrayList();
    private String placeId;
    private Scope scope;
    private double lat = -1.0D;
    private double lng = -1.0D;
    private String iconUrl;
    private String name;
    private String addr;
    private String vicinity;
    private double rating = -1.0D;
    private Status status;
    private String phone;
    private String internationalPhone;
    private String googleUrl;
    private String website;

    public PlaceWrapperDto(Place place) {
        this.types = place.getTypes();
        this.placeId = place.getPlaceId();
        this.scope = place.getScope();
        this.lat = place.getLatitude();
        this.lng = place.getLongitude();
        this.iconUrl = place.getIconUrl();
        this.name = place.getName();
        this.addr = place.getAddress();
        this.vicinity = place.getVicinity();
        this.rating = place.getRating();
        this.phone = place.getPhoneNumber();
        this.internationalPhone = place.getInternationalPhoneNumber();
        this.googleUrl = place.getGoogleUrl();
        this.website = place.getWebsite();
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInternationalPhone() {
        return internationalPhone;
    }

    public void setInternationalPhone(String internationalPhone) {
        this.internationalPhone = internationalPhone;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
