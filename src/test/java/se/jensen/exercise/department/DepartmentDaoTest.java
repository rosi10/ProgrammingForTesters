package se.jensen.exercise.department;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.jensen.H2JpaConfig;
import se.jensen.LiquibaseConfigurer;
import se.jensen.dao.DepartmentDao;
import se.jensen.dao.DepartmentDatabaseEntry;
import javax.ws.rs.core.Application;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, LiquibaseConfigurer.class, H2JpaConfig.class})
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void testToGetAll() {
        List<DepartmentDatabaseEntry> departmentsList = departmentDao.findAll();
        Assert.assertEquals(3, departmentsList.size());
    }

    @Test
    public void testToSaveNewDepartment() {
        List<DepartmentDatabaseEntry> departmentLit = departmentDao.findAll();
        Assert.assertEquals(3, departmentLit.size());
        departmentDao.save(DepartmentDatabaseEntry.builder()
                .departmentId(99)
                .departmentName("test_department")
                .build());
        departmentLit = departmentDao.findAll();
        Assert.assertEquals(4, departmentLit.size());
    }

    @Test
    public void testToDeleteDepartment() {
        departmentDao.delete(DepartmentDatabaseEntry.builder()
                .departmentId(99)
                .departmentName("test_department")
                .build());
        List<DepartmentDatabaseEntry> departmentList = departmentDao.findAll();
        Assert.assertEquals(3, departmentList.size());
    }

    @Test
    public void testToGetById() {
        Optional<DepartmentDatabaseEntry> departmentDatabaseEntry = departmentDao.findById(1);
        Assert.assertTrue(departmentDatabaseEntry.isPresent());
    }
}