package com.peakosft.repository;

import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query("select c from Course c join c.groups gr where gr.id=:id")
    List<Course> getCoursesByGroupId(@Param("id") Long id);
    @Query("select s from Student s join s.group gr where gr.id=:id")
    List<Student> getStudentsByGroupId(@Param("id") Long id);

    @Query("select s from Student s join s.group gr where gr.id =:groupId and s.firstName =:studentName")
    List<Student> search(@Param("groupId") Long groupId, @Param("studentName") String studentName);
}
