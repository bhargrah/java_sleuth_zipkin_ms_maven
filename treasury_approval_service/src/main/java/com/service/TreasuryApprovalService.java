package com.service;

import org.springframework.stereotype.Service;

@Service
public class TreasuryApprovalService {
	
	public String fundInternally() {
		return "internal_funded";
	}
	
	public String fundExternally() {
		return "external_funded";
	}

}
