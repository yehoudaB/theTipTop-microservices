pipeline {
  agent any
  stages {
  
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