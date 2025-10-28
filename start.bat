@echo off
echo 🩸 Blood Donation App - Docker Setup
echo ====================================

:: Check if Docker is running
docker info >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Docker is not running. Please start Docker and try again.
    pause
    exit /b 1
)

:: Check docker-compose availability
docker-compose --version >nul 2>&1
if %errorlevel% neq 0 (
    docker compose version >nul 2>&1
    if %errorlevel% neq 0 (
        echo ❌ Docker Compose is not available. Please install Docker Compose.
        pause
        exit /b 1
    )
    set COMPOSE_CMD=docker compose
) else (
    set COMPOSE_CMD=docker-compose
)

echo 🐳 Using: %COMPOSE_CMD%

:: Build and start services
echo 📦 Building and starting services...
%COMPOSE_CMD% down --remove-orphans
%COMPOSE_CMD% build --no-cache
%COMPOSE_CMD% up -d

:: Wait for services to be ready
echo ⏳ Waiting for services to be ready...
timeout /t 10 /nobreak >nul

:: Check service status
echo 📊 Service Status:
%COMPOSE_CMD% ps

echo.
echo 🚀 Application should be available at:
echo    Frontend: http://localhost:3000
echo    Backend API: http://localhost:8080
echo    Database: localhost:5432
echo.
echo 📝 To view logs: %COMPOSE_CMD% logs -f
echo 🛑 To stop: %COMPOSE_CMD% down
echo.
pause