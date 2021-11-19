package com.readinglists.com.repository;

import com.readinglists.com.Entity.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<ReadingList, Integer> {
}
