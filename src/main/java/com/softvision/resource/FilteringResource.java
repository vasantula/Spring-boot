package com.softvision.resource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.softvision.bean.FilterBean;
import com.softvision.bean.FilterUser;

@RestController
public class FilteringResource {

	
	@GetMapping("/filtering")
	public FilterBean getFilterBean() {
		return new FilterBean("Field1", "Field2", "Field3");
	}
	
	@GetMapping("/filtering-list")
	public List<FilterBean> getFilterBeanList() {
		return Arrays.asList(new FilterBean("Field1", "Field2", "Field3"),
				new FilterBean("Field1", "Field2", "Field3"));
	}
	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue getFilterBeanDynamically() {
		FilterUser user = new FilterUser(4, "Dynamic", new Date());		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);		
		String[] filterParameters = {"id","name"};
		mappingJacksonValue.setFilters(getFilter(filterParameters));
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue getFilterBeanListDynamically() {		
		List<FilterUser> list = Arrays.asList(new FilterUser(4, "Dynamic", new Date()), 
				new FilterUser(3, "Dynamic2", new Date()));		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);		
		String[] filterParameters = {"birthDate","name"};
		mappingJacksonValue.setFilters(getFilter(filterParameters));
		return mappingJacksonValue;
	}
	private FilterProvider getFilter(String[] filterParameters) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filterParameters);
		return new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
	}
	
}
