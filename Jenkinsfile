pipeline {
  agent any
  stages {
    stage('deploy') {
      steps {
        sh '''ls -a
docker-compose --env-file ./environements/.env.prod up -d'''
      }
    }

    stage('deploy website') {
      steps {
        sh 'docker ps'
      }
    }

  }
}