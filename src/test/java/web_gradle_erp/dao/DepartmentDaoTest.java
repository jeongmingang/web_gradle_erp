package web_gradle_erp.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_gradle_erp.JdbcUtil;
import web_gradle_erp.dao.impl.DepartmentDaoImpl;
import web_gradle_erp.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private static Connection con;
	private static DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectDepartmentByAll() {
		System.out.printf("%s()%n", "test01SelectDepartmentByAll");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		
		list.parallelStream().forEach(System.out::println);		
	}

	@Test
	public void test04SelectDepartmentByNo() {
		System.out.printf("%s()%n", "test04SelectDepartmentByNo");
		Department department = new Department(4);
		Department searchDept = dao.selectDepartmentByNo(department);
		Assert.assertNotNull(searchDept);
		System.out.println("searchDept : " + searchDept);
	}

	@Test
	public void test02InsertDepartment() {
		System.out.printf("%s()%n", "test02InsertDepartment");
		Department newDept = new Department(5, "마케팅", 20);	
		int res = dao.insertDepartment(newDept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDept));
	}

	@Test
	public void test03UpdateDepartment() {
		System.out.printf("%s()%n", "test03UpdateDepartment");
		Department updateDept = new Department(5, "게임");	
		int res = dao.updateDepartment(updateDept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(updateDept));
	}

	@Test
	public void test05DeleteDepartment() {
		System.out.printf("%s()%n", "test05DeleteDepartment");
		Department delDept = new Department(5);	
		int res = dao.deleteDepartment(delDept);
		Assert.assertEquals(1, res);
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

}
