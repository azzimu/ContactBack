/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rac.dao;

import org.rac.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author raco
 */
public interface ContactRepository extends JpaRepository <Contact,Long>{
    
   @Query("select c from Contact c where c.id=:x")
    public Contact getContactById(@Param ("x")long id);
    
    @Query("select c from Contact c where c.nom like :x")
    public Page<Contact> chercher(@Param ("x")String mc,Pageable pageable);
    
}
