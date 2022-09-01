package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.repository.HosipatalRepository;

@Service
public class HosipatalService {

	@Autowired
	HosipatalRepository hr;
}
