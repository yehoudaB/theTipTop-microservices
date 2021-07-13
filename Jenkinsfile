pipeline {
    agent {
    label 'docker' 
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
    
    stage('SonarQube analysis') {
    	agent {
        	docker {
          	// Set both label and image
          	label 'docker'
          	image 'maven:3-alpine'
        	}
      	}
	  	steps {
	    	// Steps run in maven:3-alpine docker container on docker slave
	    	sh 'mvn --version'
	  
   			sh 'mvn sonar:sonar \
  			-Dsonar.host.url=https://sonarqube.dsp4-5archio19-ah-je-gh-yb.fr \
  			-Dsonar.login=f3ff7b49060985dcd3d592299f9b76a6638e18ae'
   		}
  	}

    stage('docker-compose up') {
      steps {
      sh '''
			docker-compose --env-file ./environements/.env.prod up -d --no-deps --build'''
      }
    }

    stage('Deploy Artifact To Nexus') {
      when {
        branch 'master'
      }
      steps {
        script {
          //unstash 'pom'
          //unstash 'artifact'
          // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps
          pom = readMavenPom file: "pom.xml";
          // Find built artifact under target folder
          filesByGlob = './'
          // Print some info from the artifact found
          //echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
          // Extract the path from the File found
          artifactPath = './';
          // Assign to a boolean response verifying If the artifact name exists
          artifactExists = fileExists artifactPath;
          if (artifactExists) {
            nexusArtifactUploader(
            nexusVersion: 'nexus3',
            protocol: 'https',
            nexusUrl: 'nexus.dsp4-5archio19-ah-je-gh-yb.fr',
            groupId: pom.groupId,
            version: pom.version,
            repository: 'theTipTop_microservice',
            credentialsId: 'nexus3',
            artifacts: [
              // Artifact generated such as .jar, .ear and .war files.
              [artifactId: pom.artifactId,
              classifier: '',
              file: artifactPath,
              type: pom.packaging
              ],
              // Lets upload the pom.xml file for additional information for Transitive dependencies
              [artifactId: pom.artifactId,
              classifier: '',
              file: "pom.xml",
              type: "pom"
              ]
            ]
            )
          } else {
            error "*** File: ${artifactPath}, could not be found";
          }
        }
      }
    }
   
  }
}