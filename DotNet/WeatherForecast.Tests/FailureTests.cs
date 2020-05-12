using Xunit;

namespace WeatherForecast.Tests
{
    public class FailureTests
    {
        [Fact]
        public void Failure()
        {
            Assert.True(false);
        }
    }
}
