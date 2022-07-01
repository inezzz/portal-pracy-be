package com.ig.portalpracy.repository;

import com.ig.portalpracy.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository <JobOffer, Long> {
}
