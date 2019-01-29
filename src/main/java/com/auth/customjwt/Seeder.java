package com.auth.customjwt;

import com.auth.customjwt.model.Role;
import com.auth.customjwt.model.RoleName;
import com.auth.customjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role(RoleName.ROLE_USER);
        roleRepository.save(role);
    }
}
