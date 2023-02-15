package com.peakosft.repository;

import com.peakosft.entity.Course;
import com.peakosft.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("select t from Teacher t join t.course c where c.id=:id")
    List<Teacher> getTeachersByCourseId(@Param("id") Long id);


}
