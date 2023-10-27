package org.studentDao;

import org.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
    @Autowired
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values (?,?,?)";
        return template.update(query,student.getId(),student.getName(),student.getCity());
    }

    @Override
    public int change(Student student) {
        return 0;
    }

    @Override
    public int delete(int studentId) {
        return 0;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        return this.template.queryForObject(query, rowMapper, studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        return this.template.query(query, rowMapper);
    }
}
