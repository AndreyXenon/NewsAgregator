package com.example.test.repository;

import com.example.test.Model.ITNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITNewsRepository extends JpaRepository<ITNews, Long> {
}
