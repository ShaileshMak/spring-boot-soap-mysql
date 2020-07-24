# spring-boot-soap-mysql
Spring Boot Soap API - Student API created for CRUD Opperation on mySQL DB

- Test SOAP Web Service using Soap UI
```
http://localhost:8081/ws/students.wsdl 
```
- WSDL
```<?xml version="1.0" encoding="UTF-8"?>
   <wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:sch="http://www.shailesh.com/mak/soap/api/generated" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://www.shailesh.com/mak/soap/api/generated" targetNamespace="http://www.shailesh.com/mak/soap/api/generated">
      <wsdl:types>
         <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="http://www.shailesh.com/mak/soap/api/generated">
            <xs:element name="getStudentByIdRequest">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentId" type="xs:long" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="getStudentByIdResponse">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:complexType name="studentInfo">
               <xs:sequence>
                  <xs:element name="studentId" type="xs:long" />
                  <xs:element name="name" type="xs:string" />
                  <xs:element name="grade" type="xs:string" />
                  <xs:element name="classTeacher" type="xs:string" />
                  <xs:element name="schoolName" type="xs:string" />
                  <xs:element name="schoolDistrict" type="xs:string" />
               </xs:sequence>
            </xs:complexType>
            <xs:element name="getAllStudentsRequest">
               <xs:complexType />
            </xs:element>
            <xs:element name="getAllStudentsResponse">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element maxOccurs="unbounded" name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="addStudentRequest">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="name" type="xs:string" />
                     <xs:element name="grade" type="xs:string" />
                     <xs:element name="classTeacher" type="xs:string" />
                     <xs:element name="schoolName" type="xs:string" />
                     <xs:element name="schoolDistrict" type="xs:string" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="addStudentResponse">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="updateStudentRequest">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="updateStudentResponse">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="deleteStudentRequest">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentId" type="xs:long" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
            <xs:element name="deleteStudentResponse">
               <xs:complexType>
                  <xs:sequence>
                     <xs:element name="studentInfo" type="tns:studentInfo" />
                  </xs:sequence>
               </xs:complexType>
            </xs:element>
         </xs:schema>
      </wsdl:types>
      <wsdl:message name="getAllStudentsResponse">
         <wsdl:part element="tns:getAllStudentsResponse" name="getAllStudentsResponse" />
      </wsdl:message>
      <wsdl:message name="updateStudentRequest">
         <wsdl:part element="tns:updateStudentRequest" name="updateStudentRequest" />
      </wsdl:message>
      <wsdl:message name="getStudentByIdRequest">
         <wsdl:part element="tns:getStudentByIdRequest" name="getStudentByIdRequest" />
      </wsdl:message>
      <wsdl:message name="getStudentByIdResponse">
         <wsdl:part element="tns:getStudentByIdResponse" name="getStudentByIdResponse" />
      </wsdl:message>
      <wsdl:message name="addStudentRequest">
         <wsdl:part element="tns:addStudentRequest" name="addStudentRequest" />
      </wsdl:message>
      <wsdl:message name="addStudentResponse">
         <wsdl:part element="tns:addStudentResponse" name="addStudentResponse" />
      </wsdl:message>
      <wsdl:message name="getAllStudentsRequest">
         <wsdl:part element="tns:getAllStudentsRequest" name="getAllStudentsRequest" />
      </wsdl:message>
      <wsdl:message name="updateStudentResponse">
         <wsdl:part element="tns:updateStudentResponse" name="updateStudentResponse" />
      </wsdl:message>
      <wsdl:message name="deleteStudentResponse">
         <wsdl:part element="tns:deleteStudentResponse" name="deleteStudentResponse" />
      </wsdl:message>
      <wsdl:message name="deleteStudentRequest">
         <wsdl:part element="tns:deleteStudentRequest" name="deleteStudentRequest" />
      </wsdl:message>
      <wsdl:portType name="StrudentsPort">
         <wsdl:operation name="getAllStudents">
            <wsdl:input message="tns:getAllStudentsRequest" name="getAllStudentsRequest" />
            <wsdl:output message="tns:getAllStudentsResponse" name="getAllStudentsResponse" />
         </wsdl:operation>
         <wsdl:operation name="updateStudent">
            <wsdl:input message="tns:updateStudentRequest" name="updateStudentRequest" />
            <wsdl:output message="tns:updateStudentResponse" name="updateStudentResponse" />
         </wsdl:operation>
         <wsdl:operation name="getStudentById">
            <wsdl:input message="tns:getStudentByIdRequest" name="getStudentByIdRequest" />
            <wsdl:output message="tns:getStudentByIdResponse" name="getStudentByIdResponse" />
         </wsdl:operation>
         <wsdl:operation name="addStudent">
            <wsdl:input message="tns:addStudentRequest" name="addStudentRequest" />
            <wsdl:output message="tns:addStudentResponse" name="addStudentResponse" />
         </wsdl:operation>
         <wsdl:operation name="deleteStudent">
            <wsdl:input message="tns:deleteStudentRequest" name="deleteStudentRequest" />
            <wsdl:output message="tns:deleteStudentResponse" name="deleteStudentResponse" />
         </wsdl:operation>
      </wsdl:portType>
      <wsdl:binding name="StrudentsPortSoap11" type="tns:StrudentsPort">
         <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http" />
         <wsdl:operation name="getAllStudents">
            <soap:operation soapAction="" />
            <wsdl:input name="getAllStudentsRequest">
               <soap:body use="literal" />
            </wsdl:input>
            <wsdl:output name="getAllStudentsResponse">
               <soap:body use="literal" />
            </wsdl:output>
         </wsdl:operation>
         <wsdl:operation name="updateStudent">
            <soap:operation soapAction="" />
            <wsdl:input name="updateStudentRequest">
               <soap:body use="literal" />
            </wsdl:input>
            <wsdl:output name="updateStudentResponse">
               <soap:body use="literal" />
            </wsdl:output>
         </wsdl:operation>
         <wsdl:operation name="getStudentById">
            <soap:operation soapAction="" />
            <wsdl:input name="getStudentByIdRequest">
               <soap:body use="literal" />
            </wsdl:input>
            <wsdl:output name="getStudentByIdResponse">
               <soap:body use="literal" />
            </wsdl:output>
         </wsdl:operation>
         <wsdl:operation name="addStudent">
            <soap:operation soapAction="" />
            <wsdl:input name="addStudentRequest">
               <soap:body use="literal" />
            </wsdl:input>
            <wsdl:output name="addStudentResponse">
               <soap:body use="literal" />
            </wsdl:output>
         </wsdl:operation>
         <wsdl:operation name="deleteStudent">
            <soap:operation soapAction="" />
            <wsdl:input name="deleteStudentRequest">
               <soap:body use="literal" />
            </wsdl:input>
            <wsdl:output name="deleteStudentResponse">
               <soap:body use="literal" />
            </wsdl:output>
         </wsdl:operation>
      </wsdl:binding>
      <wsdl:service name="StrudentsPortService">
         <wsdl:port binding="tns:StrudentsPortSoap11" name="StrudentsPortSoap11">
            <soap:address location="/ws" />
         </wsdl:port>
      </wsdl:service>
   </wsdl:definitions>
```
- SOAP request and response for CRUD operations.
  - CREATE addStudent
    - Request
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://www.shailesh.com/mak/soap/api/generated">
   <soapenv:Header/>
   <soapenv:Body>
      <stud:addStudentRequest>
         <stud:name>Michael John</stud:name>
         <stud:grade>2</stud:grade>
         <stud:classTeacher>Miss Eich</stud:classTeacher>
         <stud:schoolName>Menlo Park School</stud:schoolName>
         <stud:schoolDistrict>ESD</stud:schoolDistrict>
      </stud:addStudentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
    - Response
