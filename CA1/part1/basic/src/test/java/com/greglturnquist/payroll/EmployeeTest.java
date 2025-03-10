package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeNotNull() {
        Employee employee = new Employee("John", "Doe", "Software Engineer", 5);
        assertNotNull(employee);
    }

    @Test
    void testEmployeeCreation() {
        Employee employee = new Employee("John", "Doe", "Software Engineer", 5);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("Software Engineer", employee.getDescription());
        assertEquals(5, employee.getJobYears());
    }

    @Test
    void testEmployeeNullValues() {
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Doe", "Engineer", 5));
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", null, "Engineer", 5));
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "Doe", null, 5));
    }

    @Test
    void testEmployeeEmptyValues() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Doe", "Engineer", 5));
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "", "Engineer", 5));
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "Doe", "", 5));
    }

    @Test
    void testJobYearsValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("John", "Doe", "Engineer", -1));
    }
}
