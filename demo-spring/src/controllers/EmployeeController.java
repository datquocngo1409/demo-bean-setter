package controllers;

import model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EmployeeController {

    @GetMapping("/home")
    public String getEmployee(Model model){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[] {"~/../../applicationContext.xml"});
        Employee employee = context.getBean("employee", Employee.class);
        model.addAttribute("address", employee.getHomeAddress());
        return "viewEmployee";
    }
}
