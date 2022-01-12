package com.travelwithme.TravelLog.models.data;

import com.travelwithme.TravelLog.models.Places;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends CrudRepository<Places, Integer> {
}
