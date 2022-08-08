package com.exercrudjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercrudjpa.entidades.Cachorro;

@Repository
public interface CachorroRepository extends CrudRepository<Cachorro, Integer> {

}
