package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.PlanCategoryEntity;

public interface PlanCtRepository extends JpaRepository<PlanCategoryEntity, Integer>{

}
