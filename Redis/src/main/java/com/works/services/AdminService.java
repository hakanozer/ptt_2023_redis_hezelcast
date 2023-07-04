package com.works.services;

import com.works.entities.Admin;
import com.works.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;
    final HttpServletRequest request;

    public boolean login(Admin admin) {
        Optional<Admin> optionalAdmin = adminRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(admin.getEmail(), admin.getPassword());
        boolean status = optionalAdmin.isPresent();
        if ( status ) {
            Admin adm = optionalAdmin.get();
            request.getSession().setAttribute("admin", adm );
        }
        return status;
    }

}
