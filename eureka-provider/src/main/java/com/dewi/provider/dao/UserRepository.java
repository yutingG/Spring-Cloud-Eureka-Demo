package com.dewi.provider.dao;

import com.dewi.provider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/26 8:28 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
