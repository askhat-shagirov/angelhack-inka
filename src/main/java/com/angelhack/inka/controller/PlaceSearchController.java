package com.angelhack.inka.controller;

import com.angelhack.inka.dto.PlaceWrapperDto;
import com.angelhack.inka.service.PlaceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
@RestController
@RequestMapping(value = "/api/user/find")
public class PlaceSearchController {

    @Autowired
    private PlaceSearchService placeSearchService;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public List<PlaceWrapperDto> findNearestPlaces(@PathVariable Long itemId,
                                                   @RequestParam double latitude,
                                                   @RequestParam double longitude) {

        return placeSearchService.findNearestPlaces(itemId, latitude, longitude);
    }
}
