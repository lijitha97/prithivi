package com.prodapt.ReferTalents.model;

import java.util.Comparator;

public class SortByPositionCode implements Comparator<RtJobDetails> {

	@Override
	public int compare(RtJobDetails rtJobDetails, RtJobDetails rtJobDetails1) {
		return rtJobDetails.getJdPositionCode().compareTo(rtJobDetails1.getJdPositionCode());
	}

}
