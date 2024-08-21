package com.example.FitnessClubApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FitnessClubApp.entity.SubscriptionPlan;
import com.example.FitnessClubApp.repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {

	@Autowired
	private SubscriptionPlanRepository subscriptionPlanRepository;

	public SubscriptionPlan addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {

		SubscriptionPlan subscriptionPlan2 = subscriptionPlanRepository.save(subscriptionPlan);

		return subscriptionPlan2;

	}

	public SubscriptionPlan getSubscriptionPlan(long id) {

		Optional<SubscriptionPlan> opt = subscriptionPlanRepository.findById(id);

		if (opt.isPresent())
			return opt.get();

		return null;

	}

	public List<SubscriptionPlan> getSubscriptionPlans() {

		return subscriptionPlanRepository.findAll();

	}

	public SubscriptionPlan editSubscriptionPlan(SubscriptionPlan subscriptionPlan, long id) {

		Optional<SubscriptionPlan> opt = subscriptionPlanRepository.findById(id);

		if (opt.isPresent()) {

			SubscriptionPlan sp = opt.get();
			sp.setName(subscriptionPlan.getName());
			sp.setPrice(subscriptionPlan.getPrice());
			subscriptionPlanRepository.save(sp);

			return sp;

		}

		return null;

	}

	public boolean deleteSubscriptionPlan(long id) {

		Optional<SubscriptionPlan> opt = subscriptionPlanRepository.findById(id);

		if (opt.isPresent()) {

			subscriptionPlanRepository.delete(opt.get());
			return true;

		}

		return false;

	}

}
