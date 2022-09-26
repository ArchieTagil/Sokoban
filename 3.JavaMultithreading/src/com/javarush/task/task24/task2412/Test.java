package com.javarush.task.task24.task2412;

import java.awt.*;
import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.*;
import java.lang.Comparable;
import java.util.List;

public class Test {
    public static class Message {
        private String message;
        private int id;

        public Message(String message) {
            this.message = message;
            this.id = new Random().nextInt(1000);
        }

        public String getMessage() {
            return message;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public String toString() {
            return "[" + id + "] " + message;
        }
    }

    public static void main(String[] args) {
        Comparator<Message> comparator = Comparator.comparing(message -> message.getId());

        List<Message> messages = new ArrayList();
        messages.add(new Message("Hello, World!"));
        messages.add(new Message("Hello, Sun!"));
        messages.add(new Message("Hello, Mercury!"));
        messages.add(new Message("Hello, Venus!"));
        messages.add(new Message("Hello, Moon!"));
        messages.add(new Message("Hello, Saturn!"));
        messages.add(new Message("Hello, Jupiter!"));
        Collections.sort(messages, comparator);
        messages.forEach(System.out::println);
        System.out.println("\n##############################################################\n\n");

        MessageFormat form = new MessageFormat("Я могу {1} {0}.");
        int count = 4;
        String exercise = "подтянуться";

        Object[] testArgs = {count, exercise};

        double[] fileLimits = {0, 2, 5};
        String[] filePart = {"{0} раз", "{0} раза", "{0} раз"};

        ChoiceFormat fileForm = new ChoiceFormat(fileLimits, filePart);
        form.setFormatByArgumentIndex(0, fileForm);

        System.out.println(form.format(testArgs));
    }
}