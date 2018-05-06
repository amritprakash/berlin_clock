package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.TimeConverter;

public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String aTime) {

		String[] sArr = aTime.split(":");

		int hours = Integer.parseInt(sArr[0]);
		int minutes = Integer.parseInt(sArr[1]);
		int seconds = Integer.parseInt(sArr[2]);

		StringBuffer berlinTime = new StringBuffer();

		berlinTime.append(getSeconds(seconds)).append(getHours(hours)).append(getMinutes(minutes));

		return berlinTime.toString();
	}

	private String getSeconds(int seconds) {

		StringBuffer sLight = new StringBuffer();
		if (seconds % 2 == 0) {
			sLight.append("Y");
		} else {
			sLight.append("O");
		}

		sLight.append("\r\n");

		return sLight.toString();
	}

	private String getHours(int hours) {

		int firstRow = hours / 5;
		int secondRow = hours % 5;

		StringBuffer hLight = new StringBuffer();
		for (int i = 1; i <= 4; i++) {
			if (i <= firstRow) {
				hLight.append("R");
			} else {
				hLight.append("O");
			}
		}

		hLight.append("\r\n");

		for (int i = 1; i <= 4; i++) {
			if (i <= secondRow) {
				hLight.append("R");
			} else {
				hLight.append("O");
			}
		}

		hLight.append("\r\n");

		return hLight.toString();

	}

	private String getMinutes(int minutes) {

		int firstRow = minutes / 5;
		int secondRow = minutes % 5;

		StringBuffer mLight = new StringBuffer();
		for (int i = 1; i <= 11; i++) {
			if (i <= firstRow) {
				if (i % 3 == 0) {
					mLight.append("R");
				} else {
					mLight.append("Y");
				}
			} else {
				mLight.append("O");
			}
		}

		mLight.append("\r\n");

		for (int i = 1; i <= 4; i++) {
			if (i <= secondRow) {
				mLight.append("Y");
			} else {
				mLight.append("O");
			}
		}

		return mLight.toString();

	}

}
