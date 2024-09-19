package br.com;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController

public class MathController {

	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)

	public Double sum(

			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo

	) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}

		return convertToDouble(numberOne) + convertToDouble(numberTwo);

	}

	private Double convertToDouble(String numero) {
		return Double.parseDouble(numero);
	}

	private Boolean isNumeric(String number) {
		return false;

	}
}
