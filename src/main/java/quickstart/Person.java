package quickstart;

import grails.persistence.Entity;

/**
 * Created by anatoly on 16.15.8.
 */
@Entity
public class Person {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
