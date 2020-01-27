package com.aio.aionet.reporter.repository;

import com.aio.aionet.reporter.model.VodContent;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VodContentRepository extends JpaRepository<VodContent,Long> {

}
