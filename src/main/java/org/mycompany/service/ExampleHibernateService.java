package org.mycompany.service;

import jakarta.transaction.Transactional;
import org.mycompany.dao.ExampleHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleHibernateService {

    @Autowired
    ExampleHibernateDao exampleHibernateDao;

    public void save(){
        exampleHibernateDao.save();
    }
}
