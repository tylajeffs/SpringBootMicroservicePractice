package com.example.ec.repo;

import com.example.ec.domain.Tour;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Integer> {
    Page<Tour> findByTourPackageCode(String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S saveAndFlush(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch(Iterable<Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    <S extends Tour> List<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
