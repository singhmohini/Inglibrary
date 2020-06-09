pipeline {
   agent any
	stages {
      stage('Git Checkout') {
         steps {            
            git 'https://github.com/singhmohini/Inglibrary.git'
		}
	}
	stage('Build Analysis') {
		steps {
			withSonarQubeEnv('sonar') {
				sh '/opt/maven/bin/mvn clean verify sonar:sonar -Dsonar.password=admin -Dsonar.login=admin -Dmaven.test.skip=true'
			}
		}
	}
	stage("Quality Gate") {
            steps {
              timeout(time: 2, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
	}}
