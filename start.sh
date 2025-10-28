#!/bin/bash

echo "🩸 Blood Donation App - Docker Setup"
echo "===================================="

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker is not running. Please start Docker and try again."
    exit 1
fi

# Check if docker-compose is available
if ! command -v docker-compose &> /dev/null; then
    if ! command -v docker &> /dev/null || ! docker compose version &> /dev/null; then
        echo "❌ Docker Compose is not available. Please install Docker Compose."
        exit 1
    fi
    COMPOSE_CMD="docker compose"
else
    COMPOSE_CMD="docker-compose"
fi

echo "🐳 Using: $COMPOSE_CMD"

# Build and start services
echo "📦 Building and starting services..."
$COMPOSE_CMD down --remove-orphans
$COMPOSE_CMD build --no-cache
$COMPOSE_CMD up -d

# Wait for services to be ready
echo "⏳ Waiting for services to be ready..."
sleep 10

# Check service status
echo "📊 Service Status:"
$COMPOSE_CMD ps

echo ""
echo "🚀 Application should be available at:"
echo "   Frontend: http://localhost:3000"
echo "   Backend API: http://localhost:8080"
echo "   Database: localhost:5432"
echo ""
echo "📝 To view logs: $COMPOSE_CMD logs -f"
echo "🛑 To stop: $COMPOSE_CMD down"