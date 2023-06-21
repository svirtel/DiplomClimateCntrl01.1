package com.mycompany.detector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class DetectorService {

    @Autowired
    private DetectorRepository repo;

    public List<Detector> listAll() {
        return (List<Detector>) repo.findAll();
    }

    public void save(Detector detector) {
        repo.save(detector);
    }

    public Detector get(Integer id) throws DetectorNotFoundException {
        Optional<Detector> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new DetectorNotFoundException("Не удалось найти ни одного прибора с ID " + id);
    }

    public void delete(Integer id) throws DetectorNotFoundException {
        Long count = repo.countById(id);
        if (count == 0 || count == null) {
            throw new DetectorNotFoundException("Не удалось найти ни одного прибора с ID " + id);
        }
        repo.deleteById(id);
    }

}
