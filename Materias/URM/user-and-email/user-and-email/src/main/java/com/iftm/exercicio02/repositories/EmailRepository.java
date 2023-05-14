package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface EmailRepository extends JpaRepository<Email, Long> {

        @Query("SELECT e FROM Email e WHERE e.user.id = :userId")
        List<Email> findByUserId(@Param("userId") Long userId);

        List<Email> findBySubjectContaining(String keyword);

}