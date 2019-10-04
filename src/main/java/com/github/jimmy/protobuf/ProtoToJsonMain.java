package com.github.jimmy.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        System.out.println("hello world");
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // build the message
        builder.setId(42)
                .setIsSimple(true)
                .setName("My name")
                .addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());
        SimpleMessage message = builder.build();

        // serialize to file
        try {
            FileOutputStream os = new FileOutputStream("simple_message.bin");
            message.writeTo(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = message.toByteArray();
        System.out.println("byte array...");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(String.format("%02x", bytes[i]));
            System.out.print(" ");
        }
        System.out.println();

        try {
            FileInputStream is = new FileInputStream("simple_message.bin");
            SimpleMessage message2 = SimpleMessage.parseFrom(is);
            System.out.println("reading ...");
            System.out.println(message2);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
        JsonFormat.parser().merge(jsonString, builder2);
        System.out.println(builder2);
    }
}
