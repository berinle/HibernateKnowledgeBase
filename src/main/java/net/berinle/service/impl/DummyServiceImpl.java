package net.berinle.service.impl;

import java.util.List;

import net.berinle.dao.DummyDao;
import net.berinle.service.DummyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("dummyService")
@Transactional(readOnly=true)
public class DummyServiceImpl implements DummyService {

	@Autowired private DummyDao dummyDao;
	
	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List getResults(){
		return dummyDao.getResults();
	}
}
