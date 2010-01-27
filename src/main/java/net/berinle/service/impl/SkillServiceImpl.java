package net.berinle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.berinle.dao.SkillDao;
import net.berinle.model.Skill;
import net.berinle.service.SkillService;

@Service
@Transactional(readOnly=true)
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;
	
	public List<Skill> getAllSkills() {
		return skillDao.getAll();
	}

}
