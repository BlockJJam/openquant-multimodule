package com.tys.repository.users;


import com.tys.domain.users.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @EntityGraph(attributePaths = "authoritySet") // fetch: lazy => eager
    Optional<Users> findOneWithAuthoritySetById(String id);

    @EntityGraph(attributePaths = "authoritySet") // fetch: lazy => eager
    Optional<Users> findOneWithAuthoritySetByIdAndDelNy(String id,Boolean delNy);

    Optional<Users> findOneById(String userId);
}

