package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* 
Анонимность иногда так приятна!
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public List<User> getUsers() {
        return new ArrayList<User>();
    }

    public List<Location> getLocations() {
        return new ArrayList<>();
    }

    public List<Server> getServers() {
        return new ArrayList<>();
    }

    public List<Subject> getSubjects() {
        return new ArrayList<>();
    }

    public List<Subscription> getSubscriptions() {
        return new ArrayList<>();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
