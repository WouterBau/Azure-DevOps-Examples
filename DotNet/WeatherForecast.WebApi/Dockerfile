FROM mcr.microsoft.com/dotnet/core/aspnet:3.1 AS base
WORKDIR /app
EXPOSE 80

FROM mcr.microsoft.com/dotnet/core/sdk:3.1 AS build
WORKDIR /src
COPY ["DotNet/WeatherForecast.WebApi/WeatherForecast.WebApi.csproj", "DotNet/WeatherForecast.WebApi/"]
RUN dotnet restore "DotNet/WeatherForecast.WebApi/WeatherForecast.WebApi.csproj"
COPY . .
WORKDIR "/src/DotNet/WeatherForecast.WebApi"
RUN dotnet build "WeatherForecast.WebApi.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "WeatherForecast.WebApi.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "WeatherForecast.WebApi.dll"]
