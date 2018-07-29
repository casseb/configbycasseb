package com.bycasseb.config.service;

import java.util.Optional;

import com.bycasseb.config.ds.PersistedVariable;

public interface PersistService {

	void save(PersistedVariable variable);

	Optional<PersistedVariable> query(String string);

}
