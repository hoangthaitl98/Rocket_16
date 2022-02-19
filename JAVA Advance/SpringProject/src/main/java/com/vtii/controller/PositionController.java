package com.vtii.controller;

import com.vtii.dto.PositionDto;
import com.vtii.entity.Position;
import com.vtii.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/position")
@CrossOrigin("*")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<?> getAllPosition(){
        List<Position> positions = positionService.getAllPosition();
        List<PositionDto> positionDtos = new ArrayList<>();
        for (Position position:positions) {
            PositionDto dto = new PositionDto(position.getId(), position.getPositionName().toString());
            positionDtos.add(dto);
        }
        return new ResponseEntity<>(positionDtos, HttpStatus.OK);
    }
}
