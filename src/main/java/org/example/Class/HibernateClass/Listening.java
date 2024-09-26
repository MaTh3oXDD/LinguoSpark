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

    public Listening() {}

    public Listening(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    public Listening(int id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;
    }

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
