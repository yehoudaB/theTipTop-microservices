pipeline {
  agent any
  stages {
    stage('deploy') {
      steps {
        sh 'cd /theTipTop/api/ && ls -a'
      }
    }

    stage('deploy website') {
      steps {
        sh 'docker ps'
      }
    }

  }
}