package com.example.TranQuangHien2280600922.controller;

import com.example.TranQuangHien2280600922.model.Skill;
import com.example.TranQuangHien2280600922.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public List<Skill> getAllSkills() {
        // Thay vì return findAll(), ta chỉ lấy các item chưa xóa
        return skillRepository.findByIsDeletedFalse();
    }

    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        skill.setDeleted(false); // Mặc định khi thêm là chưa xóa
        return skillRepository.save(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        // XÓA MỀM (Soft Delete): Lấy bản ghi lên, đổi trạng thái isDeleted thành true, rồi lưu lại
        skillRepository.findById(id).ifPresent(skill -> {
            skill.setDeleted(true);
            skillRepository.save(skill);
        });
    }
}
