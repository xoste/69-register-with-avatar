package com.xoste.leon.pojo;

/**
 * @author Leon
 */
public class Users {
    private int id;
    private String username;
    private String password;
    private String  images;

    public Users() {
    }

    public Users(int id, String username, String password, String images) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
