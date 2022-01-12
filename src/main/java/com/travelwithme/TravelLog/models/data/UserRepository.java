package com.travelwithme.TravelLog.models.data;

import com.travelwithme.TravelLog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
