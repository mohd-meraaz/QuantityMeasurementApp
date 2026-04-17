pipeline {
	agent any

	environment {
		DOCKER_IMAGE = "meraaz0809/springboot-app"
	}

	stages {

		stage('Clone Code') {
			steps {
				git credentialsId: 'github-creds', url: 'https://github.com/mohd-meraaz/QuantityMeasurementApp.git'
			}
		}

		stage('Build JAR') {
			steps {
				dir('A06_ServiceLayer') {
					sh 'mvn clean package -DskipTests'
				}
			}
		}

		stage('Build Docker Image') {
			steps {
				dir('A06_ServiceLayer') {
					sh 'docker build -t $DOCKER_IMAGE .'
				}
			}
		}

		stage('Push Docker Image') {
			steps {
				withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
					sh 'echo $PASS | docker login -u $USER --password-stdin'
				}
				sh 'docker push $DOCKER_IMAGE'
			}
		}

		stage('Deploy to EC2') {
                    steps {
                        sshagent(['ec2-ssh-key']) {
                            sh """
                                ssh -o StrictHostKeyChecking=no ec2-user@18.208.213.198  '
                                    docker pull ${DOCKER_IMAGE} &&
                                    docker stop myapp || true &&
                                    docker rm   myapp || true &&
                                    docker run -d -p 8081:8080 --name myapp ${DOCKER_IMAGE}
                                '
                            """
                        }
                    }
                }
	}
}