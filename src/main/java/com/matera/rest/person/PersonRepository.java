package com.matera.rest.person;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByTaxId(Long taxId);

    List<Person> findAll(Specification<PersonProjection> spec);
}
