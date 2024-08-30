package com.avisacademico.domain.repository.user;

import com.avisacademico.domain.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Long, Role> {

}
