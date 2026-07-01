package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Solution {
    public static void main(String[] args) {
        SpringApplication.run(Solution.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeRepository employeeRepository, JpaExample jpaExample, HibernateExample hibernateExample) {
        return args -> {
            Employee employee = new Employee("Neha", "Developer");
            jpaExample.saveWithJpa(new Employee("Amit", "Tester"));
            hibernateExample.saveWithHibernate(new Employee("Priya", "Analyst"));
            employeeRepository.save(employee);
            System.out.println(employeeRepository.findAll());
        };
    }

    @Bean
    JpaExample jpaExample(EntityManager entityManager) {
        return new JpaExample(entityManager);
    }

    @Bean
    HibernateExample hibernateExample(EntityManager entityManager) {
        return new HibernateExample(entityManager);
    }

    static class JpaExample {
        private final EntityManager entityManager;

        JpaExample(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        @Transactional
        void saveWithJpa(Employee employee) {
            entityManager.persist(employee);
        }
    }

    static class HibernateExample {
        private final EntityManager entityManager;

        HibernateExample(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        @Transactional
        void saveWithHibernate(Employee employee) {
            Session session = entityManager.unwrap(Session.class);
            session.persist(employee);
        }
    }
}
