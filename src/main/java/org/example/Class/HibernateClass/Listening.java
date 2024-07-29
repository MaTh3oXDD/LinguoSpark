package org.example.Class.HibernateClass;

import javax.persistence.*;

@Entity
@Table(name = "listening")
public class Listening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "answer", nullable = false)
    private String answer;

    // No-argument constructor (required by JPA)
    public Listening() {}

    // Constructor without ID (ID is auto-generated)
    public Listening(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    // Constructor with all fields (including ID)
    public Listening(int id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
