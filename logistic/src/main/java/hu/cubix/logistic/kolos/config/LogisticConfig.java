package hu.cubix.logistic.kolos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "logistic")
@Component
public class LogisticConfig {

	private Delay delay;

	public Delay getDelay() {
		return delay;
	}

	public void setDelay(Delay delay) {
		this.delay = delay;
	}

	public static class Delay {
		private double min30;
		private double min60;
		private double min120;

		public double getMin30() {
			return min30;
		}

		public void setMin30(double min30) {
			this.min30 = min30;
		}

		public double getMin60() {
			return min60;
		}

		public void setMin60(double min60) {
			this.min60 = min60;
		}

		public double getMin120() {
			return min120;
		}

		public void setMin120(double min120) {
			this.min120 = min120;
		}

	}

}
