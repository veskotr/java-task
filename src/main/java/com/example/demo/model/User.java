package com.example.demo.model;

public class User {

    private String email;
    private String username;
    private UserStatus userStatus;

    public User() {
    }

    public User(String email, String username, UserStatus userStatus) {
        this.email = email;
        this.username = username;
        this.userStatus = userStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof final User other))
            return false;
        return email.equals(other.getEmail());
    }

    @Override
    public String toString() {
        return "User [email=" + email
                + ", username=" + username + ", status=" + userStatus.toString() + "]";
    }
}

