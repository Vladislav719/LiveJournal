package com.github.gazizovrim.repository;

import com.github.gazizovrim.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vladislav on 12.05.2015.
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
