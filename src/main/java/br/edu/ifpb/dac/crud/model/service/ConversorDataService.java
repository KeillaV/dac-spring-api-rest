package br.edu.ifpb.dac.crud.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ConversorDataService {
	
	public Date converterData(String data) {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		formatoData.setLenient(false);
		
		try {
			Date dataConvertida = formatoData.parse(data);
			return dataConvertida;
		} catch (ParseException e) {
			System.out.println("Não foi possível converter a data!");
		}
		
		return null;
	}

}
