package com.aio.aionet.reporter.repository;

import com.aio.aionet.reporter.model.VodBilling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VodBillingRepository extends CrudRepository<VodBilling, Long>
        , QuerydslPredicateExecutor<VodBilling> {

}
