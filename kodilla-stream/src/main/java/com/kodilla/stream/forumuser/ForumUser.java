package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int postCount;

    public ForumUser(final int userID, final String username, final char gender,
                     final LocalDate dateOfBirth, final int postCount) {
        this.userID = userID;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.postCount = postCount;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", postCount=" + postCount +
                '}';
    }
}
