package com.example.ec.service;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a Tour Package
     *
     * @param code
     * @param name
     * @return new or existing tour package
     */
    public TourPackage createTourPackage(String code, String name) {

        return tourPackageRepository.findById(code)
                        .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     * Lookup all tour packages
     *
     * @return all tour packages
     */
    public Iterable<TourPackage> lookup() { return tourPackageRepository.findAll(); }

    public long total() { return tourPackageRepository.count(); }
}
