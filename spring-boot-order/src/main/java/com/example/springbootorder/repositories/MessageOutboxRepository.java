package com.example.springbootorder.repositories;

import com.example.springbootorder.model.MessageOutbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageOutboxRepository extends JpaRepository<MessageOutbox, Long> {
}
