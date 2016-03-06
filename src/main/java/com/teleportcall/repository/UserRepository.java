package com.teleportcall.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.teleportcall.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	User findUserByUserId(String userId);

	User findUserByMobileNo(String mobileNo);

}
