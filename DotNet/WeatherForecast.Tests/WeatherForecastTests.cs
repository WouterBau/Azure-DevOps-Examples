using Xunit;
using WeatherForecast.WebApi;

namespace WeatherForecast.Tests
{
    public class WeatherForecastTests
    {
        [Theory]
        [InlineData(0, 32)]
        [InlineData(15, 59)]
        public void ConvertTemperature(int input, int expected)
        {
            var forecast = new Forecast
            {
                TemperatureC = input
            };
            var actual = forecast.TemperatureF;
            Assert.Equal(expected, actual);
        }
    }
}