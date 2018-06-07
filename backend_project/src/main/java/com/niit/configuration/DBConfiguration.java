package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
	public DBConfiguration(){
		System.out.println("DBCOnfiguration class instantiated");
	}
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		/*hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		*/
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		lsf.scanPackages("com.niit.model");
	    return lsf.buildSessionFactory();
	}
	@Bean(name="dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    /*dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("system");
	    dataSource.setPassword("password");*/
	    
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/varshaBlog");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	    
	}
	@Bean(name="transactionManager")
	public HibernateTransactionManager hibTransManagement(){

		System.out.println("Transaction Manager Object Creating");
		//HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory());
		System.out.println("Transaction Manager Object Created");
		return new HibernateTransactionManager(sessionFactory());
	}
	
@Bean(name="userDao")
public UserDao getuserbean() {
return new UserDaoImpl();	
}
}


