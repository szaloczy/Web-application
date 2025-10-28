# Blood Donation Web Application 🩸

A comprehensive blood donation management system built with Spring Boot backend and Angular frontend.

## 🏗️ Architecture

- **Backend**: Spring Boot 3.5.6 with Java 17
- **Frontend**: Angular 19 with Bootstrap 5
- **Database**: PostgreSQL 15
- **Containerization**: Docker & Docker Compose

## 🚀 Quick Start with Docker

### Prerequisites
- Docker Desktop installed and running
- Docker Compose (included with Docker Desktop)

### Option 1: Using the startup script (Recommended)

**Windows:**
```bash
start.bat
```

**Linux/macOS:**
```bash
chmod +x start.sh
./start.sh
```

### Option 2: Manual Docker Compose

```bash
# Build and start all services
docker-compose up --build -d

# View logs
docker-compose logs -f

# Stop services
docker-compose down
```

## 🌐 Access Points

After starting the containers:

- **Frontend Application**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **PostgreSQL Database**: localhost:5432
  - Username: `admin`
  - Password: `admin`
  - Database: `donation`

## 📂 Project Structure

```
├── blood-donation/          # Spring Boot Backend
│   ├── src/
│   ├── Dockerfile
│   ├── pom.xml
│   └── docker-compose.yml
├── frontend/                # Angular Frontend
│   ├── src/
│   ├── Dockerfile
│   ├── nginx.conf
│   └── package.json
├── docker-compose.yml       # Main compose file
├── start.sh                 # Linux/macOS startup script
└── start.bat                # Windows startup script
```

## 🛠️ Development

### Backend Development
```bash
cd blood-donation
./mvnw spring-boot:run
```

### Frontend Development
```bash
cd frontend
npm install
npm start
```

## 🐳 Docker Services

### Database (PostgreSQL)
- **Image**: postgres:15-alpine
- **Port**: 5432
- **Health Check**: Included

### Backend (Spring Boot)
- **Build**: Multi-stage Docker build
- **Port**: 8080
- **Health Check**: Spring Actuator endpoint

### Frontend (Angular + Nginx)
- **Build**: Multi-stage Docker build (Node.js + Nginx)
- **Port**: 80 (mapped to 3000)
- **Proxy**: API calls proxied to backend

## 🔧 Configuration

### Environment Variables
- `SPRING_DATASOURCE_URL`: Database connection URL
- `SPRING_DATASOURCE_USERNAME`: Database username
- `SPRING_DATASOURCE_PASSWORD`: Database password
- `SPRING_PROFILES_ACTIVE`: Active Spring profile

### Docker Compose Networks
All services communicate through the `blood-donation-network` bridge network.

## 📝 Logs

View service logs:
```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f db
```

## 🛑 Stopping the Application

```bash
docker-compose down
```

To remove volumes as well:
```bash
docker-compose down -v
```

## 🔍 Troubleshooting

### Common Issues

1. **Port conflicts**: Make sure ports 3000, 8080, and 5432 are not in use
2. **Docker not running**: Ensure Docker Desktop is started
3. **Build failures**: Try `docker-compose build --no-cache`

### Health Checks

Check service health:
```bash
docker-compose ps
```

### Database Connection

Connect to PostgreSQL:
```bash
docker-compose exec db psql -U admin -d donation
```