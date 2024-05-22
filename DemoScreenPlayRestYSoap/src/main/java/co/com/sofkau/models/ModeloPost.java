package co.com.sofkau.models;

import jakarta.xml.bind.annotation.XmlRootElement;

public class ModeloPost {
    private String userName;
    private String password;

    public ModeloPost(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public ModeloPost() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
