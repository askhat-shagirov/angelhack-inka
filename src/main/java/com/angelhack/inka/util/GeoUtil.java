package com.angelhack.inka.util;

public class GeoUtil {

	public static double getDistance(double lat1, double lon1, double lat2,	double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(decimalDegreeToRadian(lat1))
				* Math.sin(decimalDegreeToRadian(lat2))
				+ Math.cos(decimalDegreeToRadian(lat1))
				* Math.cos(decimalDegreeToRadian(lat2))
				* Math.cos(decimalDegreeToRadian(theta));
		dist = Math.acos(dist);
		dist = radianToDecimalDegree(dist);
		dist = dist * 60 * 1.1515;
		return dist;
	}

	private static double decimalDegreeToRadian(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double radianToDecimalDegree(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
