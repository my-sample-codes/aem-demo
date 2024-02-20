/**
 * 
 */
package com.sr.lloyds.demo.sling.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class TabAccordionSlingModel {

	private static final Logger LOGGER = LoggerFactory.getLogger(TabAccordionSlingModel.class);

	@Inject
	@Named("firstTitle")
	@Optional
	private String firstTitle;

	@Inject
	@Named("firstText")
	@Optional
	private String firstText;

	@Inject
	@Named("secondTitle")
	@Optional
	private String secondTitle;

	@Inject
	@Named("secondText")
	@Optional
	private String secondText;

	public String getFirstTitle() {
		LOGGER.info("[TEST] Getting Title of the First Section------->" + firstTitle);
		return firstTitle;
	}

	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}

	public String getFirstText() {
		return firstText;
	}

	public void setFirstText(String firstText) {
		this.firstText = firstText;
	}

	public String getSecondTitle() {
		return secondTitle;
	}

	public void setSecondTitle(String secondTitle) {
		this.secondTitle = secondTitle;
	}

	public String getSecondText() {
		return secondText;
	}

	public void setSecondText(String secondText) {
		this.secondText = secondText;
	}

}
