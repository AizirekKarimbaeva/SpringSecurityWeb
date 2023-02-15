package com.peakosft.repository;

import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select gr from Group gr join gr.students s where s.id=:id")
    List<Group> getGroupById(@Param("id") Long id);
}
