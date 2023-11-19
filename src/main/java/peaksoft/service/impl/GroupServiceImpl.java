package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.entity.Group;
import peaksoft.repo.GroupRepo;
import peaksoft.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepo;


    @Override
    public void saveGroup(Long companyId, Group group) {
        groupRepo.saveGroup(companyId, group);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepo.getAllGroup();
    }

    @Override
    public List<Group> getGroupByCompanyId(Long companyId) {
        return groupRepo.getGroupByCompanyId(companyId);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepo.getGroupById(id);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepo.deleteGroup(id);
    }

    @Override
    public void updateGroup(Long id, Group newGroup) {
        groupRepo.updateGroup(id, newGroup);
    }

    @Override
    public void assignStudentToGroup(Long groupId, List<Long> studentId) {
        groupRepo.assignStudentToGroup(groupId, studentId);
    }
}
