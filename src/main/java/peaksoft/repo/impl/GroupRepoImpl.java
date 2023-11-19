package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.api.CompanyApi;
import peaksoft.entity.*;
import peaksoft.repo.GroupRepo;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class GroupRepoImpl implements GroupRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudentService studentService;


    @Override
    public void saveGroup(Long companyId, Group group) {
        Company company=entityManager.find(Company.class, companyId);
        group.setCompany(company);
        entityManager.persist(group);
    }


    @Override
    public List<Group> getAllGroup() {
        return entityManager.createQuery("select g from Group g", Group.class).getResultList();
    }

    @Override
    public List<Group> getGroupByCompanyId(Long companyId) {
        Company company=entityManager.find(Company.class, companyId);
        if(company != null && company.getGroups() != null){
            return new ArrayList<>(company.getGroups());
        }else {
            return Collections.emptyList();
        }
    }



    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void deleteGroup(Long id) {

    }

    @Override
    public void updateGroup(Long id, Group newGroup) {
        Group group=entityManager.find(Group.class, id);
        group.setGroupName(newGroup.getGroupName());
        group.setImage(newGroup.getImage());
        group.setDateOfStart(newGroup.getDateOfStart());
        entityManager.merge(group);
    }

    @Override
    public void assignStudentToGroup(Long groupId, List<Long> studentId) {
           Group group=groupService.getGroupById(groupId);

            if (group != null) {
            for (Long studentIds : studentId) {
                Student student=studentService.getStudentById(studentIds);

                if (student != null) {
                    student.setGroup(group);

                    studentService.saveStudent(student);
                }
            }
        }
    }
}
