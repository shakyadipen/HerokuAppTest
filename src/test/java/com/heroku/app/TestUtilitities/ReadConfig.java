package com.heroku.app.TestUtilitities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fs = new FileInputStream(src);
            pro = new Properties();
            pro.load(fs);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getApplicationUrl(){
        String URL=pro.getProperty("baseUrl");
        return URL;
    }
    public String getUsername(){
        String username=pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String pwd=pro.getProperty("password");
        return pwd;
    }
}
