package com.angelhack.inka.service;

import com.angelhack.inka.dto.PlaceWrapperDto;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
public interface PlaceSearchService {
    List<PlaceWrapperDto> findNearestPlaces(Long itemId, double latitude, double longitude);
}
