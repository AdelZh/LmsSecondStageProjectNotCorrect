package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.entity.Instructor;
import peaksoft.entity.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupApi {

    private final GroupService groupService;
    private final StudentService studentService;

    @GetMapping
    public String getAllGroup(Model model) {
        model.addAttribute("allGroup", groupService.getAllGroup());
        return "myGroup/getAll";
    }

    @GetMapping("/{companyId}")
    public String getAllGroupByCompanyId(Model model, @PathVariable Long companyId) {
        model.addAttribute("groupByCompany", groupService.getGroupByCompanyId(companyId));
        return "myGroup/getAllGroupByCompanyId";
    }

    @GetMapping("/create/{companyId}")
    public String createGroupByCompany(@PathVariable Long companyId, Model model) {
        model.addAttribute("companyId", companyId);
        model.addAttribute("newGroup", new Group());
        return "myGroup/createGroup";
    }


    @PostMapping("/save/{companyId}")
    public String saveGroupByCompany(@PathVariable Long companyId, @ModelAttribute Group group) {
        groupService.saveGroup(companyId, group);
        return "redirect:/group";
    }


    @GetMapping("/update/{groupId}")
    public String getById(@PathVariable Long groupId, Model model) {
        model.addAttribute("group", groupService.getGroupById(groupId));
        return "myGroup/update-group";
    }

    @PostMapping("/merge/{groupId}")
    public String updates(@ModelAttribute Group group, @PathVariable Long groupId) {
        groupService.updateGroup(groupId, group);
        return "redirect:/group";
    }


    @GetMapping("/delete/{groupId}")
    public String deleteCourse(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return "redirect:/group";
    }

    @GetMapping("/{getById}/get/booking")
    public String showAndBookGroup(@PathVariable("getById") Long groupId, Model model) {
        Group group=groupService.getGroupById(groupId);
        List<Student> availableStudent = studentService.getAllStudent();

        model.addAttribute("getGroupById", group);
        model.addAttribute("students", availableStudent);
        return "myGroup/student-assign-group";
    }



    @PostMapping("/{getById}/get/booking")
    public String bookGroup(@RequestParam List<Long> groupId, @PathVariable Long getById) {
        Student student=studentService.getStudentById(getById);
        groupService.assignStudentToGroup(student.getId(), groupId);
        return "redirect:/company";
    }
}





