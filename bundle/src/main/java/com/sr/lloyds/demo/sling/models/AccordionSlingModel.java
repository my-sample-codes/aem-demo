package com.sr.lloyds.demo.sling.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sr.lloyds.demo.utils.LloydsConstants;

@Model(adaptables = Resource.class)
public class AccordionSlingModel {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccordionSlingModel.class);

	@Inject
	@Named("heading")
	@Optional
	private String heading;

	@Inject
	@Named("desktopwidth")
	@Optional
	private String desktopwidth;

	@Inject
	@Named("showExpandCollapse")
	@Optional
	private boolean showExpandCollapse;

	@Inject
	@Named("accordionFields")
	@Optional
	private Property accordionFields;

	private List<MultifieldValues> multiFields;

	public String getHeading() {
		return heading;
	}

	public String getDesktopwidth() {
		return desktopwidth;
	}

	public boolean getShowExpandCollapse() {
		return showExpandCollapse;
	}

	public List<MultifieldValues> getMultiFields() {
		return multiFields;
	}

	@PostConstruct
	public List<MultifieldValues> getAccordionFields() {
		List<MultifieldValues> accFields = new ArrayList<>();
		try {
			if (this.accordionFields != null) {
				Value[] values;

				if (this.accordionFields.isMultiple()) {
					values = this.accordionFields.getValues();
				} else {
					values = new Value[1];
					values[0] = this.accordionFields.getValue();
				}

				for (Value val : values) {
					JSONObject obj = new JSONObject(val.getString());
					accFields.add(new MultifieldValues(obj.getString(LloydsConstants.HEADING_TEXT),
							obj.getString(LloydsConstants.BODY_TEXT), obj.getString(LloydsConstants.DEFAULT_STATE)));
				}
			}
		} catch (RepositoryException | IllegalStateException | JSONException e) {
			LOGGER.error(e.getMessage(), e);
		}
		multiFields = accFields;
		return accFields;
	}

	public class MultifieldValues {
		private String headlineText;
		private String bodyText;
		private String defaultState;

		public MultifieldValues() {
		}

		public MultifieldValues(String headlineText, String bodyText, String defaultState) {
			super();
			setHeadlineText(headlineText);
			setBodyText(bodyText);
			setDefaultState(defaultState);
		}

		public String getHeadlineText() {
			return headlineText;
		}

		public void setHeadlineText(String headlineText) {
			this.headlineText = headlineText;
		}

		public String getBodyText() {
			return bodyText;
		}

		public void setBodyText(String bodyText) {
			this.bodyText = bodyText;
		}

		public String getDefaultState() {
			return defaultState;
		}

		public void setDefaultState(String defaultState) {
			this.defaultState = defaultState;
		}
	}
}
