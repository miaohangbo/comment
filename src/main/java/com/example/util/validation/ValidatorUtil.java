package com.example.util.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidatorUtil {
	
	private static Validator validator;

	static {
		if (validator == null) {
			synchronized (Validator.class) {
				if (validator == null) {
					ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
					validator = factory.getValidator();
				}
			}
		}
	}

	public static String validateResult(Object o, Class<?> clazz,
			Class<?>... aclass) {
		Set<ConstraintViolation<?>> set = validate(o, aclass);
		StringBuffer sb = new StringBuffer();
		if ((set != null) && (set.size() > 0)) {
			for (ConstraintViolation<?> cv : set) {
				sb.append(cv.getMessage()).append("；");
			}
		}
		return sb.toString();
	}

	public static Validator getValidator() {
		return validator;
	}

	public static Set validate(Object obj, Class<?>... aclass) {
		return validator.validate(obj, aclass);
	}

	public static Set validateProperty(Object obj, String s, Class... aclass) {
		return validator.validateProperty(obj, s, aclass);
	}

	public static Set validateValue(Class class1, String s, Object obj,
			Class... aclass) {
		return validator.validateValue(class1, s, obj, aclass);
	}
}
