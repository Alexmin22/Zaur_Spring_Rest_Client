package org.example;

import org.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/Zaur_Rest/api/employees";
    public List<Employee> getAllEmpls() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Employee>>() {});
        return response.getBody();
    }

    public Employee getEmpl(int id) {

        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmpl(Employee employee) {
        int id = employee.getId();

        if (id == 0) {
            ResponseEntity<String> response = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("Новый сотрудник добавлен в БД");
            System.out.println(response.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Данные работника с id = " + id + " обновлены");
        }
    }

    public void deleteEmpl(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Pаботник с id = " + id + " удален");
    }
}
