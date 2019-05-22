package br.farn.folhacomercial.eco.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarUtils {

	public static boolean isWeekend(Calendar cal) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
	}

	public static boolean isWeekend(Date data) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(data);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
	}

	public static Date adicionaMeses(Date data, Integer qtdMeses) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MONTH, qtdMeses);
		return c.getTime();
	}

	public static Date somaMeses(Date data, int qtdMeses) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.MONTH, qtdMeses);
		return c.getTime();
	}

	public static Date somaDia(Date data, int qtdDia) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DATE, qtdDia);
		return c.getTime();
	}

	public static Date gerarData(int dia, int mes, int ano) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, dia);
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);

		return c.getTime();
	}

	public static Date gerarData(String calendario, String pattern) {
		SimpleDateFormat formatador = new SimpleDateFormat(pattern);
		try {
			return (Date) formatador.parse(calendario);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String gerarData(Date calendario, String pattern) {
		Calendar cComp = Calendar.getInstance();

		cComp.setTime(calendario);
		int dia = cComp.get(Calendar.DATE);
		int mes = cComp.get(Calendar.MONTH);
		int ano = cComp.get(Calendar.YEAR);

		String dataPadrao = dia + "/" + mes + 1 + "/" + ano;

		SimpleDateFormat in = new SimpleDateFormat("d/M/yyyy");
		SimpleDateFormat out = new SimpleDateFormat(pattern);

		try {
			return out.format(in.parse(dataPadrao));
		} catch (ParseException e) {
			return null;
		}
	}

	public static String gerarDataString(Date calendario) {
		Calendar cComp = Calendar.getInstance();

		cComp.setTime(calendario);
		int dia = cComp.get(Calendar.DATE);
		int mes = cComp.get(Calendar.MONTH);
		int ano = cComp.get(Calendar.YEAR);

		String dataPadrao = dia + "/" + (mes + 1) + "/" + ano;

		return dataPadrao;
	}

	public static String gerarDataHoraString(Date calendario) {
		Calendar cComp = Calendar.getInstance();

		cComp.setTime(calendario);
		int dia = cComp.get(Calendar.DATE);
		int mes = cComp.get(Calendar.MONTH);
		int ano = cComp.get(Calendar.YEAR);

		int hora = cComp.get(Calendar.HOUR_OF_DAY);
		int min = cComp.get(Calendar.MINUTE);

		String dataPadrao = dia + "/" + (mes + 1) + "/" + ano + "-" + hora
				+ ":" + min;

		return dataPadrao;
	}

	public static boolean compararDataAnterior(Date dataAtual,
			Date dataComparacao) {
		Calendar cAtual = Calendar.getInstance();
		cAtual.setTime(dataAtual);

		Calendar cComparacao = Calendar.getInstance();
		cComparacao.setTime(dataComparacao);

		return (cAtual.before(cComparacao));
	}

	public static boolean comparaData(Date data, Date dataComparacao) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH);
		int ano = c.get(Calendar.YEAR);

		Calendar cComp = Calendar.getInstance();
		cComp.setTime(dataComparacao);
		int diaComp = cComp.get(Calendar.DAY_OF_MONTH);
		int mesComp = cComp.get(Calendar.MONTH);
		int anoComp = cComp.get(Calendar.YEAR);

		if ((dia == diaComp) && (mes == mesComp) && (ano == anoComp)) {
			return true;
		}

		return false;
	}

	public static Date descartarHoras(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);

		c.set(Calendar.AM_PM, Calendar.AM);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	public static Date incluirHoraFimDia(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);

		c.set(Calendar.AM_PM, Calendar.AM);
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);

		return c.getTime();
	}

	/**
	 * Método que calcula a Idade
	 * 
	 * @param dataNascimento
	 * @return
	 */
	public static String gerarIdade(Date dataNascimento) {

		GregorianCalendar hoje = new GregorianCalendar();
		GregorianCalendar nascimento = new GregorianCalendar();
		if (dataNascimento != null) {
			nascimento.setTime(dataNascimento);
		}
		int anohoje = hoje.get(Calendar.YEAR);
		int anoNascimento = nascimento.get(Calendar.YEAR);
		int idade = anohoje - anoNascimento;
		return new String("" + idade + "");
	}

	public static Date convertGregorianCalendarToDate(
			XMLGregorianCalendar gregorian) {
		return gregorian.toGregorianCalendar().getTime();
	}

	public static XMLGregorianCalendar convertDateToGregorianCalendar(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
		}
		return null;
	}
}
