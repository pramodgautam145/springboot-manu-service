package com.pramod.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pramod.entity.Manu;
@Repository
public interface ManuDao extends CrudRepository<Manu, Integer> {

}
