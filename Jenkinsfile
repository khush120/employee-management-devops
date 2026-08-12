pipeline {
    agent any

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9'
    }

    environment {
        IMAGE_NAME = 'employee-app:latest'
        CONTAINER_NAME = 'employee-app-container'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out develop branch...'
                git branch: 'develop',
                    url: 'https://github.com/khush120/employee-management-devops.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building application and running tests...'
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                bat '''
                    docker stop %CONTAINER_NAME% 2>NUL || exit /b 0
                    docker rm %CONTAINER_NAME% 2>NUL || exit /b 0
                    docker run -d -p 8081:8081 --name %CONTAINER_NAME% %IMAGE_NAME%
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Docker deployment was not completed.'
        }
    }
}
