package com.poc.file.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.file.commons.model.File;

@Repository
public interface FileRepository extends CrudRepository<File, Long>{

}
