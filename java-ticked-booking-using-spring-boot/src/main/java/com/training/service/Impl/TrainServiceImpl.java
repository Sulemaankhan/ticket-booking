package com.training.service.Impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.customexception.ResourseNotFoundException;
import com.training.entity.Train;
import com.training.repo.TrainRepository;
import com.training.service.TrainService;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainRepository trainRepository;

	@Override
	public List<Train> searchBySourceOrDestAndDate(String source, String dest, Date date) {

		//search train by source or destination and date
		List<Train> train = trainRepository.findBySourceOrDestinationAndDate(source, dest, date);

		if (train != null) {
			//validate condition then return trains
			return train;
		}
		//if anything is not matched with get error
		throw new ResourseNotFoundException("No Train is available...............");
	}

}
