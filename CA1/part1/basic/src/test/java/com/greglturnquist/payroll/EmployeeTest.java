package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeNotNull() {
        // Arrange & Act
        Employee employee = new Employee("Frodo", "Baggins", "Ring Bearer", 7, "frodo@isep.ipp.pt");

        // Assert
        assertNotNull(employee, "Employee should not be null");
    }

    @Test
    void testEmployeeCreation() {
        // Arrange & Act
        Employee employee = new Employee("Frodo", "Baggins", "Ring Bearer", 7, "frodo@isep.ipp.pt");

        // Assert
        assertEquals("Frodo", employee.getFirstName());
        assertEquals("Baggins", employee.getLastName());
        assertEquals("Ring Bearer", employee.getDescription());
        assertEquals(7, employee.getJobYears());
        assertEquals("frodo@isep.ipp.pt", employee.getEmail());
    }

    @Test
    void testEmployeeNullValues() {
        // Arrange
        String firstName = "Frodo";
        String lastName = "Baggins";
        String description = "Ring Bearer";
        int jobYears = 7;
        String email = "frodo@isep.ipp.pt";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, lastName, description, jobYears, email), "First name cannot be null");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, null, description, jobYears, email), "Last name cannot be null");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, null, jobYears, email), "Description cannot be null");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, description, jobYears, null), "Email cannot be null");
    }

    @Test
    void testEmployeeEmptyValues() {
        // Arrange
        String firstName = "Frodo";
        String lastName = "Baggins";
        String description = "Ring Bearer";
        int jobYears = 7;
        String email = "frodo@isep.ipp.pt";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("", lastName, description, jobYears, email), "First name cannot be empty");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, "", description, jobYears, email), "Last name cannot be empty");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, "", jobYears, email), "Description cannot be empty");
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, description, jobYears, ""), "Email cannot be empty");
    }

    @Test
    void testJobYearsValidation() {
        // Arrange
        String firstName = "Frodo";
        String lastName = "Baggins";
        String description = "Ring Bearer";
        String email = "frodo@isep.ipp.pt";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Employee(firstName, lastName, description, -1, email), "Job years must be non-negative");
    }
}
