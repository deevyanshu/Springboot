package com.deevyanshu.add.Repository;

import com.deevyanshu.add.model.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findAllByEmpId(Long empId);
}
