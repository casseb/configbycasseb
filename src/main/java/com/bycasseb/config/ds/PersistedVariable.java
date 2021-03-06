package com.bycasseb.config.ds;

import com.bycasseb.config.common.Constants;
import org.springframework.data.annotation.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersistedVariable extends Variable{
	
	@Id
	private String id;

	public PersistedVariable(Variable variable) {
		this.id = variable.getAliases()+" |&| "+variable.getGroup()+ Constants.SEPARATOR +variable.getSchema();
		this.setAliases(variable.getAliases());
		this.setGroup(variable.getGroup());
		this.setType(variable.getType());
		this.setSchema(variable.getSchema());
		this.setValue(variable.getValue());
	}
}
