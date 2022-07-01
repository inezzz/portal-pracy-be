package com.ig.portalpracy.controller;


import com.ig.portalpracy.model.JobOffer;
import com.ig.portalpracy.model.JobOfferDTO;
import com.ig.portalpracy.model.JobOffersDTO;
import com.ig.portalpracy.service.DefaultJobsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobsController {

    private final DefaultJobsService defaultJobsService;


    @GetMapping()
    public JobOffersDTO getJobs() {
        JobOffersDTO jobOffersDTO = new JobOffersDTO();
        List<JobOffer> allJobs = defaultJobsService.getAllJobs();
        jobOffersDTO.setJobGammaList(allJobs);
        return jobOffersDTO;
    }

    @GetMapping("/{id}")
    public JobOfferDTO getJobOffer(@PathVariable String id) {
        JobOfferDTO jobOfferDTO = new JobOfferDTO();
        jobOfferDTO.setJobTitle(defaultJobsService.getJob(Long.parseLong(id)).getJobTitle());
        jobOfferDTO.setSalary(defaultJobsService.getJob(Long.parseLong(id)).getSalary());
        jobOfferDTO.setDescription(defaultJobsService.getJob(Long.parseLong(id)).getDescription());
        return jobOfferDTO;
    }

    @PostMapping()
    public void createJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
        System.out.println(jobOfferDTO);
        defaultJobsService.createJobGamma(jobOfferDTO);
    }

    @PutMapping("/{id}")
    public void updateJobOffer(@RequestBody JobOfferDTO jobOfferDTO, @PathVariable String id) {
        defaultJobsService.updateJobGamma(jobOfferDTO, Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void deleteJobOffer(@PathVariable String id) {
        System.out.println(id);
        defaultJobsService.deleteJobGamma(Long.parseLong(id));
    }
}
