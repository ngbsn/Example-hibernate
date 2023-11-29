package org.mycompany.postgres1.service;

import org.mycompany.postgres1.dao.Postgres1HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHibernateService {

    @Autowired
    Postgres1HibernateDao postgres1HibernateDao;

    public void savePostgres1(){
        postgres1HibernateDao.save();
    }

}
