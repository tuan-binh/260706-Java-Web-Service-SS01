package com.example.session01.controllers;

import com.example.session01.modals.entities.Student;
import com.example.session01.modals.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping ("/api/v1/app")// Endpoint đường dãn để chúng ta truy cập
// Lát nữa truy cập đường dẫn http://localhost:8080/api/v1/app -> dữ liệu
public class AppController {

    List<String> names = new ArrayList<>(
            Arrays.asList(
                    "Nguyễn Văn A",
                    "Phạm Thị B",
                    "Trần Văn C"
            )
    );

    // định nghĩa các phương thức thực hiện các chức năng
    @RequestMapping // mặc định là phương thức GET
    public String getMessage() {
        return "Đây là API đầu tiên";
    }

    @RequestMapping("/list")// sẽ ghép URI với URI ở mức class
    // --> http://localhost:8080/api/v1/app/list
    public List<String> getNames() {
        return names;
    }

    // Viết một chương trình xây dựng một API trả về danh sách đối tượng Student {
    //      - id
    //      - name
    //      - age
    // }


    @Autowired
    private StudentService studentService;


    @RequestMapping("/students")
    public List<Student> findAllStudent() {
        return studentService.findAll();
    }

    // @RequestBody (nhận đối tượng được gửi lên)

    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {

        System.out.println(student);
        // Xử lý thêm vào danh sách
        return studentService.addStudent(student);
    }


    // Làm sao để lấy giá trị trên đường dẫn
    // @PathVariable

    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        System.out.println(id);
        // Xử lý logic cập nhật thông tin

        // Quy trình:
        /*
            B1: Tìm đối tượng có tồn tại hay không thông qua id
            B2: nếu không thì thông báo lỗi
            B3: nếu có thì gán các giá trị mới ở body gửi lên cho đối tượng cần cập nhật
            B4: Cập nhật vào danh sách sản phẩm
        */
        return studentService.updateStudent(student,id);
    }

    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Delete successfully";
    }


}
