package com.jeff.JobListing.Repository;

import java.util.List;

import com.jeff.JobListing.Model.Post;

public interface SearchPostRepository {
    List<Post> findByText(String text);
}


