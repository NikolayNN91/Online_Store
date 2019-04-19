//package com.ardecs.onlinestore.config;
//
//import com.ardecs.onlinestore.repository.UserJpaRepository;
//import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import java.util.Properties;
//
////
//@EnableJpaRepositories(basePackages = "com.ardecs.onlinestore.repository")
//@Configuration
//public class AppConfig {

//    @Value("${app.datasource.username}")
//    String username;

//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public MysqlConnectionPoolDataSource dataSource() {
//
//        return DataSourceBuilder.create().type(MysqlConnectionPoolDataSource.class).build();
//    }

//    @Bean
//    public DriverManagerDataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/Online_Store?autoReconnect=true&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(getDataSource());
//        entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//        entityManagerFactory.setJpaProperties(jpaProperties);
//        entityManagerFactory.setPackagesToScan("com.ardecs.onlinestore");
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return jpaTransactionManager;
//    }
//}
