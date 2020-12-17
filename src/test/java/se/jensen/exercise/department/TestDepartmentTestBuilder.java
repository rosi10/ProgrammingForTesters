package se.jensen.exercise.department;

import org.junit.Assert;
import org.junit.Test;
import se.jensen.entity.Department;
import se.jensen.exercise.test.builder.DepartmentTestBuilder;

public class TestDepartmentTestBuilder {
    @Test
    public void testDepartmentTestBuilder(){
        DepartmentTestBuilder departmentTestBuilder = new DepartmentTestBuilder();
        Department testDepartment = departmentTestBuilder.build();
                Assert.assertNotNull(testDepartment);
        Assert.assertEquals(Integer.valueOf(1),testDepartment.getDepartmentId());
        Assert.assertEquals("Development",testDepartment.getDepartmentName());




    }
}
