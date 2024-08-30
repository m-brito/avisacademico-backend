package com.avisacademico.domain.repository.user;

import com.avisacademico.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Long, User> {
    UserDetails findById(Long id);
}
