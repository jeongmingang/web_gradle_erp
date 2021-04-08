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
import web_gradle_erp.dao.impl.TitleDaoImpl;
import web_gradle_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private static Connection con;
	private static TitleDaoImpl dao = TitleDaoImpl.getInstance();

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
	public void test01SelectTitleByAll() {
		System.out.printf("%s()%n", "test01selectTitleByAll");
		
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test04SelectTitleByNo() {
		System.out.printf("%s()%n", "test04SelectTitleByNo");
		Title title = new Title(5);
		Title searchTitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searchTitle);
//		System.out.println(searchTitle);
		System.out.println("searchTitle : " + searchTitle);
	}

	@Test
	public void test02InsertTitle() {
		System.out.printf("%s()%n", "test02InsertTitle");
		Title newTitle = new Title(6, "인턴");	
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(newTitle));
	}

	@Test
	public void test03UpdateTitle() {
		System.out.printf("%s()%n", "test03UpdateTitle");
		Title updateTitle = new Title(6, "계약직");	
		int res = dao.updateTitle(updateTitle);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectTitleByNo(updateTitle));
	}

	@Test
	public void test05DeleteTitle() {
		System.out.printf("%s()%n", "test05DeleteTitle");
		Title delTitle = new Title(6);
		int res = dao.deleteTitle(delTitle);
		Assert.assertEquals(1, res);
		dao.selectTitleByAll().stream().forEach(System.out::println);
	}

}
