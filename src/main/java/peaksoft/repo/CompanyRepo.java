package peaksoft.repo;

import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import java.util.List;

public interface CompanyRepo {

    void SaveCompany(Company company);
    Company getCompanyById(Long id);
    void deleteCompany(Long id);
    void updateCompany(Long id, Company newCompany);
    List<Company> getAllCompany();

}
