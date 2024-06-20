package com.jack.endroid.core.javabasic.annotation;

import androidx.annotation.NonNull;

@CustomizedAnnotation(0)
public class AnnotationTester {
	private String data;

	@CustomizedAnnotation(value = 0, id = "y")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@NonNull
	@Override
	public String toString() {
		return super.toString();
	}
}
