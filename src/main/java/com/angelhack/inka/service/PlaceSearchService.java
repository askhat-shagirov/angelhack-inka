package com.angelhack.inka.service;

import se.walkercrou.places.Place;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */

public interface PlaceSearchService {

    List<Place> findPlaces(Long itemId);

}
