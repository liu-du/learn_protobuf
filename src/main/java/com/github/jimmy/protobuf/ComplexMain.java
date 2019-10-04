package com.github.jimmy.protobuf;

import example.complex.Complex;
import example.complex.Complex.DummyMessage;

public class ComplexMain {
    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();
        DummyMessage dummyMessage =
                builder.setId(id)
                        .setName(name)
                        .build();

        return dummyMessage;
    }

    public static void main(String[] args) {
        DummyMessage oneDummy = newDummyMessage(1, "yes");
        Complex.ComplexMessage.Builder builder = Complex.ComplexMessage.newBuilder();
        Complex.ComplexMessage complexMessage = builder.setOneDummy(oneDummy)
                .addMultipleDummy(newDummyMessage(2, "comp"))
                .addMultipleDummy(newDummyMessage(3, "simp"))
                .build();
        System.out.println(complexMessage.toString());
    }
}
