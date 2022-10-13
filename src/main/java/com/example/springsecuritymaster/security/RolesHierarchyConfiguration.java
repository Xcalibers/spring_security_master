package com.example.springsecuritymaster.security;

import com.example.springsecuritymaster.security.utils.RoleHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.example.springsecuritymaster.security.SecurityRoles.*;

@Configuration
public class RolesHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(new RoleHierarchyBuilder()
                .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
                .append(CUSTOMERS_ADMIN, CUSTOMERS_READ)
                .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)
                .append(CUSTOMERS_ADMIN, CUSTOMERS_PAGE_VIEW)
                .build());


        return roleHierarchy;
    }

}
