package com.vtii.service;

import com.vtii.entity.Position;
import com.vtii.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
