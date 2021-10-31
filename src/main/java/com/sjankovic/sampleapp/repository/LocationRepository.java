package com.sjankovic.sampleapp.repository;

import com.sjankovic.sampleapp.entities.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {
}
