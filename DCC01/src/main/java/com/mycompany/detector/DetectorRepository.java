package com.mycompany.detector;

import org.springframework.data.repository.CrudRepository;

public interface DetectorRepository extends CrudRepository<Detector, Integer> {
    public Long countById(Integer id);

}