```$xslt
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:addStudentResponse xmlns:ns2="http://www.shailesh.com/mak/soap/api/generated">
         <ns2:studentInfo>
            <ns2:studentId>4</ns2:studentId>
            <ns2:name>Michael John</ns2:name>
            <ns2:grade>2</ns2:grade>
            <ns2:classTeacher>Miss Eich</ns2:classTeacher>
            <ns2:schoolName>Menlo Park School</ns2:schoolName>
            <ns2:schoolDistrict>ESD</ns2:schoolDistrict>
         </ns2:studentInfo>
      </ns2:addStudentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
  - READ getStudentById
    - Request
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://www.shailesh.com/mak/soap/api/generated">
   <soapenv:Header/>
   <soapenv:Body>
      <stud:getStudentByIdRequest>
         <stud:studentId>2</stud:studentId>
      </stud:getStudentByIdRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
    - Response
```$xslt
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getStudentByIdResponse xmlns:ns2="http://www.shailesh.com/mak/soap/api/generated">
         <ns2:studentInfo>
            <ns2:studentId>2</ns2:studentId>
            <ns2:name>John Doe</ns2:name>
            <ns2:grade>9</ns2:grade>
            <ns2:classTeacher>Mr. Nasir Hussain</ns2:classTeacher>
            <ns2:schoolName>Woodrow Wilson Middle School</ns2:schoolName>
            <ns2:schoolDistrict>ESD</ns2:schoolDistrict>
         </ns2:studentInfo>
      </ns2:getStudentByIdResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
  - READ getAllStudents
    - Request
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://www.shailesh.com/mak/soap/api/generated">
   <soapenv:Header/>
   <soapenv:Body>
      <stud:getAllStudentsRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```
    - Response
```$xslt
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getAllStudentsResponse xmlns:ns2="http://www.shailesh.com/mak/soap/api/generated">
         <ns2:studentInfo>
            <ns2:studentId>1</ns2:studentId>
            <ns2:name>Joh Doe</ns2:name>
            <ns2:grade>9</ns2:grade>
            <ns2:classTeacher>Mr. Nasir Hussain</ns2:classTeacher>
            <ns2:schoolName>Liberty High School</ns2:schoolName>
            <ns2:schoolDistrict>FSD</ns2:schoolDistrict>
         </ns2:studentInfo>
         <ns2:studentInfo>
            <ns2:studentId>2</ns2:studentId>
            <ns2:name>Lilly Yup</ns2:name>
            <ns2:grade>9</ns2:grade>
            <ns2:classTeacher>Mr. Nasir Hussain</ns2:classTeacher>
            <ns2:schoolName>Woodrow Wilson Middle School</ns2:schoolName>
            <ns2:schoolDistrict>ESD</ns2:schoolDistrict>
         </ns2:studentInfo>
         <ns2:studentInfo>
            <ns2:studentId>4</ns2:studentId>
            <ns2:name>Michael John</ns2:name>
            <ns2:grade>2</ns2:grade>
            <ns2:classTeacher>Miss Eich</ns2:classTeacher>
            <ns2:schoolName>Menlo Park School</ns2:schoolName>
            <ns2:schoolDistrict>ESD</ns2:schoolDistrict>
         </ns2:studentInfo>
      </ns2:getAllStudentsResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
  - UPDATE updateStudent
    - Request
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://www.shailesh.com/mak/soap/api/generated">
   <soapenv:Header/>
   <soapenv:Body>
      <stud:updateStudentRequest>
         <stud:studentInfo>
            <stud:studentId>4</stud:studentId>
            <stud:schoolName>Taylor Elementery School</stud:schoolName>
            <stud:schoolDistrict>FSD</stud:schoolDistrict>
         </stud:studentInfo>
      </stud:updateStudentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
    - Response
