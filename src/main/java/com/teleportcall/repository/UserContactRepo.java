package com.teleportcall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teleportcall.model.UserContact;

@Repository
public interface UserContactRepo extends PagingAndSortingRepository<UserContact, Long>{

	@Query("select u from UserContact u where u.owner.userId =:userId")
	List<UserContact> findUserContactByOwnerId(@Param("userId")String userId);

}
