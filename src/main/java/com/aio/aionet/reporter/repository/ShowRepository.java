package com.aio.aionet.reporter.repository;

import com.aio.aionet.reporter.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
//    @Override
//    List<Show> findAllById(Iterable<Long> longs);
}
