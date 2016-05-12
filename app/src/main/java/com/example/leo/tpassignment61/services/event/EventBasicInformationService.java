package com.example.leo.tpassignment61.services.event;

import android.content.Context;

import com.example.leo.tpassignment61.domain.event.EventBasicInformation;

/**
 * Created by Leo on 5/8/2016.
 */
public interface EventBasicInformationService {
    void addEventBasicInformation(Context context,EventBasicInformation eventContact);
    void updateEventBasicInformation(Context context,EventBasicInformation eventContact);
}
