package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.studentDao.StudentDao;
import org.studentDao.StudentDaoImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started ..... " );
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        String query = "insert into student(id,name,city) values (?,?,?)";
//
//        int result = template.update(query, 41 , "Uttam Kumar", "Kanpur");
//        System.out.println("Inserted into the database...." + result);
//        template.update("alter table STUDENT modify id int AUTO_INCREMENT");
//        System.out.println("Inserted into the database...." + result);

        StudentDao studentDao = context.getBean("studentDao", StudentDaoImpl.class);

        int x = studentDao.insert(new Student(199,"Testing","Dubai"));
//        System.out.println("Record inserted : "+ x);

//        System.out.println(studentDao.getStudent(456));
        List<Student> students = studentDao.getAllStudent();
        for(Student student: students)
            System.out.println(student);
    }
}
