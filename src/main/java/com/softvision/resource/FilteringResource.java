package com.softvision.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.bean.FilterBean;

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
}
