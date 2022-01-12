package com.travelwithme.TravelLog.models.data;

import com.travelwithme.TravelLog.models.WishList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends CrudRepository<WishList, Integer> {
}
