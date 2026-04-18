pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "meraaz0809/springboot-app"
        EC2_IP = "98.86.244.134"
    }

    stages {

        stage('Clone Code') {
            steps {
                git credentialsId: 'github-creds',
                    url: 'https://github.com/mohd-meraaz/QuantityMeasurementApp.git',
                    branch: 'main'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no ec2-user@${EC2_IP} '
                            docker pull ${DOCKER_IMAGE} &&
                            docker stop myapp || true &&
                            docker rm myapp || true &&
                            docker run -d -p 8081:8080 --name myapp ${DOCKER_IMAGE}
                        '
                    """
                }
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completed! App running on http://98.86.244.134:8081'
        }
        failure {
            echo '❌ Pipeline failed! Check console output for details.'
        }
    }
}