package peaksoft.service;

import peaksoft.entity.Company;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    void saveGroup(Long companyId, Group group);
    List<Group> getAllGroup();
    List<Group> getGroupByCompanyId(Long companyId);
    Group getGroupById(Long id);
    void deleteGroup(Long id);
    void updateGroup(Long id, Group newGroup);
    void assignStudentToGroup(Long groupId, List<Long> studentId);
}
