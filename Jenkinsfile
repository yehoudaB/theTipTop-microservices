pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
         deleteDir()
         checkout scm
      }
    }

    stage('ls -la') {
      steps {
        sh 'ls -la'
      }
    }

    stage('deploy website') {
      steps {
        sh 'docker ps'
      }
    }

  }
}