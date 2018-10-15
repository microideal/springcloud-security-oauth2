package com.microideal.orderserver.repository.jpa;

import com.microideal.orderserver.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author microideal on 2018/5/24
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
