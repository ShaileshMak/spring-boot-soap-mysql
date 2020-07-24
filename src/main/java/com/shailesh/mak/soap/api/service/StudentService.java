package com.shailesh.mak.soap.api.service;

import com.shailesh.mak.soap.api.generated.AddStudentRequest;
import com.shailesh.mak.soap.api.generated.DeleteStudentRequest;
import com.shailesh.mak.soap.api.generated.UpdateStudentRequest;
import com.shailesh.mak.soap.api.model.Student;
import com.shailesh.mak.soap.api.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(long studentId) {
        Student _student = studentRepository.findById(studentId).orElse(null);
        return _student;
    }

    public Student addStudent(AddStudentRequest request) {
        Student student = new Student(request.getName(), request.getGrade(), request.getClassTeacher(), request.getSchoolName(), request.getSchoolDistrict());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student updateStudentInfo(UpdateStudentRequest request) {
        Student student = new Student();
        BeanUtils.copyProperties(request.getStudentInfo(), student);
        Student _student = studentRepository.findById(student.getStudentId()).orElse(null);
        if (_student != null) {
            if (student.getName() != null) _student.setName(student.getName());
            if (student.getGrade() != null) _student.setGrade(student.getGrade());
            if (student.getClassTeacher() != null) _student.setClassTeacher(student.getName());
            if (student.getSchoolName() != null) _student.setSchoolName(student.getSchoolName());
            if (student.getSchoolDistrict() != null) _student.setSchoolDistrict(student.getSchoolDistrict());
        }

        studentRepository.save(_student);
        return _student;
    }

    public void deleteStudentInfo(DeleteStudentRequest request) {
        studentRepository.deleteById(request.getStudentId());
    }
}
