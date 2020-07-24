package com.shailesh.mak.soap.api.endpoints;

import com.shailesh.mak.soap.api.generated.*;
import com.shailesh.mak.soap.api.model.Student;
import com.shailesh.mak.soap.api.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class StudentsEndPoint {
    public static final String NAMESPACE_URI = "http://www.shailesh.com/mak/soap/api/generated";

    @Autowired
    StudentService studentService;

    private static StudentInfo apply(Student student) {
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(student, studentInfo);
        return studentInfo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentByIdRequest")
    @ResponsePayload
    public GetStudentByIdResponse getStudentById(@RequestPayload GetStudentByIdRequest request) {
        GetStudentByIdResponse response = new GetStudentByIdResponse();
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentService.getStudentById(request.getStudentId()), studentInfo);
        response.setStudentInfo(studentInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        AddStudentResponse response = new AddStudentResponse();
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentService.addStudent(request), studentInfo);
        response.setStudentInfo(studentInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getStudents(@RequestPayload GetAllStudentsRequest request) {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        List<Student> studentList = studentService.getAllStudents();
        List<StudentInfo> studentInfoList = studentList.stream().map(StudentsEndPoint::apply).collect(Collectors.toList());
        response.getStudentInfo().addAll(studentInfoList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest request) {
        UpdateStudentResponse response = new UpdateStudentResponse();
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentService.updateStudentInfo(request), studentInfo);
        response.setStudentInfo(studentInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudentById(@RequestPayload DeleteStudentRequest request) {
        DeleteStudentResponse response = new DeleteStudentResponse();
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentService.getStudentById(request.getStudentId()), studentInfo);
        studentService.deleteStudentInfo(request);
        response.setStudentInfo(studentInfo);
        return response;
    }
}
