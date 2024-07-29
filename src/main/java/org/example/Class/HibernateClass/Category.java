package org.example.Class.HibernateClass;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_category")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Words> words;

    public Category() {}

    public Category(Long id, String name, Set<Words> words) {
        this.id = id;
        this.name = name;
        this.words = words;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Words> getWords() {
        return words;
    }

    public void setWords(Set<Words> words) {
        this.words = words;
    }
}
