package com.galvanize.employeeemail.repositories;

import com.galvanize.employeeemail.models.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAddressRepository extends JpaRepository<EmailAddress,Long> {
}
