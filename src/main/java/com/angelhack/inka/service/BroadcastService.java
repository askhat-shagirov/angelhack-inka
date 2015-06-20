package com.angelhack.inka.service;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
public interface BroadcastService {

    void broadcastItem(long userId, long itemId, double latitude, double longitude);
}
