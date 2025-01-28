package com.example.demo.service;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public boolean addStudent(Student student) {
        return studentRepo.save(student) != null;
    }
    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    public List<Student> getStudentByDepartment(String department) {
        List<Student> al = studentRepo.findAll();
        List<Student> res = new ArrayList<>();
        for(int i=0; i<al.size(); i++) {
            if(al.get(i).getDepartment().equals(department)) res.add(al.get(i));
        }
        return res;
    }
}
