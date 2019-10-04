package com.github.jimmy.protobuf;

//import com.github.jimmy.protobuf.Option.GreetingMessage;

public class OptionMain {
    public static void main(String[] args) {
        GreetingMessage greetingMessage = GreetingMessage.newBuilder().setGreeting("hello").setId(1).build();
        System.out.println(greetingMessage);
    }
}
