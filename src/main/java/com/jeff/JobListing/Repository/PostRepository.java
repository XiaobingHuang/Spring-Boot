package com.jeff.JobListing.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeff.JobListing.Model.Post;

public interface PostRepository extends MongoRepository<Post,String>{
    
}
