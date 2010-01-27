package net.berinle.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.berinle.dao.SkillDao;
import net.berinle.model.Skill;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Skill> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Skill.class).list();
	}

	public List<Skill> loadSkills(String[] skillIds) {
		Session session = sessionFactory.getCurrentSession();
		List<Skill> result = new ArrayList<Skill>();
		for(String id: skillIds){
			Long skillId = new Long(id);
			result.add( (Skill)session.load(Skill.class, skillId) );
		}
		return result;
	}

}
