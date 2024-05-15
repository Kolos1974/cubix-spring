package hu.cubix.hr.kolos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import hu.cubix.hr.kolos.config.HrConfigurationProperties.RaiseSalary;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigurationProperties {

	// Itt példányosítanom kellett az osztályt!!
	private RaiseSalary raiseSalary = new RaiseSalary();

	public RaiseSalary getRaiseSalary() {
		return raiseSalary;
	}

	public void setRaiseSalary(RaiseSalary raiseSalary) {
		this.raiseSalary = raiseSalary;
	}

	
	public class RaiseSalary {

		// Itt példányosítanom kellett az osztályokat!!
		private DefaultValues defaultValues = new DefaultValues();
		private SmartValues smartValues = new SmartValues();
		
		public DefaultValues getDefaultValues() {
			return defaultValues;
		}
		public void setDefaultValues(DefaultValues defaultValues) {
			this.defaultValues = defaultValues;
		}
		public SmartValues getSmartValues() {
			return smartValues;
		}
		public void setSmartValues(SmartValues smartValues) {
			this.smartValues = smartValues;
		}
		
		public class DefaultValues {

			private int percent;

			public int getPercent() {
				return percent;
			}

			public void setPercent(int percent) {
				this.percent = percent;
			}
			
		}

		
		public class SmartValues {

			private float interval1year;
			private int interval1percent;
			private float interval2year;
			private int interval2percent;
			private float interval3year;
			private int interval3percent;
			private float interval4year;
			private int interval4percent;
			
			
			public float getInterval1year() {
				return interval1year;
			}
			public void setInterval1year(float interval1year) {
				this.interval1year = interval1year;
			}
			public int getInterval1percent() {
				return interval1percent;
			}
			public void setInterval1percent(int interval1percent) {
				this.interval1percent = interval1percent;
			}
			public float getInterval2year() {
				return interval2year;
			}
			public void setInterval2year(float interval2year) {
				this.interval2year = interval2year;
			}
			public int getInterval2percent() {
				return interval2percent;
			}
			public void setInterval2percent(int interval2percent) {
				this.interval2percent = interval2percent;
			}
			public float getInterval3year() {
				return interval3year;
			}
			public void setInterval3year(float interval3year) {
				this.interval3year = interval3year;
			}
			public int getInterval3percent() {
				return interval3percent;
			}
			public void setInterval3percent(int interval3percent) {
				this.interval3percent = interval3percent;
			}
			public float getInterval4year() {
				return interval4year;
			}
			public void setInterval4year(float interval4year) {
				this.interval4year = interval4year;
			}
			public int getInterval4percent() {
				return interval4percent;
			}
			public void setInterval4percent(int interval4percent) {
				this.interval4percent = interval4percent;
			}
			
			
		}
		
		
	}
	
	
	
}
