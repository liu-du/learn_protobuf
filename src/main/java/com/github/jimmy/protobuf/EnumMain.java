package com.github.jimmy.protobuf;

import example.enumerations.EnumExample.EnumMessage;
import static example.enumerations.EnumExample.DayOfTheWeek.MONDAY;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example for Enums");
        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345)
                .setDayOfTheWeek(MONDAY);

        EnumMessage message = builder.build();
        System.out.println(message);


    }
}
