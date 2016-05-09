package com.example.leo.tpassignment61.services.event;

import android.content.Context;

import com.example.leo.tpassignment61.domain.event.Event;
import com.example.leo.tpassignment61.domain.event.EventAddress;

/**
 * Created by Leo on 5/8/2016.
 */
public interface EventAddressService {
    void addPEventAddress(Context context,EventAddress address);
    void updateEventAddress(Context context,EventAddress address);
}
