package br.edu.ifpb.dac.crud.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.crud.exception.TimeParseException;

@Service
public class ConversorDataService {
	
	public Date converterData(String date) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		try {
			Date dataConvertida = dateFormat.parse(date);
			return dataConvertida;
		} catch (ParseException e) {
			throw new TimeParseException(date);
		}
	}
}
