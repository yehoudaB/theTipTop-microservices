pipeline {
  agent any
  stages {
    stage('test if docker-compose') {
      parallel {
        stage('deploy') {
          steps {
            sh 'docker-compose --version'
          }
        }

        stage('install docker-compose') {
          steps {
            sh '''apt-get install sudo -y
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose --version'''
          }
        }

      }
    }

    stage('deploy website') {
      steps {
        sh '''
docker-compose --env-file ./environements/.env.prod up -d'''
      }
    }

  }
}