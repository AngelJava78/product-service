pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package -Dmaven.test.skip=true'
      }
      post {
        success {
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('install') {
      steps {
        sh 'mvn install'
      }
    }

    stage('Create docker image') {
      steps {
        sh 'docker build -t product-service:latest .'

      }
    }

    stage('Create docker tag') {
      steps {
        sh 'docker tag product-service:latest angeljava/product-service:latest'
      }
    }

    stage('Docker push') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'user-for-docker-hub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]){
          sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
          sh 'docker push angeljava/product-service:latest'
        }
      }
    }

//     stage('Deploy on minikube') {
//       steps {
//         sh 'kubectl apply -f ./Kubernetes/deploy.yaml --validate=false'
//       }
//     }

  }


}