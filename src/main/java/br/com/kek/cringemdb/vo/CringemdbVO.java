package br.com.kek.cringemdb.vo;

import br.com.kek.cringemdb.utils.Constants;
import br.com.kek.cringemdb.utils.CringemdbBooleanFormatter;
import lombok.Data;
import lombok.ToString;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;

@Data
@ToString
public class CringemdbVO {

	@Formatter(formatter = CringemdbBooleanFormatter.class)
	@ExtractBy(Constants.XPATH_SEX_SCENE)
	private Boolean sexScene;

	@Formatter(formatter = CringemdbBooleanFormatter.class)
	@ExtractBy(Constants.XPATH_NUDITY)
	private Boolean nudity;

	@Formatter(formatter = CringemdbBooleanFormatter.class)
	@ExtractBy(Constants.XPATH_SEXUAL_VIOLENCE)
	private Boolean sexualViolence;
	
}
