package com.example.alextarasyuk.keepsolidalextarasyukproject.model;

/**
 * Created by t420 on 25.07.2017.
 */

public class User {

    private String userName;
    private int userId;
    private boolean isOnline;
    private String userAddress;
    private Category category;

    public enum Category {FRIENDS, FAMILY, WORK, OTHERS}

    public User(String username, int userId, boolean isOnline, String userAddress, Category category) {
        this.userName = username;
        this.userId = userId;
        this.isOnline = isOnline;
        this.userAddress = userAddress;
        this.category = category;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (isOnline != user.isOnline) return false;
        if (!userName.equals(user.userName)) return false;
        if (!userAddress.equals(user.userAddress)) return false;
        return category == user.category;

    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + userId;
        result = 31 * result + (isOnline ? 1 : 0);
        result = 31 * result + userAddress.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}