```$xslt
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:updateStudentResponse xmlns:ns2="http://www.shailesh.com/mak/soap/api/generated">
         <ns2:studentInfo>
            <ns2:studentId>4</ns2:studentId>
            <ns2:name>Michael John</ns2:name>
            <ns2:grade>2</ns2:grade>
            <ns2:classTeacher>Miss Eich</ns2:classTeacher>
            <ns2:schoolName>Taylor Elementery School</ns2:schoolName>
            <ns2:schoolDistrict>FSD</ns2:schoolDistrict>
         </ns2:studentInfo>
      </ns2:updateStudentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
  - DELETE deleteStudent
    - Request
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stud="http://www.shailesh.com/mak/soap/api/generated">
   <soapenv:Header/>
   <soapenv:Body>
      <stud:deleteStudentRequest>
         <stud:studentId>3</stud:studentId>
      </stud:deleteStudentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
    - Response
```$xslt
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:deleteStudentResponse xmlns:ns2="http://www.shailesh.com/mak/soap/api/generated">
         <ns2:studentInfo>
            <ns2:studentId>3</ns2:studentId>
            <ns2:name>Sonu Sudh</ns2:name>
            <ns2:grade>3</ns2:grade>
            <ns2:classTeacher>Miss Eich</ns2:classTeacher>
            <ns2:schoolName>Taylor Elimentory School</ns2:schoolName>
            <ns2:schoolDistrict>FSD</ns2:schoolDistrict>
         </ns2:studentInfo>
      </ns2:deleteStudentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```