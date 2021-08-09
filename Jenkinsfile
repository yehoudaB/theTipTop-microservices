pipeline {
  agent any

  parameters {
    booleanParam(
      name: 'DEPLOY_IN_PROD',
      description: 'deploy in production ?',
      defaultValue: false,
    )
  }

  stages {
    stage('checkout') {
      steps {
        cleanWs()
        deleteDir()
        checkout scm
      }
    }

    stage('install compose') {
      steps {
        sh '''
            #les 3 prochaine lignes doivent etre conditionnel ou alors les faire lors de la constrution de l\'image jenkins
            apt-get install sudo -y
            sudo curl -L "https://github.com/docker/compose/releases/download/1.29.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
            sudo chmod +x /usr/local/bin/docker-compose
            docker-compose --version'''
      }
    }

    stage('maven install and docker-compose up (deploy into tomcat)') {
      steps {
        withMaven(maven: 'maven3') {
          script {
            if (params.DEPLOY_IN_PROD) {
              pom = readMavenPom file: 'pom.xml'
              echo "deploying in prod : ${params.DEPLOY_IN_PROD}"
              sh "curl -H 'Accept: application/zip'  --user admin:cYs3kfqCN25Xdu https://nexus.dsp4-5archio19-ah-je-gh-yb.fr/repository/theTipTop_microservice/com/dsp/theTipTop/${pom.version}/theTipTop-${pom.version}.war -o theTipTop.war"
              sh '/usr/local/bin/docker-compose -f docker-compose.yml -f docker-compose-prod.yml --env-file ./environments/.env.prod up -d --no-deps --build  --force-recreate'
            } else {
              echo "deploying in prod : ${params.DEPLOY_IN_PROD}"

              if (env.BRANCH_NAME == 'dev') {
                sh '''
                    mvn clean  install package   -Dmaven.test.skip=true -Pdev
                    ls -a
                    '''
                sh '''
                      docker-compose -f docker-compose-dev.yml --env-file ./environments/.env.dev up -d --no-deps --build --force-recreate
                      '''
                } else {
                sh '''
                    mvn clean  install package   -Dmaven.test.skip=true -Pprod
                    ls -a
                    '''
                sh '''
                    docker-compose -f docker-compose.yml -f docker-compose-stage.yml --env-file ./environments/.env.stage up -d --no-deps --build --force-recreate
                    '''
              }
            }
          }
        }
      }
    }

    stage('tests') {
      parallel {
        stage('test JUnit') {
          steps {
            withMaven(maven: 'maven3') {
              sh 'mvn  test -Pprod'
            }
          }
          post {
            always {
              junit 'target/surefire-reports/**/*.xml'
            }
          }
        }

        stage('build && SonarQube analysis') {
          steps {
            withSonarQubeEnv(installationName: 'sonarqube', credentialsId: 'tokenB') {
              withMaven(maven: 'maven3') {
                sh 'mvn sonar:sonar'
              }
            }
          }
        }
      }
    }

    stage('Deploy Artifact To Nexus') {
      when {
        allOf {
          branch 'master'
          expression { !params.DEPLOY_IN_PROD }
        }
      }
      steps {
        sh '''cd target/
        ls -a'''

        script {
          pom = readMavenPom file: 'pom.xml'
          // Find built artifact under target folder
          filesByGlob = './'
          // Print some info from the artifact found
          // echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
          // Extract the path from the File found
          artifactPath = './'
          // Assign to a boolean response verifying If the artifact name exists
          artifactExists = fileExists artifactPath
          if (artifactExists) {
            nexusArtifactUploader(
              nexusVersion: 'nexus3',
              protocol: 'https',
              nexusUrl: 'nexus.dsp4-5archio19-ah-je-gh-yb.fr',
              groupId: pom.groupId,
              version: pom.version,
              repository: 'theTipTop_microservice/',
              credentialsId: 'nexus3',
              artifacts: [
                // Artifact generated such as .jar, .ear and .war files.
                [
                  artifactId: pom.artifactId,
                  classifier: '',
                  file: artifactPath,
                  type: pom.packaging
                ],
                // Lets upload the pom.xml file for additional information for Transitive dependencies
                [
                  artifactId: pom.artifactId,
                  classifier: '',
                  file: 'pom.xml',
                  type: 'pom'
                ],
                [
                  artifactId: pom.artifactId,
                  classifier: '',
                  file: './target/theTipTop.war',
                  type: 'war'
                ]
              ]
            )
          }
          else {
            error "*** File: ${artifactPath}, could not be found"
          }
        }
      }
    }
  }
}
