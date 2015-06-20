package com.angelhack.inka.controller;

import com.angelhack.inka.exception.ForbiddenException;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@RestController
@RequestMapping("api/user/broadcast")
public class BroadcastController {

    @Autowired
    private BroadcastService broadcastService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.POST)
    public void broadcastItem(@PathVariable Long itemId,
                              @RequestParam double latitude,
                              @RequestParam double longitude) throws ForbiddenException {
        Long currentUserId = securityService.getCurrentUserId();
        broadcastService.broadcastItem(currentUserId, itemId, latitude, longitude);
    }
}
