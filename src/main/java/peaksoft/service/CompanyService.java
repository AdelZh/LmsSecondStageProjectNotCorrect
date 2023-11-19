package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {

    void SaveCompany(Company company);
    Company getCompanyById(Long id);
    void deleteCompany(Long id);
    void updateCompany(Long id, Company newCompany);
    List<Company> getAllCompany();
}
