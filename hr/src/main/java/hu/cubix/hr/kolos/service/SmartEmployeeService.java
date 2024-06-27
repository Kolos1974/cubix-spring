package hu.cubix.hr.kolos.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.config.HrConfigurationProperties;
import hu.cubix.hr.kolos.config.HrConfigurationProperties.RaiseSalary.SmartValues;
import hu.cubix.hr.kolos.model.Employee;

@Service
public class SmartEmployeeService extends AbstractEmployeeService {

	@Autowired
	HrConfigurationProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {

		// Older version:
		/*
		if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=10) {
			return 10;
		}
		if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=5) {
			return 5;
		}
		if ((float)(LocalDate.now().getYear()-employee.getStartedWorking().getYear())>=2.5) {
			return 2;
		}
		return 0;
		*/
		
		// int yearsWorked = LocalDate.now().getYear()-employee.getStartedWorking().getYear();
		
		double yearsWorked = ChronoUnit.DAYS.between(employee.getDateOfStartWork(), LocalDateTime.now()) / 365.0;
		
		SmartValues smartValues = config.getRaiseSalary().getSmartValues();
		
		
		//0. megoldás: fixen 3 darab limit
		/*
		if (yearsWorked>=config.getRaiseSalary().getSmartValues().getInterval1year()) {
			// return config.getRaiseSalary().getSmartValues().getInterval1percent();
			return smartValues.getInterval1percent();
		}
		
		if (yearsWorked>=config.getRaiseSalary().getSmartValues().getInterval2year()) {
			//return config.getRaiseSalary().getSmartValues().getInterval2percent();
			return smartValues.getInterval2percent();
		}
		
		if ((float)(LocalDate.now().getYear()-employee.getStartedWorking().getYear())>=config.getRaiseSalary().getSmartValues().getInterval3year()) {
			// return config.getRaiseSalary().getSmartValues().getInterval3percent();
			return smartValues.getInterval3percent();
		}
		
		return smartValues.getInterval4percent();
		*/
		
		
		TreeMap<Double, Integer> limits = smartValues.getLimits();
		
		//opcionális feladat: akárhány limit kezelése, 1. 
		/*
		
		Integer maxPercent = null;
		
		for(var entry: limits.entrySet()) {
			if(yearsWorked > entry.getKey())
				maxPercent = entry.getValue();
			else
				break;
		}
		
		return maxPercent == null ? 0 : maxPercent;
		*/
		
		//opcionális feladat: akárhány limit kezelése, 2. megoldás
		/*
		Optional<Double> optionalMax = limits.keySet().stream()
		.filter(k -> yearsWorked >=k)
		.max(Double::compare);
		
		return optionalMax.isEmpty() ? 0 : limits.get(optionalMax.get());
		*/
		
		//opcionális feladat: akárhány limit kezelése, 3. megoldás
		Entry<Double, Integer> floorEntry = limits.floorEntry(yearsWorked);
		return floorEntry == null ? 0 : floorEntry.getValue();
		
		 
	}

}
