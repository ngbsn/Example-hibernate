package org.mycompany.service;

import org.mycompany.dao.mysql.MySQLHibernateDao;
import org.mycompany.dao.postgres1.Postgres1HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHibernateService {

    @Autowired
    MySQLHibernateDao mySQLHibernateDao;
    @Autowired
    Postgres1HibernateDao postgres1HibernateDao;

    public void saveMySQL(){
        mySQLHibernateDao.save();
    }
    public void savePostgres1(){
        postgres1HibernateDao.save();
    }

}
