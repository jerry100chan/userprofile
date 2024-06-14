package org.it.user.service;

import org.it.user.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.Future;

public interface PostService {

    Future<ResponseEntity<List<Post>>> getPostListFuture();

    List<Post> getPostListEntity(Future<ResponseEntity<List<Post>>> postListFuture);
}
