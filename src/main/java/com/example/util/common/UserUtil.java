package com.example.util.common;

public class UserUtil {

	public static Long getLevelExps(int level){

		if (level < 1) {
			return 0L;
		} else if (level >= 500) {
			return 1000000000L;
		}
		for (int i = 0; i < Enums.levels.length; i++) {
			if (level > Enums.levels[i] && level <= Enums.levels[i + 1]) {
				long tmp = (Enums.exps[i + 1] - Enums.exps[i]) / (Enums.levels[i + 1] - Enums.levels[i]);
				tmp = (tmp / 10) * 10;
				long exp = Enums.exps[i];
				for (int j = Enums.levels[i] + 1; j <= Enums.levels[i + 1]; j++) {
					if (level == j) {
						return exp;
					}
					exp += tmp;
				}
			}
		}
		return 1000000000L;
	}
	
	
}
