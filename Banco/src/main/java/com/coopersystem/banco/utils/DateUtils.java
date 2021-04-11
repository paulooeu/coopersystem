package com.coopersystem.banco.utils;

import com.coopersystem.banco.error.ResourceNotAcceptableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	public static boolean dataUtilValida(LocalDate date) {
		boolean validacao = false;
		if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
			validacao = true;
		}
		return validacao;
	}

	public static LocalDate getUltimoDiaUtil(LocalDate date) {
		boolean condicao = true;
		while (condicao) {
			if (DateUtils.dataUtilValida(date)) {
				condicao = false;
			} else {
				date = date.minusDays(1);
			}
		}
		return date;
	}

	public static String formatarDataParaUS(LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		return localDate.format(formatter);
	}

	public static LocalDate formatarDataBrParaLocalDate(String date) {
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = LocalDate.parse(date, formato);
			return data;
		} catch (DateTimeParseException e) {
			LOGGER.error(e.getMessage());
			throw new ResourceNotAcceptableException("Por favor, informe uma data válida no formato dd/MM/yyyy");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new ResourceNotAcceptableException(e.getMessage());
		}

	}
}
