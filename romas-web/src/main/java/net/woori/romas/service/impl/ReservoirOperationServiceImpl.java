package net.woori.romas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.woori.romas.domain.db.ReservoirOperation;
import net.woori.romas.domain.db.ReservoirOperation.CompositeOperationPK;
import net.woori.romas.repository.ReservoirOperationRepository;
import net.woori.romas.service.ReservoirOperationService;

@Service
@Transactional
public class ReservoirOperationServiceImpl implements ReservoirOperationService {

	@Autowired
	private ReservoirOperationRepository reservoirLevelRepository;
	
	@Override
	public ReservoirOperation get(CompositeOperationPK id) {
		return reservoirLevelRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<ReservoirOperation> getList() {
		return reservoirLevelRepository.findAll();
	}

	@Override
	public boolean regist(ReservoirOperation domain) {
		if (isNew(domain)) {
			return reservoirLevelRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(ReservoirOperation domain) {
		if (!isNew(domain)) {
			return reservoirLevelRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(CompositeOperationPK id) {
		reservoirLevelRepository.deleteById(id);
		return true;
	}

	private boolean isNew(ReservoirOperation domain) {
		return !reservoirLevelRepository.existsById(new CompositeOperationPK(domain.getIndexDate(), domain.getFacCode()));
	}
}
