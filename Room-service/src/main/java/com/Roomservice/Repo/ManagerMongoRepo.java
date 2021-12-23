package com.Roomservice.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Roomservice.Models.Room;


@Repository
public interface ManagerMongoRepo extends MongoRepository<Room, Integer> {
	@Query("{isAvailable:true}")
	List<Room> findAvailable();
}
