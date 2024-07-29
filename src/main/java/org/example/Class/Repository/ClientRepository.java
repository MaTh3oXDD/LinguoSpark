package org.example.Class.Repository;

import org.example.Class.HibernateClass.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Definiowanie niestandardowych metod zapytań (opcjonalne)
    Optional<Client> findByUsername(String username);
}
