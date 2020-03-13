package main.java.net.ju.unibook.entities;

public class Database {
    private String dbName;
    public Database(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbProperties() {
        return (this.dbName + "_db.properties");
    }
}
