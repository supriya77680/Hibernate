package com.bnt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(); //to create datasource we have use session factory it is very heavy. We create only one if have more database then we can create couple of sessionfactory
    	
    	Session session = sessionFactory.openSession();
        
    	Song song1 = new Song();
    	song1.setId(2);
    	song1.setSongName("Thank you god");
    	song1.setSinger("Dhvani Bhanushali");
    	
    	session.beginTransaction();
    	
    	session.save(song1);
    	
    	session.getTransaction().commit();
    	System.out.println("song saved");
    	
    	session.close();
    }
}
