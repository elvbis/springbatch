package com.demo.springbatch.common;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberUtil {

	private static final Logger LOGGER = Logger.getLogger(NumberUtil.class);
	
	public static BigDecimal precisionTobigdecimalScale(String amount, int precision) {
		BigDecimal amountWtDecimal = new BigDecimal(amount);
		BigDecimal scaledAmount = amountWtDecimal.setScale(precision, RoundingMode.HALF_UP);
		return scaledAmount;
	}

	public static String formatCurrencyLocale(String amount) {

		double result = Double.parseDouble(amount);
		Locale locale = new Locale("es", "ES");
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		DecimalFormat formatDecimal = new DecimalFormat("#,##0.00", symbols);
		formatDecimal.setRoundingMode(RoundingMode.HALF_UP);
		return formatDecimal.format(result);

	}

	public static String fullRightZero(String monto, int zeroLenght){
		BigDecimal modal = new BigDecimal(monto).setScale(zeroLenght);
		return modal.toString();
	}

	public static String fullLefthZero(String monto, int zeroLenght){
		return String.format("%0"+zeroLenght+"d", Long.parseLong(monto));
	}
}
