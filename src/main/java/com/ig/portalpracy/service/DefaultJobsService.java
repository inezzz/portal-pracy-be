package com.ig.portalpracy.service;

import com.ig.portalpracy.model.JobOffer;
import com.ig.portalpracy.model.JobOfferDTO;
import com.ig.portalpracy.repository.JobsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DefaultJobsService implements JobsService{

    private final JobsRepository jobsRepository;

    public DefaultJobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public void createJobGamma(JobOfferDTO jobOfferDTO) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setJobTitle(jobOfferDTO.getJobTitle());
        jobOffer.setSalary(jobOfferDTO.getSalary());
        jobOffer.setDescription(jobOfferDTO.getDescription());

        jobsRepository.save(jobOffer);
    }

    @Override
    public void updateJobGamma(JobOfferDTO jobOfferDTO, Long id) {
        Optional<JobOffer> jobOfferOptional = jobsRepository.findById(id);
        jobOfferOptional.get().setJobTitle(jobOfferDTO.getJobTitle());
        jobOfferOptional.get().setSalary(jobOfferDTO.getSalary());
        jobOfferOptional.get().setDescription(jobOfferDTO.getDescription());

        jobsRepository.save(jobOfferOptional.get());
    }

    @Override
    public void deleteJobGamma(Long id) {
        jobsRepository.deleteById(id);
    }

    @Override
    public List<JobOffer> getAllJobs() {
        return jobsRepository.findAll();
    }

    public JobOffer getJob(Long id) {
        Optional<JobOffer> optionalJobOffer = jobsRepository.findById(id);
        return optionalJobOffer.get();
    }
}
