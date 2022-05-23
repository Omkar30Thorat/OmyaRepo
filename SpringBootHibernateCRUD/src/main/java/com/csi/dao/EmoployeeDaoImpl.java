package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class EmoployeeDaoImpl implements  EmployeeDao {


    private  static SessionFactory factory= new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void saveAllData() {
        Session session=factory.openSession();

        Transaction transaction= session.beginTransaction();

        String employee;
        session.save(employee);

        transaction.commit();
    }

    @Override
    public List<Employee> getAllData() {
        Session session=factory.openSession();
        List<Employee> emplist= session.createQuery("from Employee").list();
        return emplist;
    }

    @Override
    public void updataData(int empId , Employee employee) {
        Session session= factory.openSession();

        Transaction transaction=session.beginTransaction();


        Employee employee1= (Employee) session.createQuery(Employee.class,empId);
                if(employee.getEmpId()==empId)
        {
            employee1.setEmpName(employee.setEmpName());
            employee1.setEmpAddress(employee.getEmpAddress());
            employee1.setEmpContactNumber(employee.getEmpContactNumber());

            session.save(employee1);
            transaction.commit();
        }

    }

    @Override
    public void deleteData(int empId) {

        Session session=factory.openSession();

        Transaction transaction=session.beginTransaction();

        Employee employee1 = (Employee) session.createQuery(Employee.class, empId);
        if(employee1.getEmpId()==empId){
                    session.delete(employee1);
                    transaction.commit();
                }

    }
}
