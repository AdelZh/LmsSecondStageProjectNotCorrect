package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repo.CompanyRepo;

import java.util.List;


@Repository
@Transactional
public class CompanyRepoImpl implements CompanyRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void SaveCompany(Company company) {
        entityManager.persist(company);
    }


    @Override
    public Company getCompanyById(Long id) {
       return entityManager.find(Company.class, id);
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }

    @Override
    public void updateCompany(Long id, Company newCompany) {
        Company company=entityManager.find(Company.class, id);
        company.setCompanyName(newCompany.getCompanyName());
        company.setLocatedCountry(newCompany.getLocatedCountry());
        entityManager.merge(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }
}
