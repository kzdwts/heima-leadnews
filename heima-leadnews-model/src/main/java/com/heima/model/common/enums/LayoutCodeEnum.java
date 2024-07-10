package com.heima.model.common.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum LayoutCodeEnum {
	ENUM0(0, "无图文章"),
	ENUM1(1, "单图文章"),
	ENUM2(2, "多图文章");

	private final Integer code;
	private final String desc;

	public static LayoutCodeEnum getEnumByCode(Integer code) {
		for (LayoutCodeEnum e : LayoutCodeEnum.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 