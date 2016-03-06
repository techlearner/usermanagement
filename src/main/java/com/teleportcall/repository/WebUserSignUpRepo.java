package com.teleportcall.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teleportcall.model.WebUserSignup;

@Repository
public interface WebUserSignUpRepo extends PagingAndSortingRepository<WebUserSignup, Long>{

}
