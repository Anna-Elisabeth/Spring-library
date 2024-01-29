package com.lbg.MyLibrary.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.MyLibrary.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
