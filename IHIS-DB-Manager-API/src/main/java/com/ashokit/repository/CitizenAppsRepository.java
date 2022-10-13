package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CitizenAppsEntity;

public interface CitizenAppsRepository extends JpaRepository<CitizenAppsEntity, Serializable> {

}
