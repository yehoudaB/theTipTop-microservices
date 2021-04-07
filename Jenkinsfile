node {
  stages {
    stage('checkout') {
      deleteDir()
      checkout scm
    }

    stage('ls-la') {
      sh 'ls-la'
    }

    stage('docker ps') {
      sh 'docker ps'
    }
  
  }
}


/* pipeline {
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
} */