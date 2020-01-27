package Library;

import Library.DB_CONNECTION.ConnectDB;

public class Author {
    private String name;
    private String surname;
    private int id;
    public Author(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        ConnectDB.addAuthor(this.name, this.surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
