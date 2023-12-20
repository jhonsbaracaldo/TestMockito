package org.adaschool.Weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyDouble;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class WeatherApplicationTests {

	@Mock
	private WeatherReportService weatherReportService;

	@InjectMocks
	private WeatherReportController weatherReportController;

	@Test
	void getWeatherReportTest() {
		double latitude = 1.0;
		double longitude = 2.0;
		WeatherReport expectedReport = new WeatherReport();
		when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(expectedReport);
		WeatherReport actualReport = weatherReportController.getWeatherReport(latitude, longitude);
		verify(weatherReportService, times(1)).getWeatherReport(latitude, longitude);
		assertEquals(expectedReport, actualReport);
	}
}