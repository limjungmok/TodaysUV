package com.weatheruv.reuse.etc;

import java.util.HashMap;

public class LocationCode {
	private String location;
	private HashMap<String, Long> map;

	public LocationCode() {}

	public LocationCode(String mLocation) {
		this.location = mLocation;
		map = new HashMap<String, Long>();
		// 서울특별시(완료)
		map.put("서울특별시 광진구", 1121500000L); 
		map.put("서울특별시 성동구", 1120000000L);
		map.put("서울특별시 용산구", 1117000000L);
		map.put("서울특별시 종로구", 1111000000L);
		map.put("서울특별시 강서구", 1150000000L); 
		map.put("서울특별시 양천구", 1147000000L);
		map.put("서울특별시 구로구", 1153000000L);
		map.put("서울특별시 동대문구", 1123000000L);
		map.put("서울특별시 영등포구", 1156000000L);
		map.put("서울특별시 금천구", 1154500000L);
		map.put("서울특별시 서초구", 1165000000L);
		map.put("서울특별시 강남구", 1168000000L);
		map.put("서울특별시 송파구", 1171000000L);
		map.put("서울특별시 강동구", 1174000000L);
		map.put("서울특별시 마포구", 1144000000L);
		map.put("서울특별시 서대문구", 1141000000L);
		map.put("서울특별시 은평구", 1138000000L);
		map.put("서울특별시 중구", 1114000000L);
		map.put("서울특별시 성북구", 1129000000L);
		map.put("서울특별시 강북구", 1130500000L); 
		map.put("서울특별시 도봉구", 1132000000L);
		map.put("서울특별시 노원구", 1135000000L);
		map.put("서울특별시 중랑구", 1126000000L);
		map.put("서울특별시 동작구", 1159000000L);
		map.put("서울특별시 관악구", 1162000000L);
		// 부산광역시(완료)
		map.put("부산광역시 중구", 2611000000L);
		map.put("부산광역시 서구", 2614000000L);
		map.put("부산광역시 동구", 2617000000L);
		map.put("부산광역시 영도구", 2620000000L);
		map.put("부산광역시 부산진구", 2623000000L);
		map.put("부산광역시 동래구", 2626000000L);
		map.put("부산광역시 남구", 2629000000L);
		map.put("부산광역시 북구", 2632000000L);
		map.put("부산광역시 해운대구", 2635000000L);
		map.put("부산광역시 사하구", 2638000000L);
		map.put("부산광역시 금정구", 2641000000L);
		map.put("부산광역시 강서구", 2644000000L); 
		map.put("부산광역시 연제구", 2647000000L);
		map.put("부산광역시 수영구", 2650000000L);
		map.put("부산광역시 사상구", 2653000000L);
		map.put("부산광역시 기장군", 2671000000L); 
		// 제주특별자치도(완료)
		map.put("제주특별자치도 서귀포시", 5013000000L); 
		map.put("제주특별자치도 이어도", 5019099000L); 
		map.put("제주특별자치도 제주시", 5011000000L); 
		// 대구광역시(완료)
		map.put("대구광역시 중구", 2711000000L);
		map.put("대구광역시 동구", 2714000000L); 
		map.put("대구광역시 서구", 2717000000L);
		map.put("대구광역시 남구", 2720000000L);
		map.put("대구광역시 북구", 2723000000L);
		map.put("대구광역시 수성구", 2726000000L);
		map.put("대구광역시 달서구", 2729000000L);
		map.put("대구광역시 달성군", 2771000000L); 
		// 인천광역시(완료)
		map.put("인천광역시 중구", 2811000000L);
		map.put("인천광역시 동구", 2814000000L);
		map.put("인천광역시 남구", 2817000000L);
		map.put("인천광역시 연수구", 2818500000L);
		map.put("인천광역시 남동구", 2820000000L); 
		map.put("인천광역시 부평구", 2823700000L);
		map.put("인천광역시 서구", 2826000000L);
		map.put("인천광역시 강화군", 2871000000L);
		map.put("인천광역시 옹진군", 2872000000L);
		map.put("인천광역시 계양구", 2824500000L);
		// 광주광역시(완료)
		map.put("광주광역시 동구", 2911000000L);
		map.put("광주광역시 서구", 2914000000L); 
		map.put("광주광역시 남구", 2915500000L);
		map.put("광주광역시 북구", 2917000000L);
		map.put("광주광역시 광산구", 2920000000L);
		// 대전광역시(완료)
		map.put("대전광역시 동구", 3011000000L);
		map.put("대전광역시 중구", 3014000000L);
		map.put("대전광역시 서구", 3017000000L); 
		map.put("대전광역시 유성구", 3020000000L);
		map.put("대전광역시 대덕구", 3023000000L);
		// 울산광역시
		map.put("울산광역시 중구", 3111000000L);
		map.put("울산광역시 남구", 3114000000L);
		map.put("울산광역시 동구", 3117000000L);
		map.put("울산광역시 북구", 3120000000L);
		map.put("울산광역시 울주군", 3171000000L); // way point
		// 경상남도
		map.put("경상남도 창원시", 4812000000L); // way point	
		map.put("경상남도 진주시", 4817000000L);
		map.put("경상남도 통영시", 4822000000L);
		map.put("경상남도 사천시", 4824000000L);
		map.put("경상남도 김해시", 4825000000L);
		map.put("경상남도 밀양시", 4827000000L);
		map.put("경상남도 거제시", 4831000000L);
		map.put("경상남도 양산시", 4833000000L);
		map.put("경상남도 의령군", 4872000000L);
		map.put("경상남도 함안군", 4873000000L);
		map.put("경상남도 창녕군", 4874000000L);
		map.put("경상남도 고성군", 4882000000L);
		map.put("경상남도 남해군", 4884000000L);
		map.put("경상남도 하동군", 4885000000L);
		map.put("경상남도 산청군", 4886000000L); // way point
		map.put("경상남도 함양군", 4887000000L);
		map.put("경상남도 거창군", 4888000000L);
		map.put("경상남도 합천군", 4889000000L);
		// 강원도
		map.put("강원도 춘천시", 4211000000L); // way point
		map.put("강원도 원주시", 4213000000L);
		map.put("강원도 강릉시", 4215000000L);
		map.put("강원도 동해시", 4217000000L);
		map.put("강원도 태백시", 4219000000L);
		map.put("강원도 속초시", 4221000000L); // way point
		map.put("강원도 삼척시", 4223000000L);
		map.put("강원도 홍천군", 4272000000L);
		map.put("강원도 횡성군", 4273000000L);
		map.put("강원도 영월군", 4275000000L);
		map.put("강원도 평창군", 4276000000L); // way point
		map.put("강원도 정선군", 4277000000L);
		map.put("강원도 철원군", 4278000000L);
		map.put("강원도 화천군", 4279000000L);
		map.put("강원도 양구군", 4280000000L);
		map.put("강원도 인제군", 4281000000L);
		map.put("강원도 고성군", 4282000000L);
		map.put("강원도 양양군", 4283000000L);
		// 경기도
		map.put("경기도 수원시", 4111000000L);
		map.put("경기도 성남시", 4113000000L);
		map.put("경기도 의정부시", 4115000000L);
		map.put("경기도 안양시", 4117000000L);
		map.put("경기도 부천시", 4119000000L);
		map.put("경기도 광명시", 4121000000L);
		map.put("경기도 평택시", 4122000000L);
		map.put("경기도 동두천시", 4125000000L); // way point
		map.put("경기도 파주시", 4148000000L);
		map.put("경기도 이천시", 4150000000L);
		map.put("경기도 안성시", 4155000000L);
		map.put("경기도 김포시", 4157000000L);
		map.put("경기도 화성시", 4159000000L);
		map.put("경기도 광주시", 4161000000L);
		map.put("경기도 양주시", 4163000000L);
		map.put("경기도 포천시", 4165000000L);
		map.put("경기도 과천시", 4129000000L);
		map.put("경기도 구리시", 4131000000L);
		map.put("경기도 남양주시", 4136000000L);
		map.put("경기도 오산시", 4137000000L);
		map.put("경기도 시흥시", 4139000000L);
		map.put("경기도 군포시", 4141000000L);
		map.put("경기도 의왕시", 4143000000L);
		map.put("경기도 하남시", 4145000000L);
		map.put("경기도 안산시", 4127000000L);
		map.put("경기도 고양시", 4128000000L);
		map.put("경기도 용인시", 4146000000L); // way point
		map.put("경기도 여주군", 4173000000L);
		map.put("경기도 연천군", 4180000000L);
		map.put("경기도 가평군", 4182000000L);
		map.put("경기도 양평군", 4183000000L);
		// 경상북도
		map.put("경상북도 포항시", 4711000000L);
		map.put("경상북도 경주시", 4713000000L); // way point
		map.put("경상북도 김천시", 4715000000L);
		map.put("경상북도 안동시", 4717000000L); // way point
		map.put("경상북도 구미시", 4719000000L);
		map.put("경상북도 영주시", 4721000000L);
		map.put("경상북도 영천시", 4723000000L);
		map.put("경상북도 상주시", 4725000000L);
		map.put("경상북도 문경시", 4728000000L);
		map.put("경상북도 경산시", 4729000000L);
		map.put("경상북도 군위군", 4772000000L);
		map.put("경상북도 의성군", 4773000000L);
		map.put("경상북도 청송군", 4775000000L);
		map.put("경상북도 영양군", 4776000000L);
		map.put("경상북도 영덕군", 4777000000L);
		map.put("경상북도 청도군", 4782000000L);
		map.put("경상북도 고령군", 4783000000L);
		map.put("경상북도 성주군", 4784000000L);
		map.put("경상북도 칠곡군", 4785000000L);
		map.put("경상북도 예천군", 4790000000L);
		map.put("경상북도 봉화군", 4792000000L);
		map.put("경상북도 울진군", 4793000000L);
		map.put("경상북도 울릉군", 4794000000L); // way point
		// 전라북도
		map.put("전라북도 전주시", 4511000000L); // way point
		map.put("전라북도 군산시", 4513000000L);
		map.put("전라북도 익산시", 4514000000L);
		map.put("전라북도 정읍시", 4518000000L);
		map.put("전라북도 남원시", 4519000000L);
		map.put("전라북도 김제시", 4521000000L);
		map.put("전라북도 완주군", 4571000000L);
		map.put("전라북도 진안군", 4572000000L);
		map.put("전라북도 무주군", 4573000000L);
		map.put("전라북도 장수군", 4574000000L);
		map.put("전라북도 임실군", 4575000000L);
		map.put("전라북도 순창군", 4577000000L); // way point
		map.put("전라북도 고창군", 4579000000L);
		map.put("전라북도 부안군", 4580000000L);
		// 전라남도
		map.put("전라남도 목포시", 4611000000L); // way point
		map.put("전라남도 여수시", 4613000000L);
		map.put("전라남도 순천시", 4615000000L); // way point
		map.put("전라남도 나주시", 4617000000L);
		map.put("전라남도 광양시", 4623000000L);
		map.put("전라남도 담양군", 4671000000L);
		map.put("전라남도 곡성군", 4672000000L);
		map.put("전라남도 구례군", 4673000000L);
		map.put("전라남도 고흥군", 4677000000L);
		map.put("전라남도 보성군", 4678000000L);
		map.put("전라남도 화순군", 4679000000L);
		map.put("전라남도 장흥군", 4680000000L);
		map.put("전라남도 강진군", 4681000000L);
		map.put("전라남도 해남군", 4682000000L);
		map.put("전라남도 무안군", 4684000000L);
		map.put("전라남도 영암군", 4683000000L);
		map.put("전라남도 함평군", 4686000000L);
		map.put("전라남도 영광군", 4687000000L);
		map.put("전라남도 장성군", 4688000000L);
		map.put("전라남도 완도군", 4689000000L);
		map.put("전라남도 진도군", 4690000000L);
		map.put("전라남도 신안군", 4691000000L);
		// 충청북도
		map.put("충청북도 청주시", 4311000000L);
		map.put("충청북도 충주시", 4313000000L); // way point
		map.put("충청북도 제천시", 4315000000L);
		map.put("충청북도 청원군", 4371000000L);
		map.put("충청북도 보은군", 4372000000L);
		map.put("충청북도 옥천군", 4373000000L);
		map.put("충청북도 영동군", 4374000000L); // way point
		map.put("충청북도 증평군", 4374500000L);
		map.put("충청북도 진천군", 4375000000L);
		map.put("충청북도 괴산군", 4376000000L);
		map.put("충청북도 음성군", 4377000000L);
		map.put("충청북도 단양군", 4380000000L);
		// 충청남도
		map.put("충청남도 천안시", 4413000000L);
		map.put("충청남도 공주시", 4415000000L);
		map.put("충청남도 보령시", 4418000000L);
		map.put("충청남도 아산시", 4420000000L); // way point
		map.put("충청남도 서산시", 4421000000L);
		map.put("충청남도 논산시", 4423000000L); // way point
		map.put("충청남도 계룡시", 4425000000L);
		map.put("충청남도 당진시", 4427000000L);
		map.put("충청남도 금산군", 4471000000L);
		map.put("충청남도 부여군", 4476000000L);
		map.put("충청남도 서천군", 4477000000L);
		map.put("충청남도 청양군", 4479000000L);
		map.put("충청남도 홍성군", 4480000000L);
		map.put("충청남도 예산군", 4481000000L);
		map.put("충청남도 태안군", 4482500000L);
		map.put("충청남도 연기군", 3600000000L);
	}

	public Long searchLocation() {
		return map.get(location);
	}
}