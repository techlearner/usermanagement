package com.teleportcall.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teleportcall.model.UserContact;

@Repository
public interface UserContactRepository extends PagingAndSortingRepository<UserContact, Long> {

}
