package com.prodapt.ReferTalents.service;
import java.util.List;

import com.prodapt.ReferTalents.model.RtPreference;

public interface ServiceApi {

	List<RtPreference> getAll();

	public RtPreference save(RtPreference prjd);
}
