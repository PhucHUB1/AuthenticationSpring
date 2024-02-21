package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByNameContainingOrHours(String name,int hours);
    @Query("SELECT s from Subject s " +
           "WHERE (:name IS NULL OR s.name LIKE %:name%) "+
            "AND (:hours IS NULL OR s.hours = :hours)")
    List<Subject> findByFilters(@Param("name") String name,@Param("hours") Integer hours);
}
