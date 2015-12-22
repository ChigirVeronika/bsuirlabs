package by.bsuir.sum.entity;

/**
 * Created by Вероника on 10.05.2015.
 */
public class Friend {
    private String id;
    private String name;
    private String surname;
    private String friend;

    public Friend(String id, String name, String surname, String friend) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.friend = friend;
    }

    public Friend(String text) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
