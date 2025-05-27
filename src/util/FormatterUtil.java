package util;

public class FormatterUtil {

	public static String phoneFormatter(String phone) {
		String digits = phone.replaceAll("\\D", "");
		if (digits.length() == 11) {
			return digits.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
		} else {
			return null;
		}
	}

	public static String yearFormatter(String date) {
		String digits = date.replaceAll("\\D", "");
		if (digits.length() == 8) {
			return digits.replaceFirst("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3");
		} else {
			return null;
		}
	}
}
