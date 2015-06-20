package com.angelhack.inka.service.impl;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.PlaceWrapperDto;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.service.PlaceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
@Service
@Transactional
public class PlaceSearchServiceImpl implements PlaceSearchService {

    @Autowired
    private GooglePlaces places;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<PlaceWrapperDto> findNearestPlaces(Long itemId, double latitude, double longitude) {
        ItemEntity item = itemRepository.findOne(itemId);

        List<Place> nearbyPlaces = places.getNearbyPlacesRankedByDistance(latitude, longitude, Param.name("types").value(buildTypes(item)));
        final List<PlaceWrapperDto> result = new ArrayList<>();

        for (Place place : nearbyPlaces) {
            result.add(new PlaceWrapperDto(place));
        }
        return result;
    }

    private String buildTypes(ItemEntity item) {
        String types = "";
        for (ItemCategory itemCategory : item.getCategories()) {
            types += itemCategory + "|";
        }
        return types.substring(0, types.length() - 1);
    }
}
