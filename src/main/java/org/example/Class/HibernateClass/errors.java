package org.example.Class.HibernateClass;
import javax.persistence.*;

@Entity
@Table(name = "errors")
public class errors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    private Words wordId;

    @Column(name = "error_count", nullable = false)
    private int errorCount;

    @Column(name = "attempt_count", nullable = false)
    private int attemptCount;


    public errors(int id, Client clientId, Words wordId, int errorCount, int attemptCount) {
        this.id = id;
        this.clientId = clientId;
        this.wordId = wordId;
        this.errorCount = errorCount;
        this.attemptCount = attemptCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Words getWordId() {
        return wordId;
    }

    public void setWordId(Words wordId) {
        this.wordId = wordId;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }
}
