package com.bycasseb.config.service;

import com.bycasseb.config.ds.Variable;

interface ValidatorService {

	void execute(Variable variable) throws Exception;

}
