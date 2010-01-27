package net.berinle.dao;

import java.util.List;

import net.berinle.model.Skill;

public interface SkillDao {

	List<Skill> getAll();

	List<Skill> loadSkills(String[] skillIds);

}
