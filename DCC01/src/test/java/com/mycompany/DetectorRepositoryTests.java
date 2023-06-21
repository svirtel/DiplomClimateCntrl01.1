package com.mycompany;

import com.mycompany.detector.Detector;
import com.mycompany.detector.DetectorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DetectorRepositoryTests {
    @Autowired
    private DetectorRepository repo;

    @Test
    public void testAddNew() {
        Detector detector = new Detector();
        detector.setDetCharset("EX_ES0003");
        detector.setDetType("Спринклер");
        detector.setDetName("Viking");
        detector.setDetSerial("S0000010");
        detector.setRoomIndex("6");
        detector.setRoomName("Офисное помещение");

        Detector savedDetector = repo.save(detector);

        Assertions.assertThat(savedDetector).isNotNull();
        Assertions.assertThat(savedDetector.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Detector> detectors = repo.findAll();
        Assertions.assertThat(detectors).hasSizeGreaterThan(0);

        for (Detector detector : detectors) {
            System.out.println(detector);
        }
    }

    @Test
    public void testUpdate() {
        Integer detectorId = 2;
        Optional<Detector> optionalDetector = repo.findById(detectorId);
        Detector detector = optionalDetector.get();
        detector.setDetType("Детектор Дымовой");
        repo.save(detector);

        Detector updatedDetector = repo.findById(detectorId).get();
        Assertions.assertThat(updatedDetector.getDetType()).isEqualTo("Детектор Дымовой");
    }

    @Test
    public void testGet() {
        Integer detectorId = 2;
        Optional<Detector> optionalDetector = repo.findById(detectorId);
        Assertions.assertThat(optionalDetector).isPresent();
        System.out.println(optionalDetector.get());
    }

    @Test
    public void testDelete() {
        Integer detectorId = 2;
        repo.deleteById(detectorId);

        Optional<Detector> optionalDetector = repo.findById(detectorId);
        Assertions.assertThat(optionalDetector).isNotPresent();
    }
}
