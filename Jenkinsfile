pipeline {
  agent any
  stages {
    stage('build website') {
      steps {
        sh 'ls -a'
      }
    }

    stage('run unit tests') {
      steps {
        sh 'ls -a'
      }
    }

    stage('deploy website') {
      steps {
        sh '''#/app/scripts/buildWebsite.sh
ls -a'''
      }
    }

  }
}