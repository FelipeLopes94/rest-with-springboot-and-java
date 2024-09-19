package br.com;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController

public class MathController {

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

	private Double convertToDouble(String paramNumber) {
		if (paramNumber == null) return 0D;

		String number = paramNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private Boolean isNumeric(String paramNumber) {
		if (paramNumber == null) return false;

		String number = paramNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
