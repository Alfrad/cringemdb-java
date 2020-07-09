package io.github.alfrad.cringemdb.utils;

import us.codecraft.webmagic.model.formatter.ObjectFormatter;

public class CringemdbBooleanFormatter implements ObjectFormatter<Boolean> {

	@Override
	public Boolean format(String raw) throws Exception {
		return Constants.YES.equals(raw) ? true : false;
	}

	@Override
	public Class<Boolean> clazz() {
		return Boolean.class;
	}

	@Override
	public void initParam(String[] extra) {
	}

}
