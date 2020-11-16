package se.jensen.exercise;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.jensen.entity.Employee;
import se.jensen.entity.EmployeeTestBuilder;

import java.math.BigDecimal;

public class EmployeeTest {
    @Test
    public void testThatEmployeeIsCreatedCorrectly() {
        Integer employeeId = 1;
        String firstname = "firstName";
        String lastName ="lastName";
        BigDecimal salary = BigDecimal.valueOf(10000.0);
        Boolean fullTime = Boolean.FALSE;

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstname)
                .lastName(lastName)
                .fullTime(fullTime)
                .salary(salary)
                .build();

        Assert.assertEquals(employeeId,employee.getEmployeeId());
        Assert.assertEquals(firstname,employee.getFirstName());
        Assert.assertEquals(lastName,employee.getLastName());
        Assert.assertEquals(salary,employee.getSalary());
        Assert.assertEquals(fullTime,employee.getFullTime());
    }

    @Test(expected = NullPointerException.class)
    public void testThatNullValueNotAllowedForEmployeeID() {
        Employee.builder()
                .employeeId(4)
                .firstName("")
                .lastName("")
                .salary(null)
                .fullTime(Boolean.TRUE)
                .build();
    }

    @Test
    public void testThatToStringReturnsProper(){
        String expectedToString = EmployeeTestBuilder.build().toString();
        Employee employee = EmployeeTestBuilder.build();
        Assert.assertEquals(expectedToString,employee.toString());
    }
}
