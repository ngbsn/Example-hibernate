package org.mycompany.service;

import org.mycompany.dao.mysql.MySQLHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHibernateService {

    @Autowired
    MySQLHibernateDao mySQLHibernateDao;

    public void saveMySQL(){
        mySQLHibernateDao.save();
    }
}
