package com.aio.aionet.reporter.repository;

import com.aio.aionet.reporter.model.VodBilling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VodBillingRepository extends JpaRepository<VodBilling, Long> {

}
