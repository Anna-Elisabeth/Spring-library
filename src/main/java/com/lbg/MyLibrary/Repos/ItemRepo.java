package com.lbg.MyLibrary.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.MyLibrary.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
