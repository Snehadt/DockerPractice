pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t='632636/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'Jenkins@2016', usernameVariable: 'Snehadt')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push 632636/selenium-docker:latest"
			    }                           
            }
        }
    }
}