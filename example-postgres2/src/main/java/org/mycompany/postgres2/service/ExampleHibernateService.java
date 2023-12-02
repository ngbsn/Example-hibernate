package org.mycompany.postgres2.service;

import org.mycompany.postgres2.dao.Postgres2HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHibernateService {

    @Autowired
    Postgres2HibernateDao postgres2HibernateDao;

    public void savePostgres1(){
        postgres2HibernateDao.save();
    }

}
