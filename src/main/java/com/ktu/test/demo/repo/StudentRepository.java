package com.ktu.test.demo.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktu.test.demo.domain.Student;

@Repository
public class StudentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from student where id=?", new Object[] { id });
	}

	public int insert(Student student) {
		return jdbcTemplate.update("insert into student (id, name, email) " + "values(?,  ?, ?)",
				new Object[] { student.getId(), student.getName(), student.getEmail() });
	}

	public int update(Student student) {
		return jdbcTemplate.update("update student " + " set name = ?, email = ? " + " where id = ?",
				new Object[] { student.getName(), student.getEmail(), student.getId() });
	}
}

class StudentRowMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getLong("ID"));
		student.setName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		return student;
	}
}
