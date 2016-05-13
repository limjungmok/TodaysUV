package com.weatheruv.domain;

public class ReturnUV {

	public String getTodayMessage(int mTodayValue) {
		if (mTodayValue == 0)
			return "해가 없어요";
		else if (mTodayValue < 3)
			return "안전";
		else if (mTodayValue < 6)
			return "보통";
		else if (mTodayValue < 8)
			return "위험";
		else if (mTodayValue < 11)
			return "매우위험";
		else
			return "극도위험";
	}

	public String getTodayUvSpf(int mTodayValue) {
		if (mTodayValue == 0)
			return "SPF --";
		else if (mTodayValue < 3)
			return "SPF 0 - 15";
		else if (mTodayValue < 6)
			return "SPF 15 - 30";
		else if (mTodayValue < 8)
			return "SPF 30 - 45";
		else if (mTodayValue < 11)
			return "SPF 45 - 50";
		else
			return "SPF 50";

	}
	public String getTodayCounduct(int mTodayValue){
		if (mTodayValue < 3)
			return "안 발라도 돼요 걱정 마세요";
		else if (mTodayValue < 6)
			return "아침에 한 번 발라주세요";
		else if (mTodayValue < 8)
			return "아침에 한 번\n" + "점심에 한 번 발라주세요";
		else if (mTodayValue < 11)
			return "아침에 한 번\n" + "외출시 2시간 마다 발라주세요";
		else
			return "아침에 한 번\n" + "외출시 2시간 마다 발라주세요";
	}

	public String getTomorrowMessage(int mTomorrowValue) {
		if (mTomorrowValue == 0)
			return "해가 없어요";
		else if (mTomorrowValue < 3)
			return "안전";
		else if (mTomorrowValue < 6)
			return "보통";
		else if (mTomorrowValue < 8)
			return "위험";
		else if (mTomorrowValue < 11)
			return "매우위험";
		else
			return "극도위험";

	}

	public String getTomorrowUvSpf(int mTomorrowValue) {
		if (mTomorrowValue == 0)
			return "SPF --";
		else if (mTomorrowValue < 3)
			return "SPF 0 - 15";
		else if (mTomorrowValue < 6)
			return "SPF 15 - 30";
		else if (mTomorrowValue < 8)
			return "SPF 30 - 45";
		else if (mTomorrowValue < 11)
			return "SPF 45 - 50";
		else
			return "SPF 50";

	}

	public String getAfterTomorrowMessage(int mAfterTomorrowValue) {
		if (mAfterTomorrowValue == 0)
			return "해가 없어요";
		else if (mAfterTomorrowValue < 3)
			return "안전";
		else if (mAfterTomorrowValue < 6)
			return "보통";
		else if (mAfterTomorrowValue < 8)
			return "위험";
		else if (mAfterTomorrowValue < 11)
			return "매우위험";
		else
			return "극도위험";

	}

	public String getAfterTomorrowUvSpf(int mAfterTomorrowValue) {
		if (mAfterTomorrowValue == 0)
			return "SPF --";
		else if (mAfterTomorrowValue < 3)
			return "SPF 0 - 15";
		else if (mAfterTomorrowValue < 6)
			return "SPF 15 - 30";
		else if (mAfterTomorrowValue < 8)
			return "SPF 30 - 45";
		else if (mAfterTomorrowValue < 11)
			return "SPF 45 - 50";
		else
			return "SPF 50";
	}
}
