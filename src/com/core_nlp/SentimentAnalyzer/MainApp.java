package com.core_nlp.SentimentAnalyzer;

import java.io.IOException;

import com.core_nlp.model.SentimentResult;

public class MainApp {

	public static void main(String[] args) throws IOException {

		// start testing the result accuracy

		String[] sentences = {
				"I had very wonderful day today.",
				"This movie is absolutely fantastic!",
				"The weather is perfect for a picnic.",
				"I feel so grateful for all the support I've received.",
				"The food at that restaurant was terrible.",
				"This book is incredibly boring.",
				"I'm really excited about the upcoming vacation.",
				"The customer service was excellent, and I received quick assistance.",
				"I can't stand the traffic during rush hour.",
				"Losing my phone was such a frustrating experience."
		};

		String[] sentiments = {
				"Very positive",
				"Very positive",
				"Positive",
				"Positive",
				"Negative",
				"Negative",
				"Positive",
				"Positive",
				"Negative",
				"Negative"
		};

		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		sentimentAnalyzer.initialize();

		// Access the sentences and their sentiments in parallel
		for (int i = 0; i < sentences.length; i++) {

			SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(sentences[i]);
			System.out.println("Sentence: " + sentences[i]);
			System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
			System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
			System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive() + "%");
			System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive() + "%");
			System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral() + "%");
			System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative() + "%");
			System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative() + "%");
			System.out.println("Expected Result Sentiment: " + sentiments[i]);
			System.out.println("Expected Result Found: " + sentiments[i].equals(sentimentResult.getSentimentType()));

			System.out.println();
		}

	}

}
