# Blood Donation Web Application 

A comprehensive blood donation management system built with Spring Boot backend and Angular frontend.

## Architecture

- **Backend**: Spring Boot 3.5.6 with Java 17
- **Frontend**: Angular 19 with Bootstrap 5
- **Database**: PostgreSQL 15
- **Containerization**: Docker & Docker Compose


### Option 2: Manual Docker Compose

```bash
# Build and start all services
docker-compose up --build -d

# View logs
docker-compose logs -f

# Stop services
docker-compose down
```

## Access Points

After starting the containers:

- **Frontend Application**: http://localhost:3000
- **Backend API**: http://localhost:8080
- **PostgreSQL Database**: localhost:5432
  - Username: `admin`
  - Password: `admin`
  - Database: `donation`
```
### Frontend Development
```bash
cd frontend
npm install
npm start
```

## Docker Services

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

## Configuration

### Docker Compose Networks
All services communicate through the `blood-donation-network` bridge network.


## Stopping the Application

```bash
docker-compose down
```

To remove volumes as well:
```bash
docker-compose down -v
```