package com.react.repository;

import com.react.models.Conversaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversacionesRepository extends JpaRepository<Conversaciones, Long> {

}
