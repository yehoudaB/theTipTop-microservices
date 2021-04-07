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
        sh '/app/scripts/buildWebsite.sh'
      }
    }

    stage('deploy website') {
      steps {
        sh '/app/scripts/buildWebsite.sh'
      }
    }

  }
}