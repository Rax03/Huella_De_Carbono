//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.conection;

import java.io.Serializable;

public class ConnectionProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    private String server;
    private String port;
    private String database;
    private String user;
    private String password;

    public ConnectionProperties(String server, String port, String database, String user, String password) {
        this.server = server;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public ConnectionProperties() {
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "ConnectionProperties{server='" + this.server + "', port='" + this.port + "', database='" + this.database + "', user='" + this.user + "', password='" + this.password + "'}";
    }

    public String getURL() {
        return "jdbc:mariadb://" + this.server + ":" + this.port + "/" + this.database;
    }
}

