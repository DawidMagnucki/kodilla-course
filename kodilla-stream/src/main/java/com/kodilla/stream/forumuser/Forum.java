package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList =  new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "JohnSmith", 'M', LocalDate.of(1990, 5, 15), 10));
        userList.add(new ForumUser(2, "AnnaBrown", 'F', LocalDate.of(1995, 8, 20), 25));
        userList.add(new ForumUser(3, "MikeJohnson", 'M', LocalDate.of(1985, 12, 3), 5));
        userList.add(new ForumUser(4, "EmilyDavis", 'F', LocalDate.of(2000, 2, 10), 0));
        userList.add(new ForumUser(5, "DavidWilson", 'M', LocalDate.of(1998, 7, 30), 17));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
