package com.casestudy.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {

}
