package com.training.wipro.onlineassesments.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.wipro.onlineassesments.entity.Users;
@Repository
public interface UserRepositry  extends JpaRepository<Users, String>{

}
