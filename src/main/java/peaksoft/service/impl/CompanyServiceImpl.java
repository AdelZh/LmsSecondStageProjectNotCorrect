package peaksoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repo.CompanyRepo;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;


    @Override
    public void SaveCompany(Company company) {
        companyRepo.SaveCompany(company);
    }


    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.getCompanyById(id);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepo.deleteCompany(id);
    }

    @Override
    public void updateCompany(Long id, Company newCompany) {
        companyRepo.updateCompany(id, newCompany);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepo.getAllCompany();
    }
}
