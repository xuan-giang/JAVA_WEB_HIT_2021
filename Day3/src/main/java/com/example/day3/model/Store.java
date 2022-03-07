package com.example.day3.model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<User> userList = new ArrayList<>();

    public Store() {
        userList.add(new User("1", "xuangiang1", "abc123", "Nguyễn Xuân Giang"));
    }

    static void initUser()
    {
        userList.add(new User("2", "xuangiang2", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("3", "xuangiang3", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("4", "xuangiang4", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("5", "xuangiang5", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("6", "xuangiang6", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("7", "xuangiang7", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("8", "xuangiang8", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("9", "xuangiang9", "abc123", "Nguyễn Xuân Giang"));
        userList.add(new User("10", "xuangiang10", "abc123", "Nguyễn Xuân Giang"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Boolean isExist(User user)
    {

        for (User user1 : userList) {
            if(user.equals(user1))
            {
                return true;
            }
        }
        return false;
    }
}
