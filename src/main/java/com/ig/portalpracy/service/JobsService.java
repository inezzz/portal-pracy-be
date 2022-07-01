package com.ig.portalpracy.service;

import com.ig.portalpracy.model.JobOffer;
import com.ig.portalpracy.model.JobOfferDTO;

import java.util.List;

public interface JobsService {

    void createJobGamma(JobOfferDTO jobOfferDTO);
    void updateJobGamma(JobOfferDTO jobOfferDTO, Long id);
    void deleteJobGamma(Long id);
    List<JobOffer> getAllJobs();
}
