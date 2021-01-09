package se.jensen.exercise.department;

import org.junit.Assert;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import se.jensen.entity.Department;

import se.jensen.exercise.test.builder.DepartmentTestBuilder;


import static org.junit.Assert.fail;
import static com.jayway.jsonpath.internal.path.PathCompiler.fail;

public class TestThatDepartmentIsCreated {
    @Test
    public void test() {
        Integer departmentId = 1;
        String departmentName = "Accounts";

        Department department = Department.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .build();
        Assert.assertEquals(departmentId, department.getDepartmentId());
        Assert.assertEquals(departmentName, department.getDepartmentName());
    }

    @Test(expected = NullPointerException.class)
    public void testThatNullValueAllowedForDepartmentID() {
        Department.builder()
                .departmentId(null)
                .departmentName("Sales")
                .build();

    }

    @Test
    public void testThatToStringReturnsProperly() {
        String expectedToString = DepartmentTestBuilder.build().toString();
        Department department = DepartmentTestBuilder.build();
        Assert.assertEquals(expectedToString, department.toString());
    }

}



