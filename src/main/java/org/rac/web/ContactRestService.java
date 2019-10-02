/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rac.web;

import java.util.List;
import org.rac.dao.ContactRepository;
import org.rac.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raco
 */
 @CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactRestService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    @RequestMapping(value="/contacts",method=RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    
    @RequestMapping(value="contacts/{id}",method=RequestMethod.GET)
    public Contact getContact(@PathVariable Long id){
        
        return contactRepository.getContactById(id);
        
    }
    
    @RequestMapping(value="contacts",method=RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact c){
        
        return contactRepository.save(c);
        
    }
    
    
    @RequestMapping(value="contacts/{id}",method=RequestMethod.PUT)
    public Contact udapteContact(@RequestBody Contact c,@PathVariable Long id){
        
        c.setId(id);
        return contactRepository.save(c);
        
    }
    
    
    @RequestMapping(value="contacts/{id}",method=RequestMethod.DELETE)
    public boolean deleteContact(@PathVariable Long id){
        
        contactRepository.deleteById(id);
        
        return true;
        
    }
    
    
    @RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
    public Page<Contact> chercher(
            @RequestParam (name="mc",defaultValue="")String mc,
            @RequestParam (name="page",defaultValue="0")int page,
            @RequestParam (name="size" ,defaultValue="4")int size){
        
        
        return contactRepository.chercher("%"+mc+"%", new PageRequest(page,size));
      
    }
    
}
