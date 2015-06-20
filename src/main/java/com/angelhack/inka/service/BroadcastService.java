package com.angelhack.inka.service;

import com.angelhack.inka.exception.ForbiddenException;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
public interface BroadcastService {

    void broadcastItem(long userId, long itemId, double latitude, double longitude) throws ForbiddenException;
}
