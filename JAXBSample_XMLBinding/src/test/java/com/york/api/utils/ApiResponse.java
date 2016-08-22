package com.york.api.utils;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

	   @SerializedName("data")
	   private Data data;

	   private static class Data {
	      @SerializedName("translations")
	      public Translation[] translations;
	   }

	   private static class Translation {
	      @SerializedName("translatedText")
	      public String translatedText;
	   }

	   public String getTranslatedText() {
	      return data.translations[0].translatedText;
	   }
	}