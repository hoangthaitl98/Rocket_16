package com.vtii.repository;

import com.vtii.entity.RegistrationUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {
    public RegistrationUserToken findByToken(String token);

    public boolean existsByToken(String token);

    @Query("	SELECT 	token	"
            + "	FROM 	RegistrationUserToken "
            + " WHERE 	user_id = :accountId")
    String findByUserId(short accountId);

    @Transactional
    @Modifying
    @Query("	DELETE"
            + "	FROM 	RegistrationUserToken 	"
            + " WHERE 	user_id = :userId")
    void deleteByUserId(short userId);
}
