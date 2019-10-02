package org.rac;

import java.text.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.rac.*;
import org.rac.dao.ContactRepository;
import org.rac.entities.Contact;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner{
    
    @Autowired
    private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
    
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        /*contactRepository.save(new Contact ("loic","girad",df.parse("12/10/1998"),"hashhh@yahoo.fr",1225522,"jdfr.jpg"));
        contactRepository.save(new Contact ("aretta","franklin",df.parse("12/05/1945"),"areta@yahoo.fr",56855555,"jaereer.jpg"));
        contactRepository.save(new Contact ("lili","lala",df.parse("12/10/2015"),"dddllddll@yahoo.fr",1225522,"lldldldld.jpg"));
        contactRepository.findAll().forEach(c->{
            System.out.println(c.getNom());});*/
        }

    }


