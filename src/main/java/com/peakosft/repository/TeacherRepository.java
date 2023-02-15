package com.peakosft.repository;

import com.peakosft.entity.Student;
import com.peakosft.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("select s from Student s join s.group g join g.course c join c.teachers t where t.id=:id")
    List<Student> sizeOfStudents(@Param("id") Long id);
}
