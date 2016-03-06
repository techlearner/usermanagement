package com.teleportcall.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teleportcall.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findUserByUserId(String userId);

	User findUserByMobileNo(String mobileNo);

}
