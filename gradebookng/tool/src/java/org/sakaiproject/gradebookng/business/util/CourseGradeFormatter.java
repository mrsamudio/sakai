/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package org.sakaiproject.gradebookng.business.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.model.StringResourceModel;
import org.sakaiproject.gradebookng.business.GbCategoryType;
import org.sakaiproject.gradebookng.business.GbRole;
import org.sakaiproject.service.gradebook.shared.CourseGrade;
import org.sakaiproject.tool.gradebook.Gradebook;

/**
 * Helper class to handle the formatting of the course grade display string
 *
 * @author Steve Seinsburg (steve.swinsburg@gmail.com)
 */
public class CourseGradeFormatter {

	private final Gradebook gradebook;
	private final GbRole currentUserRole;
	private final boolean isCourseGradeVisible;
	private final boolean showPoints;
	private final boolean showOverride;

	/**
	 * Constructor to initialise the data
	 *
	 * All of this gets passed in ONCE, then reused for every format call
	 *
	 * @param gradebook the gradebook settings
	 * @param currentUserRole role of the current user
	 * @param isCourseGradeVisible if the course grade is visible to the user
	 * @param showPoints if we are to show points
	 * @param showOverride if we are to show the override
	 * @return
	 */
	public CourseGradeFormatter(final Gradebook gradebook, final GbRole currentUserRole,
			final boolean isCourseGradeVisible,
			final boolean showPoints,
			final boolean showOverride) {

		this.gradebook = gradebook;
		this.currentUserRole = currentUserRole;
		this.isCourseGradeVisible = isCourseGradeVisible;
		this.showPoints = showPoints;
		this.showOverride = showOverride;
	}

	/**
	 * Format the passed in course grade
	 *
	 * @param courseGrade the raw course grade for the student
	 *
	 * @return the formatted display string
	 */
	public String format(final CourseGrade courseGrade) {

		String rval = null;

		// something has gone wrong and there's no course grade!
		if (courseGrade == null) {
			rval = MessageHelper.getString("coursegrade.display.none");
			// instructor, can view
		} else if (this.currentUserRole == GbRole.INSTRUCTOR) {
			rval = build(courseGrade);
			// TA, permission check
		} else if (this.currentUserRole == GbRole.TA) {
			if (!this.isCourseGradeVisible) {
				rval = MessageHelper.getString("label.coursegrade.nopermission");
			} else {
				rval = build(courseGrade);
			}
			// student, check if course grade released, and permission check
		} else {
			if (this.gradebook.isCourseGradeDisplayed()) {
				if (!this.isCourseGradeVisible) {
					rval = MessageHelper.getString("label.coursegrade.nopermission");
				} else {
					rval = build(courseGrade);
				}
			} else {
				rval = MessageHelper.getString("label.coursegrade.studentnotreleased");
			}
		}

		return rval;

	}

	/**
	 * Takes care of checking the values and configured settings to format the course grade into an applicable display format
	 *
	 * Format:
	 *
	 * Instructor always gets lettergrade + percentage but may also get points depending on setting. TA, same as instructor unless disabled
	 * Student gets whatever is configured
	 *
	 * @return formatted string ready for display
	 */
	private String build(final CourseGrade courseGrade) {
		final List<String> parts = new ArrayList<>();

		// letter grade
		String letterGrade = null;
		if (this.showOverride && StringUtils.isNotBlank(courseGrade.getEnteredGrade())) {
			letterGrade = courseGrade.getEnteredGrade();
		} else {
			letterGrade = courseGrade.getMappedGrade();
		}

		if (StringUtils.isNotBlank(letterGrade)
				&& (this.gradebook.isCourseLetterGradeDisplayed() || this.currentUserRole == GbRole.INSTRUCTOR)) {
			parts.add(letterGrade);
		}

		// percentage
		final String calculatedGrade = FormatHelper.formatStringAsPercentage(courseGrade.getCalculatedGrade());

		if (StringUtils.isNotBlank(calculatedGrade)
				&& (this.gradebook.isCourseAverageDisplayed() || this.currentUserRole == GbRole.INSTRUCTOR)) {
			if (parts.isEmpty()) {
				parts.add(new StringResourceModel("coursegrade.display.percentage-first", null,
						new Object[] { calculatedGrade }).getString());
			} else {
				parts.add(new StringResourceModel("coursegrade.display.percentage-second", null,
						new Object[] { calculatedGrade }).getString());
			}
		}

		// requested points
		if (this.showPoints) {

			// don't display points for weighted category type
			final GbCategoryType categoryType = GbCategoryType.valueOf(this.gradebook.getCategory_type());
			if (categoryType != GbCategoryType.WEIGHTED_CATEGORY) {
				
				Double pointsEarned = courseGrade.getPointsEarned();
				Double totalPointsPossible = courseGrade.getTotalPointsPossible();
				
				// handle the special case in the gradebook service where totalPointsPossible = -1
				if(totalPointsPossible != null && totalPointsPossible == -1) {
					pointsEarned = null;
					totalPointsPossible = null;
				}

				// if instructor, show the points if requested
				// otherwise check the settings
				if (this.currentUserRole == GbRole.INSTRUCTOR || this.gradebook.isCoursePointsDisplayed()) {
					if(pointsEarned != null && totalPointsPossible != null) {
						if (parts.isEmpty()) {
							parts.add(MessageHelper.getString("coursegrade.display.points-first", pointsEarned, totalPointsPossible));
						} else {
							parts.add(MessageHelper.getString("coursegrade.display.points-second", pointsEarned, totalPointsPossible));
						}
					}
				}
			}
		}

		// if parts is empty, there are no grades, display a -
		if (parts.isEmpty()) {
			parts.add(MessageHelper.getString("coursegrade.display.none"));
		}

		return String.join(" ", parts);
	}

}
