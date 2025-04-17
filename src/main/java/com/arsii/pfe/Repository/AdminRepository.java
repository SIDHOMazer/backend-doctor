package com.arsii.pfe.Repository;

import com.arsii.pfe.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin , Long> {

}
